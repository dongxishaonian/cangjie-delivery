package cn.techflower.delivery.items.task.domian.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TrelloConfigDto {
    private String trelloKey;
    private String trelloToken;
}
