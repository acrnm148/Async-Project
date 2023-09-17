package com.async.myapp.async.web.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataResponse<T> extends BaseResponse {
    private T data;

    public DataResponse(String status, String message, T data) {
        super(status, message);
        this.data = data;
    }
}
