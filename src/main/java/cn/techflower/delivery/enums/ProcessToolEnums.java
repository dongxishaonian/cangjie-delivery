package cn.techflower.delivery.enums;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum ProcessToolEnums {
    TRELLO(Lists.newArrayList(ProcessNodeEnums.TASK)),
    GITHUB(Lists.newArrayList(ProcessNodeEnums.FEATURE, ProcessNodeEnums.PULL_REQUEST, ProcessNodeEnums.CODE_REVIEW, ProcessNodeEnums.MERGE)),
    GITHUB_ACTION(Lists.newArrayList(ProcessNodeEnums.CI)),
    JENKINS(Lists.newArrayList(ProcessNodeEnums.CI)),
    GERRIT(Lists.newArrayList(ProcessNodeEnums.CODE_REVIEW)),
    GITLAB(Lists.newArrayList(ProcessNodeEnums.FEATURE, ProcessNodeEnums.PULL_REQUEST, ProcessNodeEnums.CODE_REVIEW, ProcessNodeEnums.MERGE));


    private final List<ProcessNodeEnums> processNode;
}
