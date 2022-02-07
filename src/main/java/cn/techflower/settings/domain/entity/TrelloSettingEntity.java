package cn.techflower.settings.domain.entity;

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
@Table(name = "trello_setting")
@EntityListeners(AuditingEntityListener.class)
public class TrelloSettingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String oauthConsumerKey;

    private String oauthToken;

    private String owner;

    @Column
    @CreatedBy
    private String createdBy;

    @Column
    @LastModifiedBy
    private String lastModifiedBy;

    @Column
    @CreatedDate
    private LocalDateTime created;

    @Column
    @LastModifiedDate
    private LocalDateTime updated;
}
