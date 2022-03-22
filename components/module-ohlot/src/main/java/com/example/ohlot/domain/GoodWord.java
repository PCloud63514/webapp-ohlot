package com.example.ohlot.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class GoodWord {
    @Id
    private UUID id;
    private String content;
    @CreatedDate
    @Column(name = "create_at", insertable = false, updatable = false, nullable = false)
    private Date createAt;
    @LastModifiedDate
    @Column(name = "update_at")
    private Date updateAt;

    @Builder
    public GoodWord(UUID id, String content, Date createAt, Date updateAt) {
        this.id = id;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}

