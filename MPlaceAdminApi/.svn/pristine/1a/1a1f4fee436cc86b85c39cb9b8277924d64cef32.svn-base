package com.telemune.marketplace.rest.service.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telemune.marketplace.rest.entity.MarketPlaceAdminUser;
import com.telemune.marketplace.rest.repository.MarketPlaceAdminUserRepository;

/**
 * Manjeet
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    MarketPlaceAdminUserRepository marketPlaceAdminUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

    	MarketPlaceAdminUser user = marketPlaceAdminUserRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
                );

        return UserPrinciple.build(user);
    }
}