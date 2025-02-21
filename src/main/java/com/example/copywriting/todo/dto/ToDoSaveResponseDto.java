package com.example.copywriting.todo.dto;

import lombok.Getter;

@Getter
public class ToDoSaveResponseDto {

    private final Long id;
    private final String content;
    private final Long memberId;
    private final String memberEmail;

    public ToDoSaveResponseDto(Long id, String content, Long memberId, String memberEmail) {
        this.id = id;
        this.content = content;
        this.memberId = memberId;
        this.memberEmail = memberEmail;
    }
}
