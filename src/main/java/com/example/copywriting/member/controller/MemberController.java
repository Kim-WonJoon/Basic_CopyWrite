package com.example.copywriting.member.controller;

import com.example.copywriting.common.consts.Const;
import com.example.copywriting.member.dto.MemberResponseDto;
import com.example.copywriting.member.dto.MemberSaveRequestDto;
import com.example.copywriting.member.dto.MemberSaveResponseDto;
import com.example.copywriting.member.dto.MemberUpdateRequestDto;
import com.example.copywriting.member.repository.MemberRepository;
import com.example.copywriting.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

//    @PostMapping("/members")
//    public ResponseEntity<MemberSaveResponseDto> save(@RequestBody MemberSaveRequestDto dto) {
//        return ResponseEntity.ok(memberService.save(dto));
//    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponseDto>> getAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberResponseDto> getOne(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    @PutMapping("/members")
    public void update(
            @SessionAttribute(name = Const.LOGIN_MEMBER) Long memberId,
            @RequestBody MemberUpdateRequestDto dto) {
        memberService.update(memberId, dto);
    }

    @DeleteMapping("/members")
    public void delete(@SessionAttribute(name = Const.LOGIN_MEMBER) Long memberId) {
        memberService.deleteById(memberId);
    }
}
