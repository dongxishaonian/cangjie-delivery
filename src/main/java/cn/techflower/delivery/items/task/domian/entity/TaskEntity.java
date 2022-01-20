package cn.techflower.delivery.items.task.domian.entity;

import cn.techflower.delivery.domain.entity.DeliveryProcessEntity;
import cn.techflower.delivery.items.task.enums.TaskSourceType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "task")
@EntityListeners(AuditingEntityListener.class)
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private TaskSourceType sourceType;

    private String title;

    private String taskKey;

    private String taskUrl;

    @OneToOne
    @JoinColumn(name = "delivery_process_id")
    private DeliveryProcessEntity deliveryProcess;

    @Column
    @CreatedBy
    private String createdBy;

    @Column
    @LastModifiedBy
    private LocalDateTime lastModifiedBy;

    @Column
    @CreatedDate
    private LocalDateTime created;

    @Column
    @LastModifiedDate
    private LocalDateTime updated;
}
