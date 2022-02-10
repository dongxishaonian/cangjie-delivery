package cn.techflower.delivery.items.task.controller.vo;

import cn.techflower.delivery.items.task.enums.TaskSourceType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskSearchVo {
    private TaskSourceType taskSource;
    private String trelloBoard;
}
