package cn.techflower.delivery.items.task.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskSourceType {
    TRELLO("Trello"),
    JIRA("Jira");

    private final String desc;
}
