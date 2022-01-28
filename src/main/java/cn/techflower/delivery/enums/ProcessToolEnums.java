package cn.techflower.delivery.enums;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum ProcessToolEnums {
    TRELLO("Trello",Lists.newArrayList(ProcessNodeEnums.TASK)),
    GITHUB("Github",Lists.newArrayList(ProcessNodeEnums.FEATURE, ProcessNodeEnums.PULL_REQUEST, ProcessNodeEnums.CODE_REVIEW, ProcessNodeEnums.MERGE)),
    GITHUB_ACTION("Github Action",Lists.newArrayList(ProcessNodeEnums.CI)),
    JENKINS("Jenkins",Lists.newArrayList(ProcessNodeEnums.CI)),
    GERRIT("Gerrit",Lists.newArrayList(ProcessNodeEnums.CODE_REVIEW)),
    GITLAB("Gitlab",Lists.newArrayList(ProcessNodeEnums.FEATURE, ProcessNodeEnums.PULL_REQUEST, ProcessNodeEnums.CODE_REVIEW, ProcessNodeEnums.MERGE));

    private final String desc;
    private final List<ProcessNodeEnums> processNode;
}
