package com.rpg.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer hitPoint;

    @Column(nullable = false)
    private Integer manaPoint;

    @Column(nullable = false)
    private Integer power;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    private Integer currHP;

    private Integer currMP;


    public Monster() {
    }

    @PrePersist
    public void onCreate(){

        this.currHP = hitPoint;
        this.currMP = manaPoint;

    }


    public Monster(String name, Integer hitPoint, Integer manaPoint, Integer power) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.manaPoint = manaPoint;
        this.power = power;
    }
}
