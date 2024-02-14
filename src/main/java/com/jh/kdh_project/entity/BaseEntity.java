package com.jh.kdh_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value={AuditingEntityListener.class})
@Getter
public class BaseEntity {

    @CreatedDate
    @Column(name="register_date",updatable=false)
    private LocalDateTime registerDate;

    @LastModifiedDate
    @Column(name="update_date")
    private LocalDateTime updateDate;

    @LastModifiedDate
    @Column(name="delete_date", nullable = true)
    private LocalDateTime deleteDate;

}
