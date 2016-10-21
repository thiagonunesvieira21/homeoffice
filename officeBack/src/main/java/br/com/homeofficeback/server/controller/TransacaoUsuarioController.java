package br.com.homeofficeback.server.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import br.com.homeofficeback.entity.ComercioClientePkEntity;
import br.com.homeofficeback.model.ComercioClienteResult;
import br.com.homeofficeback.security.JWTSecured;
import br.com.homeofficeback.server.service.UsuarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Transações de usuário")
@Path("trasacaousuario")
public class TransacaoUsuarioController {

	@Context
	protected SecurityContext securityContext;
	
	@EJB
	private UsuarioServiceImpl service;
	
	@Context
    private HttpServletRequest request;
	
	@GET
	@Path("/vincular/{idComercio}")
	@JWTSecured
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Vincular", notes = "Vincula usuário ao comércio", response = ComercioClientePkEntity.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ComercioClienteResult vincular(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("idComercio") Integer idComercio) {
		String username = securityContext.getUserPrincipal().getName();
		
		return service.vincularAoComercio(username, idComercio);
	}
	
	
	@GET
	@JWTSecured
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Comércio vinculados", notes = "Lista os comércio vinculados", responseContainer="List" ,response = ComercioClienteResult.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<ComercioClienteResult> vincular(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization) {		

		String username = securityContext.getUserPrincipal().getName();
		
		return service.findByUserId(username);
	}
}
