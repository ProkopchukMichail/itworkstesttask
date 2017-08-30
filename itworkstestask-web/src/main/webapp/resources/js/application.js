var API_PATH = "/itworkstesttask-rest-1.0-SNAPSHOT/rest/";
var CART_LS_KEY = "cart";

var goodsConfig = {
    "inputDevices": {
        id: 1,
        apiUrl: "goodstype/inputdevices",
        customFields: ["color", "illumination"]
    },
    "components": {
        id: 2,
        apiUrl: "goodstype/components",
        customFields: ["brand", "weight"]
    },
    "monitors": {
        id: 3,
        apiUrl: "goodstype/monitors",
        customFields: ["brand", "size"]
    },
    "storageDevices": {
        id: 4,
        apiUrl: "goodstype/storagedevices",
        customFields: ["brand", "capacity"]
    },
    "peripherals": {
        id: 5,
        apiUrl: "goodstype/peripherals",
        customField: ["brand", "voltage"]
    }
};

var customFieldConfig = {
    "color": "string",
    "illumination": "checkbox",
    "brand": "string",
    "weight": "number",
    "size": "number",
    "capacity": "number",
    "voltage": "number"
};

$(document).ready(function () {
    loadGoodTypesPage();
});

function showPage(pagePath, context, done) {
    $.get(pagePath, function (template) {
        var output = _.template(template)(context);

        $("#content").html(output);

        done && done();
    });
}

function loadGoodTypesPage(done) {
    $.get(API_PATH + "goodstype", function (goodstype) {
        showPage("resources/html/page-goodstype.html", { goodstype: goodstype }, function(){
            handleCartNavigation();

            $("#btn-tickets").click(function () {
                loadTicketsPage();
            });

            $(".btn-goodstype-select").click(function () {
                var goodTypeId = +$(this).attr("data-id");
                var config = _(goodsConfig).values().find(function (c) {
                    return c.id === goodTypeId;
                });

                loadGoodsPage(config);
            });

            done && done();
        });
    })
}

function loadGoodsPage(config) {
    $.get(API_PATH + config.apiUrl, function (goods) {
        showPage("resources/html/page-goods.html", { goods: goods, config: config }, function () {
            handleCartNavigation();

            $("#btn-cancel").click(function () {
                loadGoodTypesPage();
            });

            $(".btn-good-delete").click(function () {
                if (confirm("Are you sure?")) {
                    var id = $(this).attr("data-id");
                    $.ajax({
                        url: API_PATH + config.apiUrl + "/" + id + "/delete",
                        type: "DELETE",
                        success: function() {
                            loadGoodsPage(config);
                        }
                    });
                }
            });

            $(".btn-good-create").click(function () {
                loadGoodPageSave({ typeId: config.id, id: 0 }, config);
            });

            $(".btn-good-update").click(function () {
                var id = +$(this).attr("data-id");
                var good = _.find(goods, function(good){ return good.id === id });
                loadGoodPageSave(good, config);
            });

            $(".btn-good-add-to-cart").click(function () {
                var id = +$(this).attr("data-id");
                var good = _.find(goods, function(good){ return good.id === id });
                var sCart = localStorage.getItem(CART_LS_KEY);
                var cart = sCart ? JSON.parse(sCart): [];

                var sameGoodInCart = _.find(cart, function (g) {
                    return g.id === id && g.typeId === good.typeId;
                });

                if (sameGoodInCart) {
                    sameGoodInCart.amount++;
                } else {
                    cart.push({
                        id: id,
                        name: good.name,
                        typeId: good.typeId,
                        amount: 1,
                        cost: good.cost
                    })
                }

                localStorage.setItem(CART_LS_KEY, JSON.stringify(cart));
            })
        });
    });
}

function loadGoodPageSave(_good, config, done) {
    showPage("resources/html/page-good-save.html", { config: config, customFieldConfig: customFieldConfig }, function () {
        handleCartNavigation();

        $("#input-name").val(_good.name);
        $("#input-quantity").val(_good.quantity);
        $("#input-country").val(_good.country);
        $("#input-cost").val(_good.cost);

        _.each(config.customFields, function(field){
            var element = $("#input-" + field);

            switch (customFieldConfig[field]) {
                case "string":
                case "number":
                    element.val(_good[field]);
                    break;
                case "checkbox":
                    element.prop("checked", _good[field]);
                    break;
            }
        });

        $('#btn-save').click(function(){
            var good = {
                id: _good.id,
                typeId: _good.typeId,
                name: $("#input-name").val(),
                quantity: +$("#input-quantity").val(),
                country: $("#input-country").val(),
                cost: +$("#input-cost").val()
            };

            _.each(config.customFields, function(field){
                var element = $("#input-" + field);

                switch (customFieldConfig[field]) {
                    case "string":
                        good[field] = element.val();
                        break;
                    case "number":
                        good[field] = +element.val();
                        break;
                    case "checkbox":
                        good[field] = element.prop("checked");
                        break;
                }
            });

            $.ajax({
                url: API_PATH + config.apiUrl + "/save",
                type: "POST",
                data: JSON.stringify(good),
                dataType: "json",
                contentType: "application/json",
                success: function() {
                    loadGoodsPage(config);
                }
            });
        });

        $('#btn-cancel').click(function() {
            loadGoodsPage(config);
        });

        done && done();
    });
}

function handleCartNavigation() {
    $("#btn-cart").click(function () {
        loadCartPage();
    });
}


function loadCartPage() {
    var sCart = localStorage.getItem(CART_LS_KEY);
    var cart = sCart ? JSON.parse(sCart): [];

    showPage("resources/html/page-cart.html", { cart: cart }, function () {

        $("#btn-cancel").click(function() {
            loadGoodTypesPage();
        });

        $("#btn-clean-cart").click(function() {
            localStorage.clear();
            loadGoodTypesPage();
        });

        $("#btn-pay").click(function () {
            var dto = _.map(cart, function (item) {
                return _.pick(item, ["id", "typeId", "amount"]);
            });

            $.ajax({
                url: "TODO",
                type: "POST",
                data: JSON.stringify(dto),
                dataType: "json",
                contentType: "application/json",
                success: function() {
                    alert("Thank you!");
                    loadGoodTypesPage();
                }
            });
        });
    });
}

function loadTicketsPage() {
    $.get(API_PATH+"tickets",function (tickets) {
        showPage("resources/html/page-tickets.html", {tickets:tickets}, function () {
            $("#btn-cancel").click(function () {
               loadGoodTypesPage();
            });

            $(".btn-ticket-select").click(function () {
                var ticketId=$(this).attr("data-id");
                loadTicketInfoPage(ticketId);
            });
        });
    });
}

function loadTicketInfoPage(ticketId) {
    $.get(API_PATH+"tickets/"+ticketId,function (ticketinfoList) {
        showPage("resources/html/page-ticketinfo.html",{ticketinfoList:ticketinfoList},function () {
            $("#btn-cancel").click(function () {
                loadTicketsPage();
            });
        })
    })
}