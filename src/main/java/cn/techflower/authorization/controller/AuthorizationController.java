package cn.techflower.authorization.controller;

import cn.techflower.authorization.PermissionService;
import cn.techflower.authorization.controller.dto.RegisterDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@Slf4j
@AllArgsConstructor
public class AuthorizationController {
    private final PermissionService permissionService;

    @GetMapping("/login")
    public String startLogin(@RequestParam(required = false) Boolean error, Model model) {
        if (BooleanUtils.isTrue(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/perform_register")
    public String performRegister(@ModelAttribute("user") @Valid RegisterDto registerDto, BindingResult result, Model model) {
        if (Objects.nonNull(result) && !CollectionUtils.isEmpty(result.getAllErrors())) {
            List<String> msgList = result.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
            model.addAttribute("errors", msgList);
            return "register";
        }
        log.info("new register:{}", registerDto);
        permissionService.createNewUser(registerDto);
        return "login";
    }

    @GetMapping("/index")
    public String come() {
        return "index";
    }
}
