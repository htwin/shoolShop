$(function () {

    var shopId = getQueryString("shopId");
    if(shopId!=null&&shopId!=""){

        getShopInfoById(shopId);

    }


    //获取区域列表
    getAreaList();
    //获取店铺类别
    getShopCategoryList();

});

//根据id查询商铺详情信息
function getShopInfoById(shopId) {
    var url = "../shopadmin/getShopById.do?shopId="+shopId;

    $.ajax({
        url:url,
        async: true,
        success:function (data) {
            if(data.success){
               $("#shopName").val(data.entity.shopName);

               $("#shopAddr").val(data.entity.shopAddr);

                //$("#shopCategory").append("<option value='" + data.entity.shopCategory.shopCategoryId + "'>" + data.entity.shopCategory.categoryName + "</option>");
              //  $("#shopArea").append("<option value='" +data.entity.area.areaId + "'>" + data.entity.area.areaName + "</option>");

               $("#shopDesc").val(data.entity.shopDesc);

               $("#phone").val(data.entity.phone);

            }else{
                alert("编辑失败");
            }
        },
        error:function () {
            alert("error:编辑失败");
        }

    });


}

//获取店铺类别
function getShopCategoryList() {

    var url = "../category/getSubCategoryList.do";

    $.ajax({
        url: url,
        async: true,
        success: function (data) {
            for (var i = 0; i < data.length; i++) {

                $("#shopCategory").append("<option value='" + data[i].shopCategoryId + "'>" + data[i].categoryName + "</option>");
            }

        },
        error: function () {
            alert("加载店铺分类列表失败");
        }
    });

}

//获取区域列表
function getAreaList() {
    var url = "../area/list.do";
    $.ajax({
        url: url,
        async: true,
        success: function (data) {
            //加载区域列表
            for (var i = 0; i < data.length; i++) {
                $("#shopArea").append("<option value='" + data[i].areaId + "'>" + data[i].areaName + "</option>");
            }
        },
        error: function (data) {
            alert("加载区域列表失败");
        }
    });
}

//保存店铺信息到数据库
function save() {
    var url = "../shop/register.do";
    var shopId = getQueryString("shopId");
    var shop = {};

    if(shopId!=null&&shopId!=""){
        url = "../shopadmin/update.do"
        shop.shopId = shopId;
    }




    shop.shopName = $("#shopName").val();

    shop.shopAddr = $("#shopAddr").val();

    shop.shopCategoryId = $("#shopCategory").val();

    shop.areaId = $("#shopArea").val();

    shop.shopDesc = $("#shopDesc").val();

    shop.phone = $("#phone").val();

    //店铺图片
    var imgFile = $("#imgFile").get(0).files[0];




    var formData = new FormData();
    formData.append("shopStr",JSON.stringify(shop));
    formData.append("imgFile",imgFile);
    $.ajax({
        url: url,
        type: "POST",
       contentType:"multipart/form-data",
        data: formData,
        async:false,
        contentType: false,// 告诉jQuery不要去设置Content-Type请求头
        processData: false,// 告诉jQuery不要去处理发送的数据

        success: function (data) {
            if (data.success) {
                alert(data.message);
            } else {
                alert(data.message);
            }
        },
        error: function () {
            alert("error:操作失败");
        }

    });


}