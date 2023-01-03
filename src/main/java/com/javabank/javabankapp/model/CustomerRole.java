package com.javabank.javabankapp.model;

public enum CustomerRole {
    USER("USER"),
    ADMIN("ADMIN");

    private  final String role;

    CustomerRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
