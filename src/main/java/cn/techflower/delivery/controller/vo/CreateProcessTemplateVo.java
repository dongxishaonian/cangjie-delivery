package cn.techflower.delivery.controller.vo;

import cn.techflower.delivery.enums.ProcessNodeEnums;
import cn.techflower.delivery.enums.ProcessToolEnums;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Accessors(chain = true)
public class CreateProcessTemplateVo {
    private List<ProcessNodeEnums> nodeType;
    private List<ProcessToolEnums> nodeTool;
    @NotBlank
    private String templateName;
}
