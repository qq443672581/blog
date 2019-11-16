package cn.dlj1.blog.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class BaseEntity implements Serializable {

}
