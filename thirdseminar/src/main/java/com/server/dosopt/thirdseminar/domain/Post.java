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

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // 일대다 관계에서는 다 쪽이 연관관계의 주인이다. 멤버가 탈퇴하면 게시글을 싹 다 날려야하지 않겠나? 그 때 cascade all
    @JoinColumn(name = "member_id")
    private Member member;

    @Embedded
    @Column(name = "category_id")
    private CategoryId categoryId;

    @Builder
    public Post(String title, String content, Member member, CategoryId categoryId) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.categoryId = categoryId;
    }

    // 이 때 @Builder 를 생성자 2개에 적용하게 되면 builder 를 사용할 때 적용되지 않는 경우가 있습니다.
    // 이 때는 builderMethodName option 을 추가하여, 사용해주시면 됩니다.
    @Builder(builderMethodName = "builderWithImageUrl")
    public Post(String title, String content, String imageUrl, Member member) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.member = member;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}
