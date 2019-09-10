package com.ht.shop.common.response;

import com.ht.shop.common.enums.CommonEnum;

import java.util.List;

/**
 * 统一相应结果类
 */
public class ResponseResult<T> {

    //是否操作成功
    public boolean success;

    //响应信息
    public String message;

    //响应代码
    public String code;

    //响应的单个数据
    public Object entity;

    //响应的多个数据 集合
    public List<T> list;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public Object getObject() {
        return entity;
    }

    public void setObject(Object entity) {
        this.entity = entity;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public ResponseResult(){}

    public ResponseResult(CommonEnum commonEnum,T t){
        this.code = commonEnum.getCode();
        this.message = commonEnum.getMessage();
        this.success = commonEnum.getSuccess();
        this.entity = t;
    }
    public ResponseResult(CommonEnum commonEnum,List<T> list){
        this.code = commonEnum.getCode();
        this.message = commonEnum.getMessage();
        this.success = commonEnum.getSuccess();
        this.list = list;
    }
    public ResponseResult(CommonEnum commonEnum){
        this.code = commonEnum.getCode();
        this.message = commonEnum.getMessage();
        this.success = commonEnum.getSuccess();
    }
}
