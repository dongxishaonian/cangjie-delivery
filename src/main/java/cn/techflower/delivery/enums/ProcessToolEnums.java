package cn.techflower.delivery.enums;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum ProcessToolEnums {
    TRELLO(Lists.newArrayList(ProcessTypeEnums.TASK)),
    GITHUB(Lists.newArrayList(ProcessTypeEnums.FEATURE, ProcessTypeEnums.PULL_REQUEST, ProcessTypeEnums.CODE_REVIEW, ProcessTypeEnums.MERGE)),
    GITHUB_ACTION(Lists.newArrayList(ProcessTypeEnums.CI)),
    JENKINS(Lists.newArrayList(ProcessTypeEnums.CI)),
    GERRIT(Lists.newArrayList(ProcessTypeEnums.CODE_REVIEW)),
    GITLAB(Lists.newArrayList(ProcessTypeEnums.FEATURE, ProcessTypeEnums.PULL_REQUEST, ProcessTypeEnums.CODE_REVIEW, ProcessTypeEnums.MERGE));


    private final List<ProcessTypeEnums> processType;
}
