package cn.techflower.delivery.items.task.controller;

import cn.techflower.delivery.items.task.domian.dto.TaskDto;
import cn.techflower.delivery.items.task.enums.TaskSourceType;
import cn.techflower.delivery.items.task.service.TaskAdaptorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/delivery")
@Slf4j
@AllArgsConstructor
public class TaskController {
    private final TaskAdaptorService taskAdaptorService;

    @GetMapping(value = "/taskList")
    public ResponseEntity<List<TaskDto>> getTaskList(@RequestParam TaskSourceType taskSourceType) {
        return ResponseEntity.ok().build();
    }
}
