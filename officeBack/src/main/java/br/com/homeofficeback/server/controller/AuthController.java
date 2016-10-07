package br.com.homeofficeback.server.controller;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.homeofficeback.entity.UsuarioEntity;
import br.com.homeofficeback.model.Credentials;
import br.com.homeofficeback.security.TokenHandler;
import br.com.homeofficeback.server.service.UsuarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Autenticação")
@Path("/auth")
public class AuthController {
	
	@EJB
	private UsuarioServiceImpl service;
	
	@Context
    private HttpServletRequest request;
	
	@GET
	@Path(value="/logout")
	@ApiOperation(notes="Logout", value = "Logout do sistema")
	public void logout() {
		HttpSession session = request.getSession();
		session.invalidate();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(notes="Guarde o token gerado para futuras requisições", value = "Login do sistema", response=String.class)
	public Response authenticateUser(Credentials credential) {

		try {

			String username = credential.getUsername();
			String password = credential.getPassword();

			UsuarioEntity user = authenticate(username, password);

			String token = issueToken(user);

			return Response.ok(token)
					.build();

		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	private UsuarioEntity authenticate(String username, String password) throws Exception {
		
		UsuarioEntity user = service.doLogin(username, password);
		
		if(user!=null){
			
			HttpSession session = request.getSession();
			session.setAttribute("sec-user", user);
			session.setMaxInactiveInterval(30*60);
			
		}else{
			throw new NotAuthorizedException("Authorization header must be provided");
		}
		
		return user;
	}

	private String issueToken(UsuarioEntity user) {
		TokenHandler tokenHandler = new TokenHandler();
		return tokenHandler.createTokenForUser(user);
	}
}
