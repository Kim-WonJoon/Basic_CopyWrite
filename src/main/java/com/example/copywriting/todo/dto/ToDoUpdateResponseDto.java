package com.example.copywriting.todo.dto;

import lombok.Getter;

@Getter
public class ToDoUpdateResponseDto {

    private final Long id;
    private final String content;

    public ToDoUpdateResponseDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
