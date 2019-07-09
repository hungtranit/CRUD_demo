package com.axonactive.amigo;

import java.util.Base64;
import java.util.UUID;
import java.io.UnsupportedEncodingException;

public class Base64Convert {
	public static void main(String [] args) {
		String originalInput = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		
		System.out.println(encodedString);
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);
		//System.out.println(decodedBytes);
	}
}
