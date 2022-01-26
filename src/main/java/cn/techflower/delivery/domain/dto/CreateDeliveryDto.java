package cn.techflower.delivery.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateDeliveryDto {
    private String name;
}
