package cn.techflower.delivery.items.task.domian.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CardDto {
    private String id;
    private String name;
    private String shortUrl;
    private String desc;
}
