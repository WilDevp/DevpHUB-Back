package com.devphub.exceptions;

public class SpringDevpHubException  extends  RuntimeException{
    public SpringDevpHubException(String exMessage, Exception exception){
        super(exMessage, exception);
    }
    public SpringDevpHubException(String exMessage){
        super(exMessage);
    }
}
