package cn.techflower.delivery.domain.dto;

import cn.techflower.delivery.enums.ProcessToolEnums;
import cn.techflower.delivery.enums.ProcessTypeEnums;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ProcessDetailDto {
    private ProcessTypeEnums processType;
    private List<ProcessToolEnums> processTools;
}
