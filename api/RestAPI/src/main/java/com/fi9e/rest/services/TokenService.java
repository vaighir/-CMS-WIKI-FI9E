package com.fi9e.rest.services;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.entity.User;
import com.fi9e.rest.mappers.UserMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author Christopher
 *
 */
public class TokenService implements TokenServiceInterface {
	
	//used to sign keys
	private static final String SECRET_KEY = "fi9e_super_secret_secret";
	private static final String CLAIM_EMAIL = "email";
	private static final String CLAIM_USERNAME = "username";
	private static final String CLAIM_USER_ID = "user_id";
	
	@SuppressWarnings("deprecation")
	public Claims verifyToken(String token) {
		//This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = Jwts.parser()
	            .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
	            .parseClaimsJws(token).getBody();
	    return claims;
	}
	
	/**
	 * Create a JWT Token with custom claims (Custom Payload) | JWT with user data
	 * 
	 * @return String
	 */
	public String createToken(User user) {
		UserDTO dto = UserMapper.mapUserToUserDTO(user);
		
		return Jwts.builder()
				.setSubject("User")
				.claim(CLAIM_EMAIL, dto.getEmail())
				.claim(CLAIM_USERNAME, dto.getClass())
				.claim(CLAIM_USER_ID, dto.getId())
				.signWith(this.getKey())
				.compact();
	}
	
	/**
	 * Creates a secure singning Key from our secret SECRET_KEY
	 * 
	 * @return Key
	 */
	private Key getKey() {
		//The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		//We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    
	    return signingKey;
	}
	
}
