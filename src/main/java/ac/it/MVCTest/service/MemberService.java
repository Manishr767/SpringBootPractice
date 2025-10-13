package ac.it.MVCTest.service;

import ac.it.MVCTest.DTO.MemberDTO;
import ac.it.MVCTest.repository.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // make a object from this class anD STORE in it spring container
public class MemberService {

    @Autowired
    MemberDAO memberDAO;


    public void registNewMember(MemberDTO dto){
       memberDAO.insertMember(dto);

    }

    public MemberDTO login(MemberDTO memberDTO) {
        memberDAO.finduser(memberDTO);

        return memberDTO;
    }

    public List<MemberDTO> getAllmembers() {
        List<MemberDTO> list = memberDAO.getAllMembers();
        return list;
    }

    public MemberDTO findById(int id) {
        MemberDTO member = memberDAO.findById(id);
        return  member;

    }
}
