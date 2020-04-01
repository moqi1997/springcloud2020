package com.moqi.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moqi
 * @date 2020/4/1 14:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code, String message) {
       this(code,message,null);
    }
}
