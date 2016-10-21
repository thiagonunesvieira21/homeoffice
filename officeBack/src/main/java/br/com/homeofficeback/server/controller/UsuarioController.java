package br.com.homeofficeback.server.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import br.com.homeofficeback.entity.UsuarioEntity;
import br.com.homeofficeback.model.CadastroUsuario;
import br.com.homeofficeback.model.PesquisarUsuario;
import br.com.homeofficeback.security.JWTSecured;
import br.com.homeofficeback.server.service.UsuarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Usuários")
@Path("usuario")
public class UsuarioController {

	@Context
	protected SecurityContext securityContext;
	
	@EJB
	private UsuarioServiceImpl service;

	@GET
	@JWTSecured
	@ApiOperation(value = "Lista todos usuários", notes = "Lista todos usuários cadastrados", response = UsuarioEntity.class, responseContainer = "List", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<UsuarioEntity> listAll(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization) {
		return service.listAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Inclusao", notes = "Pré cadastro do usuário", response = Integer.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Integer create(@Valid CadastroUsuario usuario) {
		return service.create(usuario);
	}

	@PUT
	@JWTSecured
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Atualização", notes = "Atualização do usuário", response = UsuarioEntity.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public UsuarioEntity update(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("id") Integer id, @Valid CadastroUsuario usuario) {
		return service.update(usuario, id);
	}

	@DELETE
	@JWTSecured
	@Path("/{id}")
	@ApiOperation(value = "Exclusão", notes = "Exclusão de usuário", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public void delete(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("id") Integer id) {
		service.delete(id);
	}

	@GET
	@JWTSecured
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Pesquisa", notes = "Consulta de usuários",  response = UsuarioEntity.class, responseContainer = "List", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<UsuarioEntity> find(@BeanParam PesquisarUsuario usuario) {
		return service.find(usuario);
	}
	
	@GET
	@JWTSecured
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Recupera por id", notes = "Recupera usuário por id", response = UsuarioEntity.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public UsuarioEntity retrieveById(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("id") Integer id) {
		return service.findById(id);
	}
	
	@GET
	@JWTSecured
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Recupera por username", notes = "Recupera usuário por username", response = UsuarioEntity.class, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public UsuarioEntity retrieveByUserNamed(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorization, @PathParam("username") String username) {
		return service.findByUserName(username);
	}
}
