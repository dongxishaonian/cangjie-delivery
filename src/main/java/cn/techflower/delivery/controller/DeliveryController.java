package cn.techflower.delivery.controller;


import cn.techflower.delivery.controller.vo.DeliveryProcessVo;
import cn.techflower.delivery.domain.dto.ProcessDetailDto;
import cn.techflower.delivery.domain.entity.DeliveryProcessEntity;
import cn.techflower.delivery.domain.entity.DeliveryProcessTemplateEntity;
import cn.techflower.delivery.enums.ProcessNodeEnums;
import cn.techflower.delivery.items.task.domian.dto.TaskDto;
import cn.techflower.delivery.items.task.enums.TaskSourceType;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@Data
public class DeliveryController {

    @GetMapping("/index")
    public String startLogin(Model model) {
        DeliveryProcessVo deliveryProcessVo = new DeliveryProcessVo();
        deliveryProcessVo.setTemplate(new DeliveryProcessTemplateEntity()
            .setProcessDetailList(Lists.newArrayList(new ProcessDetailDto().setProcessNode(ProcessNodeEnums.TASK),
                new ProcessDetailDto().setProcessNode(ProcessNodeEnums.FEATURE),
                new ProcessDetailDto().setProcessNode(ProcessNodeEnums.CI),
                new ProcessDetailDto().setProcessNode(ProcessNodeEnums.PULL_REQUEST),
                new ProcessDetailDto().setProcessNode(ProcessNodeEnums.CODE_REVIEW),
                new ProcessDetailDto().setProcessNode(ProcessNodeEnums.MERGE))));
        deliveryProcessVo.setDeliveryProcess(new DeliveryProcessEntity().setName("test"));
        TaskDto taskDto = new TaskDto().setTitle("我的第一个开发发任务，所以我把他用来测试！哈哈哈")
            .setSourceType(TaskSourceType.TRELLO)
            .setTaskKey("QWER_!@#")
            .setTaskUrl("https://trello.com/c/V5ieXJ5h");
        deliveryProcessVo.setItems(List.of(List.of(new DeliveryProcessVo.ItemVo().setProcessNodeEnums(ProcessNodeEnums.TASK).setProcessDetail(taskDto))));
        deliveryProcessVo.setMaxItemsSize(1);

        model.addAttribute("DeliveryProcessDetail", deliveryProcessVo);
        return "index";
    }
}
