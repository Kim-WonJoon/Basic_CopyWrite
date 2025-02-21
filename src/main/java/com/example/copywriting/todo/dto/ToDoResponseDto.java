package com.example.copywriting.todo.dto;

import lombok.Getter;

@Getter
public class ToDoResponseDto {

    private final Long id;
    private final String content;

    public ToDoResponseDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
