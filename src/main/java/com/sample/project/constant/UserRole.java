package com.sample.project.constant;

public enum UserRole {

    USER,ADMIN;

    public static UserRole getUserRole(final String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.toString().equalsIgnoreCase(role)) {
                return userRole;
            }
        }
        return null; // The UserRole with given string representation not found
    }
}
