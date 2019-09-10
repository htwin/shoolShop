package com.ht.shop.common.enums;

public enum CommonEnum {
    SUCCESS(true,"4000","操作成功"),
    FAIL(false,"40001","操作失败"),
    GETSHOPLISTERROR(false,"40002","获取店铺列表失败"),
    NOPRODUCT(false,"40003","没有商品");
    private boolean success;

    private String code;

    private String message;

    public boolean getSuccess() {
        return success;
    }



    public String getCode() {
        return code;
    }



    public String getMessage() {
        return message;
    }

    CommonEnum(boolean success,String code,String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
