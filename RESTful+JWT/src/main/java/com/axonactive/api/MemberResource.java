package com.axonactive.api;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.axonactive.member.Member;
import com.axonactive.member.MemberService;

@Stateless
@Path("members")
public class MemberResource {
	@EJB
	MemberService memberService;

	@EJB
	JWTAuthenticationService jwtAuthService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Member> getAllMembers(@HeaderParam("Authorization") String authorization) {
		try {
			jwtAuthService.checkAuthorizedToken(authorization);
			return memberService.getAllMembers();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMember(Member member) {
		try {
			memberService.addMember(member);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@GET
	@Path("token")
	@Produces(MediaType.APPLICATION_JSON)
	public Token getToken() {
		return jwtAuthService.createToken();
	}
	
	
}
