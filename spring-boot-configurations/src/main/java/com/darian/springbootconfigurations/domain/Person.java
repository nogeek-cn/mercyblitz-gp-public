package com.darian.springbootconfigurations.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Data
@ConfigurationProperties(prefix = "person")
public class Person {
    private Name name;
}
