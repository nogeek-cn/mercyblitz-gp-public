package com.darian.spring5webFluxdemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


@Slf4j
public class ApiResponse {
    private ResultResponse response;

    public static ApiResponse ApiResponse(Object data) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setReturncode("ok");
        resultResponse.setReturndesc("操作成功");
        resultResponse.setReturndata(data);
        resultResponse.setReturnstamp(new Date());
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResponse(resultResponse);
        return apiResponse;
    }

    /**
     * @author Darian
     **/
//    public static ApiResponse apiResponseOk(Object returnDate) {
//        return ApiResponse(returnDate, GpsServiceReturnCode.SUCCESS);
//    }
    public static ApiResponse apiResponseOk(Object returnDate) {
        return ApiResponse(returnDate);
    }

//    /**
//     * @author Darian
//     **/
//    public static ApiResponse apiResponseError(Object returnDate, GpsServiceReturnCode gpsServiceReturnCode) {
//        return ApiResponse(returnDate, gpsServiceReturnCode);
//    }
//
//    /**
//     * @author Darian
//     **/
//    public static ApiResponse apiResponseError(Object returnDate, PointsServiceException pointsServiceException) {
//        return ApiResponse(returnDate, pointsServiceException);
//    }

    /***
     * "S0A00000" mean "200"
     * @param okReturnCode
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getData(String okReturnCode, Class<T> clazz) {
        // 远程服务调用异常
        if (!okReturnCode.equals(this.getReturnCode())) {
            log.error("远程返回值 code 不正确：" + JSON.toJSONString(this));
//            throw new PointsServiceException(GpsServiceReturnCode.ERR_REMOTE_INVOKE_ERROR);
        }
        try {
            return JSON.parseObject(JSON.toJSONString(response.getReturndata()), clazz);
        } catch (Exception e) {
            throw new RuntimeException("返回值拿取结果报错信息：" + e.getMessage());
        }
    }

    @Data
    private static class ResultResponse {
        private String returncode;
        private String returndesc;
        private Object returndata;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSS")
        @JSONField(format = "yyyy-MM-dd HH:mm:ss:SSS")
        private Date returnstamp;
    }


    /**
     * @author Darian
     **/
//    public static ApiResponse ApiResponse(Object returnDate, PointsServiceException e) {
//        ApiResponse apiResponse = new ApiResponse();
//        ResultResponse response = new ResultResponse();
//        response.setReturndesc(e.getErrMsg());
//        response.setReturncode(e.getErrCode());
//        response.setReturndata(returnDate);
//        response.setReturnstamp(new Date());
//        apiResponse.setResponse(response);
//        return apiResponse;
//    }
//
//
//    /**
//     * @author Darian
//     **/
//    public static ApiResponse ApiResponse(Object returnDate, GpsServiceReturnCode gpsServiceReturnCode) {
//        ApiResponse apiResponse = new ApiResponse();
//        ResultResponse response = new ResultResponse();
//        response.setReturndesc(gpsServiceReturnCode.getMsg());
//        response.setReturncode(gpsServiceReturnCode.getCode());
//        response.setReturndata(returnDate);
//        response.setReturnstamp(new Date());
//        apiResponse.setResponse(response);
//        return apiResponse;
//    }
    public ResultResponse getResponse() {
        return response;
    }

    public void setResponse(ResultResponse response) {
        this.response = response;
    }

    @JsonIgnore
    @JSONField(serialize = false)
    public String getReturnCode() {
        return this.response.getReturncode();
    }

}