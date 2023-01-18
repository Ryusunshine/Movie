package com.example.movie.repository;

import com.example.movie.dto.MemberDTO;
import com.example.movie.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper mm;

    public MemberDTO findByMemberId(String userId) {
        return mm.findByUserId(userId);
    }

    public MemberDTO findByMemberNickname(String memberNickname) {
        return mm.findByMemberNickname(memberNickname);
    }

    public int signupMember(MemberDTO memberDTO) {
        return mm.signupMember(memberDTO);
    }

    public MemberDTO selectMemberDetail(String nickname) {
        return mm.selectMemberDetail(nickname);
    }
    public int updateMemberName(MemberDTO memberDTO) {
        return mm.updateMemberName(memberDTO);
    }
    public int updateMemberPassword(MemberDTO memberDTO) {
        return mm.updateMemberPassword(memberDTO);
    }

    public int updateIsMemberStatus(MemberDTO memberDTO) { // 본인이 회원 탈퇴
        return mm.updateIsMemberStatus(memberDTO);
    }

    public List<MemberDTO> selectAllCustomers() {
        return mm.selectAllCustomers();
    }

    public int memberStatus(MemberDTO memberDTO) { // 관리자가 회원 탈퇴
        return mm.memberStatus(memberDTO);
    }
}
