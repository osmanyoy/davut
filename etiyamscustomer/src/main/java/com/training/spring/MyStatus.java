package com.training.spring;


public class MyStatus {

    private String statusStr;
    private int    cause;


    public MyStatus() {
    }


    public MyStatus(final String statusStrParam,
                    final int causeParam) {
        super();
        this.statusStr = statusStrParam;
        this.cause = causeParam;
    }


    public String getStatusStr() {
        return this.statusStr;
    }

    public void setStatusStr(final String statusStrParam) {
        this.statusStr = statusStrParam;
    }

    public int getCause() {
        return this.cause;
    }

    public void setCause(final int causeParam) {
        this.cause = causeParam;
    }


}
