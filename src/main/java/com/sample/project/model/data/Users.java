package com.sample.project.model.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Column(nullable = false)
    private String username;

    private String email;

    private String address;

}
