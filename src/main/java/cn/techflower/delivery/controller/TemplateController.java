package cn.techflower.delivery.controller;

import cn.techflower.delivery.controller.vo.CreateProcessTemplateVo;
import cn.techflower.delivery.domain.dto.ProcessDetailDto;
import cn.techflower.delivery.enums.ProcessNodeEnums;
import cn.techflower.delivery.enums.ProcessToolEnums;
import cn.techflower.delivery.service.DeliveryProcessTemplateService;
import cn.techflower.foundation.error.BusinessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static cn.techflower.foundation.error.BusinessErrorEnums.NODE_LIST_MUST_EQUALS_TOOL_LIST;

@Controller
@Slf4j
@Data
public class TemplateController {
    private final DeliveryProcessTemplateService deliveryProcessTemplateService;

    @GetMapping("/processTemplate")
    public String deliveryProcessTemplate() {
        return "processTemplate";
    }

    @PostMapping("/template")
    public ResponseEntity<?> createProcessTemplate(@ModelAttribute @Valid CreateProcessTemplateVo templateVo) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(templateVo));
        List<ProcessNodeEnums> processNodeEnumsList = templateVo.getNodeType();
        List<ProcessToolEnums> processToolEnumsList = templateVo.getNodeTool();
        if (processNodeEnumsList.size() != processToolEnumsList.size()) {
            throw new BusinessException(NODE_LIST_MUST_EQUALS_TOOL_LIST);
        }

        List<ProcessDetailDto> processDetailDtoList = IntStream.range(0, processNodeEnumsList.size())
            .mapToObj(m -> new ProcessDetailDto()
                .setProcessTools(Lists.newArrayList(processToolEnumsList.get(m)))
                .setProcessNode(processNodeEnumsList.get(m)))
            .collect(Collectors.toList());

        deliveryProcessTemplateService.createDeliveryProcessTemplate(templateVo.getTemplateName(), processDetailDtoList);
        return ResponseEntity.ok().build();
    }
}
