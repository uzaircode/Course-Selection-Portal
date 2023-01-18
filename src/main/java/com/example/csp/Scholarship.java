package com.example.csp;

public class Scholarship {
    private String index;
    private String status;
    private String name;
    private String types;
    private String level;


    public Scholarship(String index, String status, String name, String types, String level) {
        this.index = index;
        this.status = status;
        this.name = name;
        this.types = types;
        this.level = level;
    }

    public String getIndex() {
        return index;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getTypes() {
        return types;
    }

    public String getLevel() {
        return level;
    }
}
