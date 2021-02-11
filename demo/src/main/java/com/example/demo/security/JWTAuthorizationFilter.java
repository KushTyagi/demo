package com.example.demo.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/*
      The Authorization Filter
      
      As we have implemented the filter responsible for authenticating users, we now need to implement the filter responsible for user authorization. 
      We create this filter as a new class, called JWTAuthorizationFilter, 
      simply here we authenticate user token and we verify the token of user at the time of login if token successfully verified we allow to user go forword 
      otherwise we don't forword request.
*/

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	   String header = request.getHeader(SecurityConstants.HEADER_STRING);
	   
	   if(header == null || header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
		   chain.doFilter(request, response);
	   }
	   
	   UsernamePasswordAuthenticationToken authentication = getAuthenticate(request);
	   SecurityContextHolder.getContext().setAuthentication(authentication);
	   chain.doFilter(request, response); 
	}
	
	/*
	    We have extended the BasicAuthenticationFilter to make Spring replace it in the filter chain with our custom implementation. 
	    The most important part of the filter that we've implemented is the private getAuthentication method. 
	    This method reads the JWT from the Authorization header, and then uses JWT to validate the token. 
	    If everything is in place, we set the user in the SecurityContext and allow the request to move on.
	*/
	
	private UsernamePasswordAuthenticationToken getAuthenticate(HttpServletRequest request) {
		String token = request.getHeader(SecurityConstants.HEADER_STRING);
		if(token != null) {
			String user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes())) 
					.build().verify(token.replace(SecurityConstants.TOKEN_PREFIX, "")).getSubject();
			
			if(user != null) {
				return new UsernamePasswordAuthenticationToken(user,null);
			}
			return null;
		}
		return null;
	}
}
