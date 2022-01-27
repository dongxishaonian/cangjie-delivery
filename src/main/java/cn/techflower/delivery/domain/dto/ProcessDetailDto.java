package cn.techflower.delivery.domain.dto;

import cn.techflower.delivery.enums.ProcessToolEnums;
import cn.techflower.delivery.enums.ProcessNodeEnums;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ProcessDetailDto {
    private ProcessNodeEnums processNode;
    private List<ProcessToolEnums> processTools;
}
