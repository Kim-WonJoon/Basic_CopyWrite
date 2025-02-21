package com.example.copywriting.member.service;

import com.example.copywriting.member.dto.MemberResponseDto;
import com.example.copywriting.member.dto.MemberSaveRequestDto;
import com.example.copywriting.member.dto.MemberSaveResponseDto;
import com.example.copywriting.member.dto.MemberUpdateRequestDto;
import com.example.copywriting.member.entiry.Member;
import com.example.copywriting.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    @Transactional
//    public MemberSaveResponseDto save(MemberSaveRequestDto dto) {
//
//        Member member = new Member(dto.getEmail());
//        Member savedMember = memberRepository.save(member);
//        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getEmail());
//    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findAll();

//        List<MemberResponseDto> dtos = new ArrayList<>();
//        for (Member member : members) {
//            dtos.add(new MemberResponseDto(member.getId(), member.getEmail()));
//        }
//        return dtos;
        return members.stream().map(member -> new MemberResponseDto(member.getId(), member.getEmail())).toList();
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("그런 사람 없음"));
        return new MemberResponseDto(member.getId(), member.getEmail());
    }

    @Transactional
    public void update(Long memberId, MemberUpdateRequestDto dto) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("그런 사람 없음"));
        member.update(dto.getEmail());
    }

    @Transactional
    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
