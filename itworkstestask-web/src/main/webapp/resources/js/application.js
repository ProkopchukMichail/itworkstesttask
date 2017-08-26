var API_PATH = "/itworkstesttask-rest-1.0-SNAPSHOT/rest/";
$(document).ready(function () {
    loadGoodstypePage(function () {
        loadGoodsPage();
    });
});

function loadGoodstypePage(done) {
    $.get(API_PATH+"goodstype", function (goodstype) {
        showPage("resources/html/page-goodstype.html",{goodstype:goodstype},done);
    })
}

function loadGoodsPage() {
    $(".btn-goodstype-select").click(function () {
        var goodTypeId=$(this).attr("data-id");
        console.log(goodTypeId);
        switch(goodTypeId){
         case "2": loadComponentPage(function () {
         deleteComponent();
         });}
    });
}

function loadComponentPage(done) {
    $.get(API_PATH+"goodstype/components", function (components) {
        showPage("resources/html/page-components.html", {components:components}, done)
    })
}

function deleteComponent() {
    
}

function showPage(pagePath, context, done) {
    $.get(pagePath, function (template) {
        var output = Mustache.render(template, context);

        $("#content").html(output);

        done && done();
    });
}