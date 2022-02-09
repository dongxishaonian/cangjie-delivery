package cn.techflower.foundation.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@Data
public class FrontendController {
    @GetMapping("/leftBar")
    public String leftBar() {
        return "leftBar";
    }

    @GetMapping("/header")
    public String header() {
        return "header";
    }
}
