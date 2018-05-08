package com.sunsulei.v2ex.common;

public class JsonResult {

    public static final String CODE_SUCCESS = "1";
    public static final String CODE_ERROR = "0";
    public static final String CODE_OTHER = "99";
    private String code;
    private String msg;
    private Object data;
    private Long totalCount;

    public static JsonResult result(String code, String msg, Object data, Long totalCount) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        jsonResult.setData(data);
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    public static JsonResult resultError(String msg) {
        return resultError(CODE_ERROR, msg);
    }

    public static JsonResult resultError(String code, String msg) {
        return result(code, msg, null, 0L);
    }


    public static JsonResult resultSuccess(String msg, Object data, Long totalCount) {
        return result(CODE_SUCCESS, msg, data, totalCount);
    }

    public static JsonResult resultSuccess(Object data, Long totalCount) {
        return resultSuccess("操作成功", data, totalCount);
    }

    public static JsonResult resultSuccess(Object data) {
        if (data instanceof String) {
            return resultSuccess((String) data, data, 0L);
        }
        return resultSuccess("操作成功", data, 0L);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
