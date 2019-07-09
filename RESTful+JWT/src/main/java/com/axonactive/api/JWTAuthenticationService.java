package com.axonactive.api;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Stateless
public class JWTAuthenticationService {
	public Token createToken() {
		String token = null;
		try {
			Algorithm algorithm = Algorithm.HMAC256("abc");
			token = JWT.create().withIssuer("def").withJWTId("123").withClaim("username", "tuoinguyen")
					.withExpiresAt(getTimeToLive(1)).sign(algorithm);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return new Token(token, 1);
	}

	private Date getTimeToLive(int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, minute);
		return calendar.getTime();
	}

	public void checkAuthorizedToken(String authorization) throws Exception {
		if (authorization == null) {
			System.out.println("Wrong token");
			throw new Exception("Token is null");
		} else {
			String[] authenPath = authorization.split("\\s+");
			String jwtToken = authenPath[1];
			Algorithm algorithm = Algorithm.HMAC256("abc");
			JWTVerifier verify = JWT.require(algorithm).withIssuer("def").build();
			verify.verify(jwtToken);
		}
	}
}
