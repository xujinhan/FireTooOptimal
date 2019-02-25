package com.basic.commlibrary.model;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 5213230387175987834L;

    public int status;
    public int id;
    public String msg;
    public T data;

    @Override
    public String toString() {
        return "LzyResponse{\n" +//
               "\tstatus=" + id + "\n" +//
               "\tstatus=" + status + "\n" +//
               "\tmsg='" + msg + "\'\n" +//
               "\tdata=" + data + "\n" +//
               '}';
    }
}
