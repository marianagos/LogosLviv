package ua.lviv.lgs.service.impl;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service("customAuthenticationProvider")
public class CustomSecurityProvider implements AuthenticationProvider {

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		System.out.println("Authenticate");
		String username = authentication.getName();
        String password = (String) authentication.getCredentials();
 
		return new UsernamePasswordAuthenticationToken(username, password, null);
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}

}
