


function addProduct() {
    var shopId = getQueryString("shopId");
    if(shopId == ""){
        //没有参数，返回到商铺列表
        window.location.href="../shopadmin/shopList.do";
        return;
    }
    //需要shopId参数 商品是属于某一个商铺的
    window.location.href="../shopadmin/productAddOrUpdate.do?shopId="+shopId;
}
function doUpdateProduct (productId) {
    var shopId = getQueryString("shopId");
    if(shopId == ""){
        //没有参数，返回到商铺列表
        window.location.href="../shopadmin/shopList.do";
        return;
    }
    window.location.href="../shopadmin/productAddOrUpdate.do?productId="+productId+"&shopId="+shopId;
}

function saveOrUpdate(){
    //店铺id
    var shopId = getQueryString("shopId");
    if(shopId == ""){
        //没有参数，返回到商铺列表
        window.location.href="../shopadmin/shopList.do";
        return;
    }

    var url = "../shopadmin/addProduct.do";
    var product = {};
    //商品id 如果不存在就是添加商品 否则为编辑商品
    var productId = getQueryString("productId");
    if(productId != ""){
        //有参数，编辑
        url = "../shopadmin/updateProduct.do";
        product.productId = productId;
    }



    product.productName = $("#productName").val();

    product.productCategoryId = $("#productCategory").val();
    product.priority = $("#priority").val();
    product.originalPrice = $("#originalPrice").val();
    product.presentPrice = $("#presentPrice").val();
    product.productDesc = $("#productDesc").val();
    product.shopId = shopId;
    var thumbnail = $("#thumbnail").get(0).files[0];

    var formData = new FormData();
    formData.append("product",JSON.stringify(product));
    formData.append("imgFile",thumbnail);

    $.ajax({
        url:url,
        type:"POST",
        dataType:"json",
        contentType: false,// 告诉jQuery不要去设置Content-Type请求头
        processData: false,// 告诉jQuery不要去处理发送的数据
        data:formData,
        success:function (data) {
            if(data.success){
                alert("操作成功");
                //window.history.go(-1);
                window.location.href = document.referrer;
            }else{
                alert("操作失败")
            }
        },
        error:function () {
            alert("error:操作失败")
        }


    })


}

