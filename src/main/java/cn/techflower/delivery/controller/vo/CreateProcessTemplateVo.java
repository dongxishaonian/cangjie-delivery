package cn.techflower.delivery.controller.vo;

import cn.techflower.delivery.enums.ProcessNodeEnums;
import cn.techflower.delivery.enums.ProcessToolEnums;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Accessors(chain = true)
public class CreateProcessTemplateVo {
    @Size(min = 1, message = "节点数量不能小于1！")
    @NotNull(message = "节点配置不能为空！")
    private List<ProcessNodeEnums> nodeType;
    @Size(min = 1, message = "工具数量必须大于1！")
    @NotNull(message = "工具配置不能为空！")
    private List<ProcessToolEnums> nodeTool;
    @NotBlank(message = "模板名称不能为空！")
    private String templateName;
}
