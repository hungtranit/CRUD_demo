package com.axonactive.member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class MemberController {

//	private Member employee = new Member();

//	@Inject
	@EJB
	private MemberService memberService;

	List<Member> memberList = new ArrayList<Member>();

	List<MemberDTO> memberDTOList = new ArrayList<MemberDTO>();

	public List<MemberDTO> getMemberDTOList() {
		return memberDTOList;
	}

	public void setMemberDTOList(List<MemberDTO> memberDTOList) {
		this.memberDTOList = memberDTOList;
	}

	@PostConstruct
	public void init() {
		memberDTOList = memberService
				.getMembers("male", "").stream().map(
						x -> MemberDTO.builder()
						.email(x.getEmail())
						.firstName(x.getFirstName())
						.gender(x.getGender())
						.lastName(x.getLastName())
						.build())
				.collect(Collectors.toList());
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public List<Member> getEmployeeList() {
		return memberList;
	}
}