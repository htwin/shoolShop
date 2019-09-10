function generateHeadLine() {
    var url = "../shopfront/getHeadLineList.do";

    $.ajax({
        url: url,
        type: "GET",
        async: false,
        success: function (data) {
            if (data.success) {
                var headLineList = data.list;
                /*<div class="swiper-slide"><img
                    src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i1/TB1n3rZHFXXXXX9XFXXXXXXXXXX_!!0-item_pic.jpg_640x640q60.jpg"
                    alt="" style='width: 100%'></div>*/
                for (var i = 0; i < headLineList.length; i++) {
                    $("#headLine").append("<div class='swiper-slide'>" +
                        "<img src='" + headLineList[i].lineImg + "' alt='' style='width: 100%'></div>")
                }

            } else {
                alert("加载轮播图失败");
            }
        },
        error: function () {
            alert("error:加载轮播图失败");
        }
    });

}

function generateShopCatgory() {
    var url = "../shopfront/getAllParentCategoryList.do";

    $.ajax({
        url: url,
        type: "GET",
        async: true,
        success: function (data) {
            if(data.success){
                var categoryList = data.list;
                for(var i=0;i<categoryList.length;i++){
                    $(".shopCategory").append("<div class=\"col-50 shop-classify\">\n" +
                        "                    <div class=\"word\">\n" +
                        "                        <p class='shop-title'>"+categoryList[i].categoryName+"</p>\n" +
                        "                        <p class='shop-desc'>"+categoryList[i].categoryDesc+"</p>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"shop-classify-img-warp\">\n" +
                        "                        <img class='shop-img' src='"+categoryList[i].categoryImg+"'>\n" +
                        "                    </div>\n" +
                        "                </div>")
                }
            }
        },
        error: function () {
            alert("加载分类列表失败");
        }
    });

}