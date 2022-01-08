package cn.techflower.authorization.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RegisterDto {
    private String username;
    private String password;
    private String passwordAgain;
}
