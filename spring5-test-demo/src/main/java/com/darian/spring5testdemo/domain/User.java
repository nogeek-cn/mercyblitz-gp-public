package com.darian.spring5testdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * 用户领域模型
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
}
