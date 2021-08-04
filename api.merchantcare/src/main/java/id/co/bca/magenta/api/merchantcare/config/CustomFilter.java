package id.co.bca.magenta.api.merchantcare.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.adapters.spi.KeycloakAccount;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class CustomFilter extends OncePerRequestFilter {

	@Value("${securityEnabled}")
	private boolean securityEnabled;

	@Value("${grantedRoles}")
	private String[] grantedRoles;

	@Override
	public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		if (!securityEnabled) {
			// Read roles from application.yml
			Set<String> roles = Arrays.stream(grantedRoles).collect(Collectors.toCollection(HashSet::new));
			// Dummy Keycloak-Account
			RefreshableKeycloakSecurityContext session = new RefreshableKeycloakSecurityContext(null, null, null, null,
					null, null, null);
			final KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = new KeycloakPrincipal<>(
					"Dummy_Principal", session);
			final KeycloakAccount account = new SimpleKeycloakAccount(principal, roles,
					principal.getKeycloakSecurityContext());
			// Dummy Security Context
			SecurityContext context = SecurityContextHolder.createEmptyContext();
			context.setAuthentication(new KeycloakAuthenticationToken(account, false));
			SecurityContextHolder.setContext(context);

			// Skip the rest of the filters
			req.getRequestDispatcher(req.getServletPath()).forward(req, res);
		}

		chain.doFilter(req, res);
	}
}
