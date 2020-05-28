package com.sample.project.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String message;
}
