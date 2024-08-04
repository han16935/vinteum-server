package com.aiia.Vinteum.userGroup;

import com.aiia.Vinteum.BaseEntity;
import com.aiia.Vinteum.group.Group;
import com.aiia.Vinteum.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Group group;

    private Boolean isLeader;
}
