package com.example.movie.service;

import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.UserRole;
import com.example.movie.error.DuplicatedMemberException;
import com.example.movie.error.ErrorMessage;
import com.example.movie.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {

    @Autowired
    MemberRepository mr;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public String createUser(MemberDTO memberDTO) {

        // 아이디 중복검사
        MemberDTO memberFindUserId = mr.findByMemberId(memberDTO.getUserId());
        if (memberFindUserId != null) {
            throw new DuplicatedMemberException(ErrorMessage.ERR_MSG_DUPLICATED_ID);
        }

        // 닉네임 중복검사
        MemberDTO memberFindUserNickname = mr.findByMemberNickname(memberDTO.getNickname());
        if (memberFindUserNickname != null) {
            throw new DuplicatedMemberException(ErrorMessage.ERR_MSG_DUPLICATED_NICKNAME);
        }

        //멤버 비밀번호 인코딩 해서 입력
        MemberDTO encodingPasswordMember = MemberDTO.builder()
                .userId(memberDTO.getUserId())
                .password(bCryptPasswordEncoder.encode(memberDTO.getPassword()))
                .nickname(memberDTO.getNickname())
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .birth(memberDTO.getBirth())
                .address(memberDTO.getAddress())
                .addressDetail(memberDTO.getAddressDetail())
                .phone(memberDTO.getPhone())
                .gender(memberDTO.getGender())
                .sns(memberDTO.getSns())
                .role(UserRole.USER.getValue())
                .build();

        //성공 여부 검사
        int okSignup = mr.signupMember(encodingPasswordMember);
        if (okSignup > 0) {
            return "success";
        }

        return "fail";
    }

    public MemberDTO finByMemberId(String memberId) {
        return mr.findByMemberId(memberId);
    }

    public MemberDTO selectMemberDetail(String nickname) {
        return mr.selectMemberDetail(nickname);
    }

    public String updateMemberName(MemberDTO memberDTO) {
        return String.valueOf(mr.updateMemberName(memberDTO));
    }

    public String updateMemberPassword(MemberDTO memberDTO) {
        return String.valueOf(mr.updateMemberPassword(memberDTO));
    }

    public String updateIsMemberStatus(MemberDTO memberDTO) {
        int result = mr.updateIsMemberStatus(memberDTO);

        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }
    public List<MemberDTO> selectAllCustomers() {
        return mr.selectAllCustomers();
    }

    public String memberStatus(MemberDTO memberDTO) {
        return String.valueOf(mr.memberStatus(memberDTO));
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        System.out.println(userId);
        return Optional.ofNullable(mr.findByMemberId(userId)).orElseThrow(() -> new BadCredentialsException("아이디를 확인해 주세요"));
    }
}
