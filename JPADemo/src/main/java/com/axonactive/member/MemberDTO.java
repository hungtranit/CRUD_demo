package com.axonactive.member;

import javax.persistence.Entity;

import com.axonactive.amigo.Amigo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	

	private String firstName;
	private String lastName;

	private String gender;
	private String email;
	private String slogan;
}
