package cn.techflower.authorization.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class RegisterDto {
    @NotBlank(message = "用户名不能为空！")
    private String username;
    @NotBlank(message = "密码不能为空！")
    @Size(min = 6, message = "密码的长度必须大于6！")
    private String password;
    @NotBlank(message = "再次输入的密码不能为空！")
    @Size(min = 6, message = "再次输入的密码的长度必须大于6！")
    private String passwordAgain;
}
