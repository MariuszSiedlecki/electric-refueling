package com.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    private UserAppRepository userAppRepository;

    public CustomUserService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAppRepository
                .findUserAppByName(username)
                .map(CustomUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not find"));
    }
}

