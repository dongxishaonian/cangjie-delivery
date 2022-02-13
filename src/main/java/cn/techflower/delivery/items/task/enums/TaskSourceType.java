package cn.techflower.delivery.items.task.enums;

import cn.techflower.delivery.enums.ProcessToolEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum TaskSourceType {
    TRELLO("Trello", ProcessToolEnums.TRELLO),
    JIRA("Jira", null);

    private final String desc;
    private final ProcessToolEnums processTool;

    public static Optional<TaskSourceType> getTaskSourceType(ProcessToolEnums processTool) {
        return  Arrays.stream(TaskSourceType.values())
            .filter(f -> processTool.equals(f.getProcessTool()))
            .findFirst();
    }
}
