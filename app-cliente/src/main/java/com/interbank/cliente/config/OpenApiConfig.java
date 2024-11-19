package com.interbank.cliente.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name = "jose",
						email = "vijb20@gmail.com",
						url = "https://pbi.com/productos"
						),
				description = "OpenApi documentacion para productos",
				title = "OpenApi especificacion - productos",
				version = "1.0",
				license = @License(
						name = "Lincence PBI",
						url = "https://some-url.com"
						),
				termsOfService = "Terminos del servicio"
				),
		servers = {
				@Server(
						description = "LOCAL ENV",
						url = "http://localhost:8091"
						),
				@Server(
						description = "PROD ENV",
						url = "https://pbi.com/productos"
						),
		}
//		,
//		security = {
//				@SecurityRequirement(
//						name = "bearerAuth"
//						)				
//		}
		)
//@SecurityScheme(
//		name = "bearerAuth",
//		description = "JWT auth descripcion",
//		scheme = "bearer",
//		type = SecuritySchemeType.HTTP,
//		bearerFormat = "JWT",
//		in = SecuritySchemeIn.HEADER
//		)
public class OpenApiConfig {

}
