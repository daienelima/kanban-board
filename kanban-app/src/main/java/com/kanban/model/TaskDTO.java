package com.kanban.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {


    @ApiModelProperty(position = 1)
    private String title;

    @ApiModelProperty(position = 2)
    private String description;

    @ApiModelProperty(position = 3)
    private String color;

    @ApiModelProperty(position = 4)
    private TaskStatus status;

}
