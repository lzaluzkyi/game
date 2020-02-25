package com.rpg.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@Entity
@Table(name = "charapter")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nick_name")
    private String name;

    @Column(name = "HP")
    private Integer hitPoint;

    @Column(name = "MP")
    private Integer manaPoint;

    @Column(name = "power")
    private Integer power;

    @ManyToOne
    private HeroClass heroClass;

    private Integer currHP;

    private Integer currMP;

    @PrePersist
    public void onCreate(){

        this.currHP = hitPoint;
        this.currMP = manaPoint;

    }


}
