package cn.techflower.foundation.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SelectOptionsVo {
    public String name;
    private String value;
}
