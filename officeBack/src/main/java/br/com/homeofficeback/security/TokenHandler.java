package br.com.homeofficeback.security;

import javax.ejb.EJB;

import br.com.homeofficeback.entity.UsuarioEntity;
import br.com.homeofficeback.server.service.UsuarioServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class TokenHandler {
	private String secret = "3Cpy6bMTornGJXXAxmjzgeL7g2UXeFuXyKkNElVFwNcFiVK7tiKa8flZ7cz28BB";

	@EJB
	private UsuarioServiceImpl userService;
	
	public TokenHandler() {

	}
	
	public String parseUserFromToken(String token) {
		Claims claims = getTokenPayload(token);
		String username = null;
		if(claims!=null){
			username = (String) claims.get("username");
		}
		return username;
	}

	public Integer getUserIdFromToken(String token) {
		token = token.replace("Bearer ", "");
		Claims claims = getTokenPayload(token);
		return (Integer) claims.get("id");

	}

	public Claims getTokenPayload(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	public String createTokenForUser(UsuarioEntity user) {
		Claims claims = Jwts.claims();
		claims.put("username", user.getDeLogin());
		claims.put("id", user.getId());
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();

	}
}
