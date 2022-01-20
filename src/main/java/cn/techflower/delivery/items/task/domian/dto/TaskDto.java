package cn.techflower.delivery.items.task.domian.dto;

import cn.techflower.delivery.items.task.enums.TaskSourceType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class TaskDto implements Serializable {
    private TaskSourceType sourceType;
    private String title;
    private String taskKey;
    private String taskUrl;
}
