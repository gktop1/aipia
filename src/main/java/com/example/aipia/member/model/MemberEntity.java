package com.example.aipia.member.model;


import com.example.aipia.common.BaseEntity;
import com.example.aipia.member.dto.MemberRegisterRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
public class MemberEntity extends BaseEntity {

    @Column(name = "login_id")
    @Comment("로그인 ID")
    private String loginId;

    @Column(name = "password")
    @Comment("비밀번호")
    private String password;

    @Column(name = "email")
    @Comment("e-mail")
    private String email;

    @Column(name = "first_name")
    @Comment("이름")
    private String firstName;

    @Column(name = "last_name")
    @Comment("성")
    private String lastName;

    @Column(name = "birth_date")
    @Comment("생년월일")
    private String birthDate;

    @Column(name = "phone_no")
    @Comment("핸드폰번호")
    private String phoneNo;

    @Column(name = "gender")
    @Comment("성별")
    private String gender;

    @Column(name = "last_login_time")
    @Comment("최종 로그인 시간")
    private LocalDateTime lastLoginTime;

    public MemberEntity(MemberRegisterRequest request) {
        this.loginId = request.loginId();
        this.password = request.password();
        this.email = request.email();
        this.firstName = request.firstName();
        this.lastName = request.lastName();
        this.birthDate = request.birthDate();
        this.phoneNo = request.phoneNo();
        this.gender = request.gender();
        this.lastLoginTime = LocalDateTime.now();
    }

    public void updateLastLoginTime() {
        this.lastLoginTime = LocalDateTime.now();
    }

}
