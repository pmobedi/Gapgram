package com.example.gapgram.model;

import okhttp3.ResponseBody;

public interface IResponse<T> {

    public void onSuccess(T responseBody);
    public void onFail();

}
