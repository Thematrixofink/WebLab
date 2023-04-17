package com.weblab.system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "url对象", description = "")
@Data
public class Url {
    private Integer groupId;
    private String webUrl;
    private String videoUrl;
}
