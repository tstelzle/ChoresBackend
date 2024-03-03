package com.tstelzle.choresbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chores")
public class Chore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "`interval`", nullable = false)
    private int interval;
    @Column(name = "done", nullable = false)
    private int currentInterval;

    public Chore(String name, int interval, int currentInterval) {
        this.name = name;
        this.interval = interval;
        this.currentInterval = currentInterval;
    }

    public Chore() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentInterval() {
        return currentInterval;
    }

    public void setCurrentInterval(int currentInterval) {
        this.currentInterval = currentInterval;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }


    public String toString() {
        return String.format("%s,%d,%b", name, interval, currentInterval);
    }
}
