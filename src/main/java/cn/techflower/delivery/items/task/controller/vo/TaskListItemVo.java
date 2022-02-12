package cn.techflower.delivery.items.task.controller.vo;

import cn.techflower.delivery.items.task.enums.TaskSourceType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskListItemVo {
    private TaskSourceType sourceType;
    private String title;
    private String taskKey;
    private String taskUrl;
    private String desc;
    private Long deliveryProcessId;
}
