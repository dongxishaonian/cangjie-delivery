package cn.techflower.delivery.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProcessTypeEnums{
    TASK("开发任务"),
    FEATURE("特性分支"),
    CI("持续集成"),
    CODE_REVIEW("代码评审"),
    PULL_REQUEST("合并请求"),
    TESTING("测试"),
    MERGE("代码合并");

    private final String desc;
}
