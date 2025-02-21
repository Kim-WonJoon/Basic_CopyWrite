package com.example.copywriting.todo.entiry;

import com.example.copywriting.member.entiry.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor

public class ToDo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public ToDo(String content, Member member) {
        this.content = content;
        this.member = member;
    }

    public void update(String content) {
        this.content = content;
    }
}
