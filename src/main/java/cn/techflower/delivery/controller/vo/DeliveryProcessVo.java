package cn.techflower.delivery.controller.vo;

import cn.techflower.delivery.domain.entity.DeliveryProcessEntity;
import cn.techflower.delivery.domain.entity.DeliveryProcessTemplateEntity;
import cn.techflower.delivery.enums.ProcessToolEnums;
import cn.techflower.delivery.enums.ProcessTypeEnums;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class DeliveryProcessVo {
    private DeliveryProcessTemplateEntity template;
    private DeliveryProcessEntity deliveryProcess;
    private List<List<ItemVo>> items;
    private Integer maxItemsSize;

    @Data
    @Accessors(chain = true)
    public static class ItemVo {
        private ProcessTypeEnums processTypeEnums;
        private Object processDetail;
    }
}
