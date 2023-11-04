package com.flow.flowbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class CustomExtension {
    @Id
    private String name; // 확장자명
    private boolean enabled;
    @LastModifiedDate
    @Column(name="added_at")
    private LocalDateTime addedAt; // 추가된 시각
}
