package com.example.copywriting.member.entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor  // @Entity를 라이브러리에서 사용하려면 기본 생성자가 필요함.
                    // 기본 생성자가 있으면 아무런 파라미터 없이 객체를 생성할 수 있음. 그래서 @NoArgsConstructor로 기본생성자를 자동생성.

public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    public Member(String email) {
        this.email = email;
    }

    public void update(String email) {
        this.email = email;
    }
}
