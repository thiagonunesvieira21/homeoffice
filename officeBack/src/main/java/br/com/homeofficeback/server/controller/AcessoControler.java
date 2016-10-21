package br.com.homeofficeback.server.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.jose4j.jwt.GeneralJwtException;

import br.com.homeofficeback.entity.AcessoEntity;
import br.com.homeofficeback.entity.AcessoPkEntity;
import br.com.homeofficeback.entity.ComercioEntity;
import br.com.homeofficeback.model.AcessoResult;
import br.com.homeofficeback.model.CadastrarAcesso;
import br.com.homeofficeback.model.PesquisaAcessoComercio;
import br.com.homeofficeback.security.JWTSecured;
import br.com.homeofficeback.server.service.AcessoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Acessos ao Comércio")
@Path("acesso")
public class AcessoControler {

	@Context
	protected SecurityContext securityContext;
	
	@EJB
	private AcessoServiceImpl service;
	
	@POST
	@JWTSecured
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Inclusão", notes = "Cadastro do Acesso", response = Integer.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public AcessoPkEntity create(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @Valid CadastrarAcesso cadastrarAcesso) throws GeneralJwtException {
		String username = securityContext.getUserPrincipal().getName();
		
		return service.create(username, cadastrarAcesso);
	}
	
	@PUT
	@JWTSecured
	@Path("/{status}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Alteracão", notes = "Atualização do Acesso", response = ComercioEntity.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public AcessoEntity update(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization,@Valid @BeanParam AcessoPkEntity id, @PathParam("status") String status) throws GeneralJwtException {
		return service.update(status, id);
	}
	
	@GET
	@JWTSecured
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Pesquisa por id", notes = "Recupera acesso por id", response = AcessoEntity.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public AcessoEntity retrieveById(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @BeanParam AcessoPkEntity id) {
		return service.findById(id);
	}
	
	@GET
	@JWTSecured
	@Path("/searchByComercioAndUser/{idComercio}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Pesquisa", notes = "Pesquisa acessos por comércio e usuário", response = AcessoResult.class, responseContainer = "List", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<AcessoResult> find(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("idComercio") Integer idComercio) {
		String username = securityContext.getUserPrincipal().getName();
		
		return service.findByUsuarioAndComercio(username, idComercio);
	}
	
	@GET
	@JWTSecured
	@Path("/searchAllByUser")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Pesquisa", notes = "Pesquisa todos os acessos por usuário", response = AcessoResult.class, responseContainer = "List", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<AcessoResult> find(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization) {
		String username = securityContext.getUserPrincipal().getName();
		
		return service.findByUsuario(username);
	}
	
	@GET
	@JWTSecured
	@Path("/searchByDateAndComercio")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Pesquisa", notes = "Pesquisa acessos por data e comércio", response = AcessoEntity.class, responseContainer = "List", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<AcessoEntity> find(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @BeanParam PesquisaAcessoComercio acessoComercio) {
		
		return service.findByDateAndComercio(acessoComercio);
	}
}
