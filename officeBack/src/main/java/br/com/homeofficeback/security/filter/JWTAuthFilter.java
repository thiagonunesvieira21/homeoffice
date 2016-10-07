package br.com.homeofficeback.security.filter;

import java.io.IOException;
import java.security.Principal;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import org.jose4j.jwt.consumer.InvalidJwtException;

import br.com.homeofficeback.security.JWTSecured;
import br.com.homeofficeback.security.TokenHandler;

@JWTSecured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class JWTAuthFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("request filter invoked...");

		String authHeaderVal = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

//		if (authHeaderVal == null || !authHeaderVal.startsWith("Bearer ")) {
		if (authHeaderVal == null) {
			throw new NotAuthorizedException("Authorization header must be provided");
		}

		try {
			final String subject = validate(authHeaderVal);
			final SecurityContext securityContext = requestContext.getSecurityContext();
			if (subject != null) {
				requestContext.setSecurityContext(new SecurityContext() {
					@Override
					public Principal getUserPrincipal() {
						return new Principal() {
							@Override
							public String getName() {
								return subject;
							}
						};
					}

					@Override
					public boolean isUserInRole(String role) {
						return securityContext.isUserInRole(role);
					}

					@Override
					public boolean isSecure() {
						return securityContext.isSecure();
					}

					@Override
					public String getAuthenticationScheme() {
						return securityContext.getAuthenticationScheme();
					}
				});
			}
		} catch (InvalidJwtException ex) {
			System.out.println("JWT validation failed");

			requestContext.setProperty("auth-failed", true);
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());

		}

	}

	private String validate(String jwt) throws InvalidJwtException {
		TokenHandler tokenHandler = new TokenHandler();
		
		return tokenHandler.parseUserFromToken(jwt);
	}

}
