package com.parts.demo.entity;

import javax.persistence.*;
//Will add more details soon
@Entity
@Table(name="parts")
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "body_components")
    private String bodyComponents;

    @Column(name="doors")
    private String doors;

    @Column(name="windows")
    private String windows;

public Parts(){

}

public Parts(String bodyComponents, String doors, String windows){
    this.bodyComponents = bodyComponents;
    this.doors = doors;
    this.windows = windows;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBodyComponents() {
        return bodyComponents;
    }

    public void setBodyComponents(String bodyComponents) {
        this.bodyComponents = bodyComponents;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getWindows() {
        return windows;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", bodyComponents='" + bodyComponents + '\'' +
                ", doors='" + doors + '\'' +
                ", windows='" + windows + '\'' +
                '}';
    }
}

