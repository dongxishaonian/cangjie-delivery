package cn.techflower.delivery.controller.vo;

import cn.techflower.delivery.items.task.enums.TaskSourceType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateProcessVo {
    private Long templateId;
    private String taskKey;
    private String taskUrl;
    private TaskSourceType taskSourceType;
}
