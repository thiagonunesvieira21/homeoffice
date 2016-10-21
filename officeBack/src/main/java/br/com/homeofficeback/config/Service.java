package br.com.homeofficeback.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.homeofficeback.security.filter.JWTAuthFilter;
import br.com.homeofficeback.security.filter.JWTResponseFilter;
import br.com.homeofficeback.server.controller.AcessoControler;
import br.com.homeofficeback.server.controller.AuthController;
import br.com.homeofficeback.server.controller.ComercioController;
import br.com.homeofficeback.server.controller.TransacaoUsuarioController;
import br.com.homeofficeback.server.controller.UsuarioController;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("/v1")
public class Service extends Application {

	public Service() {
		BeanConfig conf = new BeanConfig();
		conf.setTitle("HomeOfiice API");
		conf.setDescription("The rest app to home office");
		conf.setVersion("1.0.0");
		conf.setHost("localhost:8443");
		conf.setBasePath("/homeoffice/v1");
		conf.setSchemes(new String[] { "http", "https" });
		conf.setResourcePackage("br.com.homeofficeback");
		conf.setScan(true);
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(JacksonJavaTimeConfiguration.class);
		resources.add(JWTAuthFilter.class);
		resources.add(JWTResponseFilter.class);
		resources.add(AuthController.class);
		resources.add(UsuarioController.class);
		resources.add(ComercioController.class);
		resources.add(AcessoControler.class);
		resources.add(TransacaoUsuarioController.class);
		// classes do swagger...
		resources.add(ApiListingResource.class);
		resources.add(SwaggerSerializers.class);
		return resources;
	}

}
