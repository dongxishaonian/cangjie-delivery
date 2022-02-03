package cn.techflower.settings.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@Data
public class SettingsController {
    @GetMapping("/settings")
    public String thirdSystemSettings() {
        return "settings";
    }
}
