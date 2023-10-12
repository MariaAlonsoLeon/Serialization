package org.model;

import java.io.Serializable;

public class Theater implements Serializable {
    private String name;
    private String location;

    public Theater(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Teatro " + this.getName() + " en " + this.getLocation();
    }
}