package br.com.homeofficeback.server.controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import br.com.homeofficeback.entity.ComercioClientePkEntity;
import br.com.homeofficeback.security.JWTSecured;
import br.com.homeofficeback.server.service.UsuarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Transações de usuário")
@Path("trasacaousuario")
public class TransacaoUsuario {

	@Context
	protected SecurityContext securityContext;
	
	@EJB
	private UsuarioServiceImpl service;
	
	@PUT
	@Path("/vincular/{idComercio}")
	@JWTSecured
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Vincular", notes = "Vincula usuário ao comércio", response = ComercioClientePkEntity.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ComercioClientePkEntity vincular(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("idComercio") Integer idComercio) {
		String username = securityContext.getUserPrincipal().getName();
		
		return service.vincularAoComercio(username, idComercio);
	}
	
}
