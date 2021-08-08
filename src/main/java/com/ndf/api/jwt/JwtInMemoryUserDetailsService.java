package com.ndf.api.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "Michael89",
				"$2a$10$6X6MznD5VSURnouzV2/kuecUyBsjzhW8eTl4zPFzlxTivAdYn9dZC", "ROLE_USER_1"));
		inMemoryUserList.add(new JwtUserDetails(2L, "mayk89",
				"$2a$10$QXcPAi4CLcXTKNQpXS1IAuzA10BsxV4rkFeEpVxpLudOaVOPPldNO", "ROLE_USER_2"));

		//$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}
}