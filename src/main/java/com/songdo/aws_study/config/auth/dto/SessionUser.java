package com.songdo.aws_study.config.auth.dto;

import com.songdo.aws_study.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//인증된 사용자 정보만 필요
@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
