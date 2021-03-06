package cn.techflower.foundation.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessErrorEnums {
    CUSTOM_ERROR(""),

    USER_NOT_FOUND("用户信息不存在！"),

    DELIVERY_PROCESS_TEMPLATE_ALREADY_EXIST("开发流程模板已存在！"),
    DELIVERY_PROCESS_TEMPLATE_NOT_FOUND("开发流程模板不存在！"),
    NODE_LIST_MUST_EQUALS_TOOL_LIST("节点列表需要和工具列表一一对应！"),

    DELIVERY_PROCESS_NOT_FOUND("开发流程不存在！"),

    TRELLO_AUTH_CONFIG_NOT_FOUND("trello端认证配置未找到！"),
    TRELLO_RESPONSE_DATA_ERROR("trello端响应数据异常！"),

    TASK_SOURCE_NOT_FOUND("未提供任务来源！"),
    TRELLO_BOARD_NOT_FOUNT("未提供trello看板！"),
    TASK_NOT_FOUNT("开发任务不存在！");

    private final String errorMessage;

}
