package com.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CustomUserService implements UserDetailsService {

    private UserAppRepository userAppRepository;
    private PasswordEncoder passwordEncoder;

    public CustomUserService(UserAppRepository userAppRepository, PasswordEncoder passwordEncoder) {
        this.userAppRepository = userAppRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAppRepository
                .findUserAppByName(username)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not find"));
    }

    public void saveUserApp(LoginUser loginUser) {

        UserApp result = UserApp
                .builder()
                .userName(loginUser.getUsername())
                .password(passwordEncoder.encode(loginUser.getPassword()))
                .active(1)
                .roles(new HashSet<>())
                .build();
        userAppRepository.save(result);
    }
}

