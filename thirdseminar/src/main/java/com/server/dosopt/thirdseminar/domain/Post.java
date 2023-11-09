package com.server.dosopt.thirdseminar.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "post")
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT") // 이렇게 명시해주지 않으면 기본적으로 varchar로 저장된다.
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // 일대다 관계에서는 다 쪽이 연관관계의 주인이다. 멤버가 탈퇴하면 게시글을 싹 다 날려야하지 않겠나? 그 때 cascade all
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}