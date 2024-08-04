package com.aiia.Vinteum.timetable;

import com.aiia.Vinteum.BaseEntity;
import com.aiia.Vinteum.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TimeTable extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User userId;

    @Enumerated(EnumType.STRING)
    private TableType tableType;

    private String filePath;
}
