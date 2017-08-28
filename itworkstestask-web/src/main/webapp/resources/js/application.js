var API_PATH = "/itworkstesttask-rest-1.0-SNAPSHOT/rest/";
$(document).ready(function () {
    loadGoodstypePage(function () {
        loadGoodsPage();
    });
});
function showPage(pagePath, context, done) {
    $.get(pagePath, function (template) {
        var output = Mustache.render(template, context);

        $("#content").html(output);

        done && done();
    });
}

function loadGoodstypePage(done) {
    $.get(API_PATH + "goodstype", function (goodstype) {
        showPage("resources/html/page-goodstype.html", {goodstype: goodstype}, done);
    })
}

function loadGoodsPage() {
    $(".btn-goodstype-select").click(function () {
        var goodTypeId = $(this).attr("data-id");
        console.log(goodTypeId);
        switch (goodTypeId) {
            case "1":
                loadInputdevicesPage();
                break;
            case "2":
                loadComponentsPage();
                break;
            case "3":
                loadMonitorsPage();
                break;
            case "4":
                loadStoragedevicePage();
                break;
            case "5":
                loadPeripheriaPage();
                break;
        }
    });
}
function loadPeripheriaPage() {
    var goodTypeId = 5;
    $.get(API_PATH + "goodstype/peripherals", function (peripherals) {
        showPage("resources/html/page-peripherals.html", {peripherals:peripherals}, function () {
            deletePeripheria();
            createPeripheria(goodTypeId);
            updatePeripheria(goodTypeId);
        })
    })
}
function loadStoragedevicePage() {
    var goodTypeId = 4;
    $.get(API_PATH + "goodstype/storagedevices", function (storagedevices) {
        showPage("resources/html/page-storagedevices.html", {storagedevices:storagedevices}, function () {
            deleteStoragedevice();
            createStoragedevice(goodTypeId);
            updateStoragedevice(goodTypeId);
        })
    })
}
function loadMonitorsPage() {
    var goodTypeId = 3;
    $.get(API_PATH + "goodstype/monitors", function (monitors) {
        showPage("resources/html/page-monitors.html", {monitors: monitors}, function () {
            deleteMonitor();
            createMonitor(goodTypeId);
            updateMonitor(goodTypeId);
        })
    })
}
function loadComponentsPage() {
    var goodTypeId = 2;
    $.get(API_PATH + "goodstype/components", function (components) {
        showPage("resources/html/page-components.html", {components: components}, function () {
            deleteComponent();
            createComponent(goodTypeId);
            updateComponent(goodTypeId);
        })
    })
}
function loadInputdevicesPage() {
    var goodTypeId = 1;
    $.get(API_PATH + "goodstype/inputdevices", function (inputdevices) {
        showPage("resources/html/page-inputdevices.html", {inputdevices: inputdevices}, function () {
            deleteInputdevice();
            createInputdevice(goodTypeId);
            updateInputdevice(goodTypeId);
        })
    })
}

function deleteComponent() {
    $("#btn-component-delete").click(function () {
        var id = $(this).attr("data-id");
        $.ajax({
            url: API_PATH + "goodstype/components/" + id + "/delete",
            type: "DELETE",
            success: loadComponentsPage
        });

    });
}
function createComponent(goodTypeId) {
    $("#btn-component-create").click(function () {
        showComponentPageSave(function () {
            $('input[name="typeId"]').val(goodTypeId);
            $('input[name="id"]').val(0);
        });
    });
}

function updateComponent(goodTypeId) {
    $("#btn-component-update").click(function () {
        var id = $(this).attr("data-id");
        showComponentPageSave(function () {
            $('input[name="typeId"]').val(goodTypeId);
            $('input[name="id"]').val(id);
        });
    });
}

function showComponentPageSave(done) {
    showPage("resources/html/page-component-save.html", null, done);
}
function saveComponent(id, typeId, model, quantity, country, brand, weight, cost) {
    var component = {
        id: id,
        typeId: typeId,
        name: model,
        quantity: quantity,
        country: country,
        brand: brand,
        weight: weight,
        cost: cost
    };
    $.ajax({
        url: API_PATH + "goodstype/components/save",
        type: "POST",
        data: JSON.stringify(component),
        dataType: "json",
        contentType: "application/json",
        success: loadComponentsPage
    })
}

function deleteInputdevice() {
    $("#btn-inputdevice-delete").click(function () {
        var id = $(this).attr("data-id");
        $.ajax({
            url: API_PATH + "goodstype/inputdevices/" + id + "/delete",
            type: "DELETE",
            success: loadInputdevicesPage
        });
    });
}

function createInputdevice(goodTypeId) {
    $("#btn-inputdevice-create").click(function () {
        showInputdevicePageSave(function () {
            $('input[name="typeId"]').val(goodTypeId);
            $('input[name="id"]').val(0);
        });
    });
}

function updateInputdevice(goodTypeId) {
    $("#btn-inputdevice-update").click(function () {
        var id = $(this).attr("data-id");
        showInputdevicePageSave(function () {
            $('input[name="typeId"]').val(goodTypeId);
            $('input[name="id"]').val(id);
        });
    });
}

