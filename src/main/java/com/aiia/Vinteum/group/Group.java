package com.aiia.Vinteum.group;

import com.aiia.Vinteum.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "`group`")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    @Column(unique = true)
    private String joinCode;

    @Column(length = 50000)
    private String commonSchedule;
}
