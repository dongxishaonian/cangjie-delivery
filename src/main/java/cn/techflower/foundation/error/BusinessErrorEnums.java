package cn.techflower.foundation.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessErrorEnums {
    TRELLO_RESPONSE_DATA_ERROR("trello端响应数据异常！");
    private final String errorMessage;

}
