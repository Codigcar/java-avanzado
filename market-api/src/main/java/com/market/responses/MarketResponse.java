package com.market.responses;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MarketResponse<T> implements Serializable {

    private String status;
    private String message;
    private T data;

    public MarketResponse (String status, String message, T data){
        this.status=status;
        this.message=message;
        this.data=data;
    }

    public MarketResponse (String status, String message){
        this.status=status;
        this.message=message;
    }
}
