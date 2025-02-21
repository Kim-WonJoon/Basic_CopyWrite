package com.example.copywriting.todo.controller;

import com.example.copywriting.common.consts.Const;
import com.example.copywriting.todo.dto.*;
import com.example.copywriting.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping("todos")
    public ResponseEntity<ToDoSaveResponseDto> save(
            @SessionAttribute(name = Const.LOGIN_MEMBER) Long memberId,
            @RequestBody ToDoSaveRequestDto dto) {
        return ResponseEntity.ok(toDoService.save(memberId, dto));
    }

    @GetMapping("todos")
    public ResponseEntity<List<ToDoResponseDto>> getAll() {
        return ResponseEntity.ok(toDoService.findAll());
    }

    @GetMapping("todos/{todoId}")
    public ResponseEntity<ToDoResponseDto> getOne(@PathVariable Long todoId) {
        return ResponseEntity.ok(toDoService.findById(todoId));
    }

    @PutMapping("/todos/{todoId}")
    public ResponseEntity<ToDoUpdateResponseDto> update(
            @SessionAttribute(name = Const.LOGIN_MEMBER) Long memberId,
            @PathVariable Long todoId,
            @RequestBody ToDoUpdateRequestDto dto) {
        return ResponseEntity.ok(toDoService.update(memberId, todoId, dto));
    }

    @DeleteMapping("/todos/{todoId}")
    public void delete(
            @SessionAttribute(name = Const.LOGIN_MEMBER) Long memberId,
            @PathVariable Long todoId) {
        toDoService.deleteById(memberId, todoId);
    }
}
