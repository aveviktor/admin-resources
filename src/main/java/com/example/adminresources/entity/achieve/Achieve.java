package com.example.adminresources.entity.achieve;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "achieve")
public class Achieve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private AchieveNames name;

    @Column(name = "icon")
    private byte[] icon;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AchieveIncreaseType type;

    @Column(name = "value")
    private Long value;

    @ElementCollection(targetClass = AchieveTags.class)
    @Column(name = "achieve_tags")
    @Enumerated(EnumType.STRING)
    private List<AchieveTags> tagsList;
}
