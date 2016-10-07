package br.com.homeofficeback.security.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import br.com.homeofficeback.entity.UsuarioEntity;
import br.com.homeofficeback.security.TokenHandler;

@Provider
public class JWTResponseFilter implements ContainerResponseFilter {

	@Context
    HttpServletRequest webRequest;
	
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        if (requestContext.getProperty("auth-failed") != null) {
            Boolean failed = (Boolean) requestContext.getProperty("auth-failed");
            if (failed) {
                System.out.println("JWT auth failed. No need to return JWT token");
                return;
            }
        }

        if(webRequest.getSession().getAttribute("sec-user")!=null){
        
	        List<Object> jwt = new ArrayList<Object>();
	        TokenHandler tokenHandler = new TokenHandler();
	        jwt.add(tokenHandler.createTokenForUser((UsuarioEntity) webRequest.getSession().getAttribute("sec-user")));
	        // jwt.add(requestContext.getHeaderString("Authorization").split(" ")[1]);
	        responseContext.getHeaders().put("jwt", jwt);
	        System.out.println("Added JWT to response header 'jwt'");
        }
    }
}
