package com.example.aipia.member.dto;

public record MemberRegisterRequest(String loginId, String password, String email, String firstName, String lastName,
                                    String birthDate, String phoneNo, String gender) {
}
