package com.mydemo.classroomapis.Security;


import com.mydemo.classroomapis.Entity.Person;
import com.mydemo.classroomapis.Repository.PersonRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ApplcationDetailService implements UserDetailsService {

    private final PersonRepository personRepository;

    public ApplcationDetailService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person user = personRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");

        return new User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
