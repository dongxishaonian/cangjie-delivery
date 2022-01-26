package cn.techflower.delivery.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProcessTypeEnums{
    TASK,
    FEATURE,
    CI,
    CODE_REVIEW,
    PULL_REQUEST,
    TESTING,
    MERGE;

}
