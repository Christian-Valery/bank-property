package com.evaluation.bankProperty.config;

import com.evaluation.bankProperty.service.impl.JwtUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {
	private static final Logger log = LogManager.getLogger(JwtRequestFilter.class);

	private static final String STATUS_CODE="Code";
	private static final String MESSAGE="Message";

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private final ObjectMapper mapper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException {

		Map<String, Object> errorDetails = new HashMap<>();
		String clientId = null;
		try {
			final String requestTokenHeader = request.getHeader("Authorization");

			String jwtToken = null;
			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
				jwtToken = requestTokenHeader.substring(7);
				clientId = jwtTokenUtil.getClientIdFromToken(jwtToken);
			}

			if (clientId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(clientId);
				boolean tokenValidation = jwtTokenUtil.validateToken(jwtToken, userDetails);
				if (tokenValidation) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}

			String url = request.getRequestURL().toString();

			if (((Objects.equals(requestTokenHeader, null)) || (Objects.equals(requestTokenHeader, ""))) && (url.endsWith("sms"))) {
				log.warn("Le Token JWT est nul");
				errorDetails.put(STATUS_CODE, HttpStatus.FORBIDDEN.value());
				errorDetails.put(MESSAGE, "Le Token JWT ne doit pas être vide");
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
				mapper.writeValue(response.getWriter(), errorDetails);
			}

		}catch (IllegalArgumentException e) {
			log.warn("Impossible d'obtenir le Token JWT");
			errorDetails.put(STATUS_CODE, HttpStatus.FORBIDDEN.value());
			errorDetails.put(MESSAGE, "Impossible d'obtenir le Token JWT");
			response.setStatus(HttpStatus.FORBIDDEN.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			mapper.writeValue(response.getWriter(), errorDetails);
		} catch (ExpiredJwtException e) {
			log.warn("Le Token JWT est expiré");
			errorDetails.put(STATUS_CODE, HttpStatus.FORBIDDEN.value());
			errorDetails.put(MESSAGE, "Le Token JWT est expiré");
			response.setStatus(HttpStatus.FORBIDDEN.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			mapper.writeValue(response.getWriter(), errorDetails);
		} catch(UsernameNotFoundException exception){
			log.error("L'utilisateur ayant un ClIENT_ID {} est introuvable", clientId);
			errorDetails.put(STATUS_CODE, HttpStatus.FORBIDDEN.value());
			errorDetails.put(MESSAGE, "L'utilisateur ayant un ClIENT_ID "+clientId+" est introuvable");
			response.setStatus(HttpStatus.FORBIDDEN.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			mapper.writeValue(response.getWriter(), errorDetails);
		}catch (NullPointerException ex) {
			log.error("Le Token JWT est vide  ");
			errorDetails.put(STATUS_CODE, HttpStatus.FORBIDDEN.value());
			errorDetails.put(MESSAGE, "Le Token JWT est vide");
			response.setStatus(HttpStatus.FORBIDDEN.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			mapper.writeValue(response.getWriter(), errorDetails);
		}
		try {
			chain.doFilter(request, response);
		}catch (Exception ex){
			log.info("L'exception a déjà été levée");
		}
	}
}
