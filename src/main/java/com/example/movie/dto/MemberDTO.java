package com.example.movie.dto;

import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class MemberDTO implements UserDetails {

    @Nullable
    private long id;

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]{7,15}$",
            message = "아이디는 최소 7자 이상 하나이상의 영 문자와 숫자가 필요합니다.")
    private String userId;
    @NotNull
    @Pattern(regexp = "[A-Za-z0-9@$!%*#?&]{8,15}$"
            , message = "비밀번호는 8자 이상, 하나 이상의 문자, 하나이상의 숫자 및 특수문자가 필요합니다.")
    private String password;
    @NotNull(message = "닉네임은 필수입니다.")
    private String nickname;
    @NotNull
    @Pattern(regexp = "[가-힣]{2,5}", message = "이름을 한글로 입력해 주세요")
    private String name;
    @Min(10)
    private String phone;

    @Nullable
    private String address;
    @Nullable
    private String addressDetail;
    @NotNull
    @Email
    private String email;
    @Nullable
    private String gender;
    @Nullable
    private String sns;
    @Nullable
    private String birth;
    @Nullable
    private String indate;
    @Nullable
    private String isMember;
    @Nullable
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(role));
        return roles;
    }

    @Override
    public String getUsername() {
        return getUserId();
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