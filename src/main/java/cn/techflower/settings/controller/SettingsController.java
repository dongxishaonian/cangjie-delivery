package cn.techflower.settings.controller;

import cn.techflower.settings.controller.vo.TrelloSettingVo;
import cn.techflower.settings.domain.entity.TrelloSettingEntity;
import cn.techflower.settings.service.TrelloSettingService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller("/settings")
@Slf4j
@Data
public class SettingsController {
    private final TrelloSettingService trelloSettingService;

    @GetMapping("/settings")
    public String thirdSystemSettings(Model model) {
        log.info("thirdSystemSettings come in!!!");
        TrelloSettingEntity trelloSetting = trelloSettingService.getTrelloSetting();
        model.addAttribute("trelloSetting", trelloSetting);
        return "settings";
    }

    @PostMapping("/trelloSetting")
    public void createTrelloSetting(@ModelAttribute @Valid TrelloSettingVo trelloSettingVo, HttpServletResponse response) throws IOException {
        trelloSettingService.createTrelloSetting(trelloSettingVo);
        response.sendRedirect("/settings");
    }
}
