package br.com.homeofficeback.server.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import br.com.homeofficeback.entity.ComercioEntity;
import br.com.homeofficeback.entity.ProprietarioPkEntity;
import br.com.homeofficeback.model.CadastrarComercio;
import br.com.homeofficeback.model.CadastroUsuario;
import br.com.homeofficeback.model.PesquisarComercio;
import br.com.homeofficeback.security.JWTSecured;
import br.com.homeofficeback.server.service.ComercioServiceImpl;
import br.com.homeofficeback.server.service.ProprietarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Comércio")
@Path("comercio")
public class ComercioController {

	@Context
	protected SecurityContext securityContext;
	
	@EJB
	private ComercioServiceImpl service;
	
	@EJB
	private ProprietarioServiceImpl proprietarioService;

	@GET
	@JWTSecured
	@ApiOperation(value = "Lista todos comércios", notes = "Lista todos comércios cadastrados", response = ComercioEntity.class, responseContainer = "List", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<ComercioEntity> listAll(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization) {
		return service.listAll();
	}
	
	@POST
	@JWTSecured
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Inclusão", notes = "Cadastro do comércio", response = Integer.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Integer create(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @Valid CadastrarComercio cadastrarComercio) {
		return service.create(cadastrarComercio);
	}

	@PUT
	@JWTSecured
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Alteração", notes = "Atualização do comércio", response = ComercioEntity.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ComercioEntity update(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("id") Integer id, @Valid CadastrarComercio cadastrarComercio) {
		return service.update(cadastrarComercio, id);
	}
	
	@PUT
	@JWTSecured
	@Path("/addUser/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Adiciona Proprietário", notes = "Inclui proprietário ao comércio", response = ProprietarioPkEntity.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ProprietarioPkEntity addUser(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("id") Integer id, @Valid CadastroUsuario cadastroUsuario) {
		return proprietarioService.create(cadastroUsuario, id);
	}

	@DELETE
	@JWTSecured
	@Path("/{id}")
	@ApiOperation(value = "Exclusão", notes = "Exclusão de comércio", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public void delete(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("id") Integer id) {
		service.delete(id);
	}

	@GET
	@JWTSecured
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Pesquisa", notes = "Pesquisa usuário", response = ComercioEntity.class, responseContainer = "List", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<ComercioEntity> find(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @QueryParam("search") String search) {
		return service.find(new PesquisarComercio(search, search, search));
	}
	
	@GET
	@JWTSecured
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Pesquisa por id", notes = "recupera usuário por id", response = ComercioEntity.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ComercioEntity retrieveById(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("id") Integer id) {
		return service.findById(id);
	}
}
