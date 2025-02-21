package com.example.copywriting.member.dto;

import lombok.Getter;

@Getter
public class MemberSaveRequestDto {

    private String email;

    // 아무런 생성자가 없을 때는 기본적으로 기본생성자가 추가되기 때문에 @NoArgsConstuctor 같은 어노테이션이 불필요
}
