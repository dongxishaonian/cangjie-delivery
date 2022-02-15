package cn.techflower.delivery.controller;


import cn.techflower.delivery.controller.vo.CreateProcessVo;
import cn.techflower.delivery.enums.ProcessNodeEnums;
import cn.techflower.delivery.enums.ProcessToolEnums;
import cn.techflower.delivery.service.DeliveryService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Stream;

@Controller
@Slf4j
@Data
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping("/deliveryProcess")
    public String startLogin() {
        return "deliveryProcess";
    }

    @GetMapping("/deliveryProcessDetail")
    public String getDeliveryProcessDetail(Model model, @RequestParam Long deliveryProcessId) {
        model.addAttribute("DeliveryProcessDetail", deliveryService.getDeliveryProcessDetail(deliveryProcessId));
        return "deliveryProcessDetail";
    }

    @GetMapping(value = "/deliveryProcessTypeList", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getDeliveryProcessTypeList() {
        StringBuilder content = new StringBuilder();
        Stream.of(ProcessNodeEnums.values()).forEach(p -> content.append(String.format("<option value=\"%s\">%s</option>", p.name(), p.getDesc())));
        return ResponseEntity.ok(content.toString());
    }

    @GetMapping(value = "/processToolList", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getProcessToolList(@RequestParam ProcessNodeEnums nodeType) {
        StringBuilder content = new StringBuilder();
        Stream.of(ProcessToolEnums.values())
            .filter(f -> f.getProcessNode().contains(nodeType))
            .forEach(p -> content.append(String.format("<option value=\"%s\">%s</option>", p.name(), p.getDesc())));
        return ResponseEntity.ok(content.toString());
    }

    @PostMapping(value = "/deliveryProcess")
    public ResponseEntity<?> createDeliveryProcess(@ModelAttribute CreateProcessVo createProcessVo) {
        log.info("body:{}", createProcessVo);
        deliveryService.createDeliveryProcess(createProcessVo);
        return ResponseEntity.ok().build();
    }
}
