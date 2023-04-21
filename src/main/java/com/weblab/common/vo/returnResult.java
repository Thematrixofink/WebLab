package com.weblab.common.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class returnResult<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> returnResult<T> success(){
        return new returnResult<>(20000,"success",null);
    }
    public static <T> returnResult<T> success(T data){
        return new returnResult<>(20000,"success",data);
    }
    public static <T> returnResult<T> success(T data, String message){
        return new returnResult<>(20000,message,data);
    }
    public static <T> returnResult<T> success(String message){
        return new returnResult<>(20000,message,null);
    }
    public static <T> returnResult<T> fail(){
        return new returnResult<>(20001,"fail",null);
    }
    public static <T> returnResult<T> fail(Integer code){
        return new returnResult<>(code,"fail",null);
    }
    public static <T> returnResult<T> fail(Integer code, String message){
        return new returnResult<>(code,message,null);
    }
    public static <T> returnResult<T> fail(String message){
        return new returnResult<>(20001,message,null);
    }

}
