package com.vabram.hearthum.service;

import com.vabram.hearthum.model.Analyzer;
import com.vabram.hearthum.repository.AnalyzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by brama051 on 15/08/2017.
 */
@Service
public class AnalyzerLoginService implements UserDetailsService {

    @Autowired
    private AnalyzerRepository analyzerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Analyzer analyzer = analyzerRepository.findByEmail(username);
        if (analyzer == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        return new User(analyzer.getEmail(), analyzer.getPassword(), getGrantedAuthorities(username));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
        Collection<? extends GrantedAuthority> authorities;
        if (username.equals("admin")) {
            authorities = Arrays.asList(() -> "ROLE_ADMIN", () -> "ROLE_BASIC");
        } else {
            authorities = Arrays.asList(() -> "ROLE_BASIC");
        }
        return authorities;
    }
}
