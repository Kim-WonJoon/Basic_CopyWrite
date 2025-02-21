package com.example.copywriting.todo.service;

import com.example.copywriting.member.entiry.Member;
import com.example.copywriting.member.repository.MemberRepository;
import com.example.copywriting.todo.dto.*;
import com.example.copywriting.todo.entiry.ToDo;
import com.example.copywriting.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public ToDoSaveResponseDto save(Long memberId, ToDoSaveRequestDto dto) {

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("그런 멤버 없음"));

        ToDo todo = new ToDo(dto.getContent(), member);
        ToDo savedToDo = toDoRepository.save(todo);
        return new ToDoSaveResponseDto(
                savedToDo.getId(),
                savedToDo.getContent(),
                member.getId(),
                member.getEmail());
    }

    @Transactional(readOnly = true)
    public List<ToDoResponseDto> findAll() {
        List<ToDo> toDos = toDoRepository.findAll();

        List<ToDoResponseDto> dtos = new ArrayList<>();
        for (ToDo todo : toDos) {
            dtos.add(new ToDoResponseDto(todo.getId(), todo.getContent()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ToDoResponseDto findById(Long todoId) {
        ToDo todo = toDoRepository.findById(todoId).orElseThrow(() -> new IllegalStateException("그런 todo 없음"));
        return new ToDoResponseDto(todo.getId(), todo.getContent());
    }

    @Transactional
    public ToDoUpdateResponseDto update(Long memberId, Long todoId, ToDoUpdateRequestDto dto) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("그런 멤버 없음"));

        ToDo todo = toDoRepository.findById(todoId).orElseThrow(() -> new IllegalStateException("그런 todo 없음"));

        if (!todo.getMember().getId().equals(member.getId())) {
            throw new IllegalStateException("todo작성자가 아닙니다.");
        }

        todo.update(dto.getContent());
        return new ToDoUpdateResponseDto(todo.getId(), todo.getContent());
    }

    @Transactional
    public void deleteById(Long memberId, Long todoId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("그런 멤버 없음"));

        ToDo todo = toDoRepository.findById(todoId).orElseThrow(() -> new IllegalStateException("그런 todo 없음"));

        if (!todo.getMember().getId().equals(member.getId())) {
            throw new IllegalStateException("todo작성자가 아닙니다.");
        }

        toDoRepository.deleteById(todoId);
    }
}