function showInputdevicePageSave(done) {
    showPage("resources/html/page-inputdevice-save.html", null, done);
}

function saveInputdevice(id, typeId, model, quantity, country, color, illumination, cost) {
    var component = {
        id: id,
        typeId: typeId,
        name: model,
        quantity: quantity,
        country: country,
        color: color,
        illumination: illumination,
        cost: cost
    };
    $.ajax({
        url: API_PATH + "goodstype/inputdevices/save",
        type: "POST",
        data: JSON.stringify(component),
        dataType: "json",
        contentType: "application/json",
        success: loadInputdevicesPage
    })
}

function deleteMonitor() {
    $("#btn-monitor-delete").click(function () {
        var id = $(this).attr("data-id");
        $.ajax({
            url: API_PATH + "goodstype/monitors/" + id + "/delete",
            type: "DELETE",
            success: loadMonitorsPage
        });
    });
}

function createMonitor(goodTypeId) {
    $("#btn-monitor-create").click(function () {
        showMonitorPageSave(function () {
            $('input[name="typeId"]').val(goodTypeId);
            $('input[name="id"]').val(0);
        });
    });
}

function updateMonitor(goodTypeId) {
    $("#btn-monitor-update").click(function () {
        var id = $(this).attr("data-id");
        showMonitorPageSave(function () {
            $('input[name="typeId"]').val(goodTypeId);
            $('input[name="id"]').val(id);
        });
    });
}

function showMonitorPageSave(done) {
    showPage("resources/html/page-monitor-save.html", null, done);
}

function saveMonitor(id, typeId, model, quantity, country, brand, size, cost) {
    var component = {
        id: id,
        typeId: typeId,
        name: model,
        quantity: quantity,
        country: country,
        brand: brand,
        size: size,
        cost: cost
    };
    $.ajax({
        url: API_PATH + "goodstype/monitors/save",
        type: "POST",
        data: JSON.stringify(component),
        dataType: "json",
        contentType: "application/json",
        success: loadMonitorsPage
    })
}

function deleteStoragedevice() {
    $("#btn-storagedevice-delete").click(function () {
        var id = $(this).attr("data-id");
        $.ajax({
            url: API_PATH + "goodstype/storagedevices/" + id + "/delete",
            type: "DELETE",
            success: loadStoragedevicePage
        });
    });
}

function createStoragedevice(goodTypeId) {
    $("#btn-storagedevice-create").click(function () {
        showStoragedevicePageSave(function () {
            $('input[name="typeId"]').val(goodTypeId);
            $('input[name="id"]').val(0);
        });
    });
}

function updateStoragedevice(goodTypeId) {
    $("#btn-storagedevice-update").click(function () {
        var id = $(this).attr("data-id");
        showStoragedevicePageSave(function () {
            $('input[name="typeId"]').val(goodTypeId);
            $('input[name="id"]').val(id);
        });
    });
}

function showStoragedevicePageSave(done) {
    showPage("resources/html/page-storagedevice-save.html", null, done);
}

function saveStoragedevice(id, typeId, model, quantity, country, brand, capacity, cost) {
    var component = {
        id: id,
        typeId: typeId,
        name: model,
        quantity: quantity,
        country: country,
        brand: brand,
        capacity: capacity,
        cost: cost
    };
    $.ajax({
        url: API_PATH + "goodstype/storagedevices/save",
        type: "POST",
        data: JSON.stringify(component),
        dataType: "json",
        contentType: "application/json",
        success: loadMonitorsPage
    })
}
//
function deletePeripheria() {
    $("#btn-peripheria-delete").click(function () {
        var id = $(this).attr("data-id");
        $.ajax({
            url: API_PATH + "goodstype/peripherals/" + id + "/delete",
            type: "DELETE",
            success: loadPeripheriaPage
        });
    });
}

function createPeripheria(goodTypeId) {
    $("#btn-peripheria-create").click(function () {
        showPeripheriaPageSave(function () {
            $('input[name="typeId"]').val(goodTypeId);
            $('input[name="id"]').val(0);
        });
    });
}

function updatePeripheria(goodTypeId) {
    $("#btn-peripheria-update").click(function () {
        var id = $(this).attr("data-id");
        showPeripheriaPageSave(function () {
            $('input[name="typeId"]').val(goodTypeId);
            $('input[name="id"]').val(id);
        });
    });
}

function showPeripheriaPageSave(done) {
    showPage("resources/html/page-peripheria-save.html", null, done);
}

function savePeripheria(id, typeId, model, quantity, country, brand, voltage, cost) {
    var component = {
        id: id,
        typeId: typeId,
        name: model,
        quantity: quantity,
        country: country,
        brand: brand,
        voltage: voltage,
        cost: cost
    };
    $.ajax({
        url: API_PATH + "goodstype/peripherals/save",
        type: "POST",
        data: JSON.stringify(component),
        dataType: "json",
        contentType: "application/json",
        success: loadPeripheriaPage
    })
}