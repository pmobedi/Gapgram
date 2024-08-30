package com.example.gapgram.model;

import java.util.List;

public interface IListResponse<T> {

    public void onSuccess(List<T> responseBody);
    public void onFail();

}
