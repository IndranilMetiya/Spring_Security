package com.indra.security.config;

import com.indra.security.model.Users;
import com.indra.security.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepo usersRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users=usersRepo.findByUserName(username);
        if (users==null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("USER Not Found");
        }

        return new MyUserDetails(users);
    }
}
