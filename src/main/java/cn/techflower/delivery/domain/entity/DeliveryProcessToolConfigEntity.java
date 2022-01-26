package cn.techflower.delivery.domain.entity;

import cn.techflower.delivery.enums.ProcessToolEnums;
import cn.techflower.delivery.enums.ProcessTypeEnums;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "delivery_process_template")
@TypeDef(name = "json", typeClass = JsonStringType.class)
@EntityListeners(AuditingEntityListener.class)
public class DeliveryProcessToolConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private DeliveryProcessTemplateEntity template;

    @Enumerated(value = STRING)
    private ProcessTypeEnums processType;

    @Type(type = "json")
    private List<ProcessToolEnums> processToolList;

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
