package id.co.bca.magenta.api.merchantcare.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(info = @Info(title = "MAGENTA REST API",
		description = "REST API for BCA Magenta", version = "2.0"))
/*@SecurityScheme(name = "security_auth", type = SecuritySchemeType.OAUTH2,
		flows = @OAuthFlows(authorizationCode = @OAuthFlow(
				authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}",
				tokenUrl = "${springdoc.oAuthFlow.tokenUrl}", scopes = {
				@OAuthScope(name = "read", description = "read scope"),
				@OAuthScope(name = "write", description = "write scope") })))*/
/*@SecurityScheme(name = "security_auth", type = SecuritySchemeType.HTTP,
		scheme = "bearer")*/
public class OpenApiConfig {}