package com.sjw.permission.common.vo;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * @param <T>
 * @author sjw
 */
@Api
@SuppressWarnings("unchecked")
public class Result<T> {
    @ApiModelProperty(value = "实际传输的数据")
    private T data;

    /**
     * total rows
     */
    @ApiModelProperty
    private Long total = 1L;

    @ApiModelProperty(required = true)
    private boolean success = true;

    @ApiModelProperty
    private String msg = "操作完成";

    public static Result genSuccess(String msg) {
        return new Result().setSuccess(true).setMsg(msg);
    }

    public static Result genSuccess(Object data, Long total) {
        return new Result().setSuccess(true).setData(data).setTotal(total);
    }

    public static Result genFail(String msg) {
        return new Result().setSuccess(false).setMsg(msg).setTotal(0L);
    }

    public boolean isSuccess() {
        return success;
    }

    public Result setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Long getTotal() {
        return total;
    }

    public Result setTotal(Long total) {
        this.total = total;
        return this;
    }


}