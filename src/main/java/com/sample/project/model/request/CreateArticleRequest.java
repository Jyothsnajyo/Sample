package com.sample.project.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.keycloak.representations.AccessToken;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateArticleRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;

    @Type(type="text")
    private String body;

    private String author;

    private String accessToken;
}
