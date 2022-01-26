package cn.techflower.foundation.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessErrorEnums {
    USER_NOT_FOUND("用户信息不存在！"),

    TRELLO_AUTH_CONFIG_NOT_FOUND("trello端认证配置未找到！"),
    TRELLO_RESPONSE_DATA_ERROR("trello端响应数据异常！");

    private final String errorMessage;

}
