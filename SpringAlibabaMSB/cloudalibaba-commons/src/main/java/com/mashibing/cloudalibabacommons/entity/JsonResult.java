package com.mashibing.cloudalibabacommons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {
    private Long code;
    private T data;
}
