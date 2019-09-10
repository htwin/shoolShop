
$(function () {
//获取参数
    var shopId = getQueryString("shopId");
    if(shopId == ""){
        //没有参数，返回到商铺列表
        window.location.href="../shopadmin/shopList.do";
        return;
    }

    var url = "../shopadmin/getProductCategoryListByShopId.do?shopId="+shopId;

    $.ajax({
        url: url,
        type:"GET",
        async: true,
        success: function (data) {
            if (data.success) {

                var categoryList = data.list;
                for (var i = 0; i < categoryList.length; i++) {
                    var productCategory = categoryList[i];
                    $("#categoryList").append("<div class='row'>" +
                        "<div class='col-33'>" + productCategory.productCategoryName + "</div>" +
                        "<div class='col-33'>" + productCategory.priority + "</div>" +
                        "<div class='col-33'><a href='#' onclick=doDeleteCategory('"+productCategory.productCategoryId+"') external>删除</a></div></div>")
                }

            } else {
                alert("加载分类失败");
            }
        },
        error: function () {
            alert("error:加载分类失败")
        }
    })

});

//调用后台删除分类
function doDeleteCategory(productCategoryId) {
    if(confirm("确认删除吗？")){
        var url = "../shopadmin/deleteCategoryById.do?productCategoryId="+productCategoryId+"";
        $.ajax({
            url:url,
            async:true,
            success:function (data) {
                console.log(data);
                if(data.success){
                    alert("删除成功");
                    window.location.reload();
                }else{
                    alert("删除失败")
                }
            },
            error:function () {
                alert("error:删除失败");
            }
        })
    }

}

//页面删除分类元素
function deleteCategory(thisCategory) {
    console.info(thisCategory);
    console.info($(thisCategory).parent());
    console.info($(thisCategory).parent().parent());
    $(thisCategory).parent().parent().remove();
}
//页面添加类别输入框
function addCategory(){
    $("#categoryList").append("<div class=\"row temp\">" +
        "<div class=\"col-33\">" +
        "<input id='productCategoryName' type=\"text\" placeholder=\"类别名\">" +
        "</div>" +
        "<div class=\"col-33\">" +
        "<input id='priority' type=\"text\" placeholder=\"优先级\">" +
        "</div>" +
        "<div class=\"col-33\">" +
        "<a href='#' onclick='deleteCategory(this)' external>删除</a>" +
        "</div>" +
        "</div>")

}

function submitCategory(){
    //获取shopId参数
    var shopId = getQueryString("shopId");
    if(shopId == ""){
        //没有参数，返回到商铺列表
        window.location.href="../shopadmin/shopList.do";
        return;
    }
    var temp = $(".temp");
    var productCategoryList = [];
    for(var i = 0;i<temp.length;i++){

        var category = {};

        //分类名称
        category.productCategoryName =  $(temp[i]).find("#productCategoryName").val();
        //优先级
        category.priority =  $(temp[i]).find("#priority").val();
        category.shopId = shopId;
        productCategoryList.push(category);
    }

    var url = "../shopadmin/addCategory.do";
    $.ajax({
        url:url,
        type:"POST",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(productCategoryList),
        success:function (data) {
            console.log(data);
            if(data.success){
                alert("操作成功");
                window.location.reload();
            }else{
                alert("添加失败");
            }
        },
        error:function () {
            alert("error:操作失败");
        }
    });
}