package com.bitc.securityquiz.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "jpa_member")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements UserDetails {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)   auto_increment 자동생성은 int 와 float 만 가능
    @Column(name = "id", updatable = false)
    private String id;

    @Column(nullable = false)
    private String pass;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "integer default 1")   // columnDefinition = "integer default 1"이 안통하는데 물어보기
//    @ColumnDefault("1")
    private int grade;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime regidate;

    @OneToMany(mappedBy = "member") // mappedBy는 주 테이블의 엔티티파일에 주 테이블의 엔티티 객체를 입력하면 됨
    @ToString.Exclude
    private List<Board> boardList = new ArrayList<>();  // @OneToMany 사용했을때

    @Builder    // 생성자인데 회원가입할때 들어가야할 항목을 다 넣어야함
    public Member(String id, String pass, String name, LocalDateTime regidate, int grade, String auth) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.regidate = regidate;
        this.grade = grade;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
