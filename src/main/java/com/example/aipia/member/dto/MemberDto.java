package com.example.aipia.member.dto;

import com.example.aipia.member.model.MemberEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDto {

    private Long id;
    private String loginId;
    private String email;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phoneNo;
    private String gender;
    private LocalDateTime lastLoginTime;

    public MemberDto(Long id, String loginId, String email, String firstName, String lastName, String birthDate, String phoneNo, String gender, LocalDateTime lastLoginTime) {
        this.id = id;
        this.loginId = loginId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.lastLoginTime = lastLoginTime;
    }

    public static MemberDto toDto(MemberEntity entity) {
        return new MemberDto(entity.getId(), entity.getLoginId(), entity.getEmail(),
                entity.getFirstName(), entity.getLastName(), entity.getBirthDate(),
                entity.getPhoneNo(), entity.getGender(), entity.getLastLoginTime());
    }
}
