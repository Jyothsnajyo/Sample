package com.sample.project.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String email;
    private String password;
    private String role;
    private String address;
}
