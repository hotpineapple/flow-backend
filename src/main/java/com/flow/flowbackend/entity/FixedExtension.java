package com.flow.flowbackend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FixedExtension {
    @Id
    private String name; // 확장자명
    @Column(name="is_blocked")
    private boolean isBlocked; // 차단 여부
}
