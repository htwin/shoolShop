$(function () {
    var page = 1;
    var size = 10;
    var url = "../shopadmin/getShopList.do?page="+page+"&size="+size;
    $.ajax({
        url:url,
        type:"GET",
        async:true,
        success:function (data) {
            var shopList = data.list;
            for(var i=0;i<shopList.length;i++){
                /*<div class="row">
                <div class="col-40">三栋</div>
                <div class="col-40">审核中</div>
                <div class="col-20">进入</div>
            </div>*/
                $("#shopList").append("<div class='row'>" +
                    "<div class='col-40'>"+shopList[i].shopName+"</div>" +
                    "<div class='col-40'>"+shopList[i].advice+"</div>" +
                    "<div class='col-20'><a href='/schooShop/shopadmin/shopManage.do?shopId="+shopList[i].shopId+"' external>进入</a></div></div>")
            }
        },
        error:function () {
            alert("error:操作失败");
        }
    })
})