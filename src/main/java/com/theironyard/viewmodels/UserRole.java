package com.theironyard.viewmodels;

import java.util.List;

/**
 * Created by graceconnelly on 2/22/17.
 */
public class UserRole {
    List<String> Roles;

    public UserRole(List<String> roles) {
        Roles = roles;
    }

    public UserRole() {
    }

    public List<String> getRoles() {
        return Roles;
    }

    public void setRoles(List<String> roles) {
        Roles = roles;
    }
}
