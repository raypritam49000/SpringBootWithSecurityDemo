package net.corejava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.corejava.entity.User;
import net.corejava.repository.UserRepository;


public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepository.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("No User found for given email");
		}

		return new CustomUserDetails(user);
	}

}
