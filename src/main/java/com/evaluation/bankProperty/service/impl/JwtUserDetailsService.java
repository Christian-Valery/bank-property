package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.config.JwtTokenUtil;
import com.evaluation.bankProperty.model.UsersEntity;
import com.evaluation.bankProperty.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	private static final Logger log = LogManager.getLogger(JwtUserDetailsService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UsersEntity user = userRepository.findByName(login);
		if (user == null) {
			log.error("Erreur lors de la recherche de l'utilisateur");
			throw new UsernameNotFoundException("Utilisateur avec le LOGIN : " + login +" introuvable. Veuiller vous enregistrer avant de vous connecter. Merci");
		}
		return new User(user.getLogin(), user.getPassword(), new ArrayList<>());
	}

	public UsersEntity save(UsersEntity user) {
		UsersEntity newUser = new UsersEntity();
		newUser.setName(user.getName());
		newUser.setLogin(user.getLogin());
		newUser.setPassword(jwtTokenUtil.encryptMdp(user.getPassword()) );
		newUser.setBusinessUnit(user.getBusinessUnit());
		newUser.setContactNumber(user.getContactNumber());
		log.info("Insertion Sender entity effectuée avec succès");
		return userRepository.save(newUser);
	}
}
