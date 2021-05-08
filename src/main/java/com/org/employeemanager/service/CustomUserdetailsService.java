package com.org.employeemanager.service;

import com.org.employeemanager.Repo.UserRepository;
import com.org.employeemanager.model.CustUserDetails;
import com.org.employeemanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserdetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        /*if(userName.equalsIgnoreCase("Mayur")){
            return new User("Mayur","Mayur123",new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("USer not Found!!!");
        }*/
        User user=this.userRepository.findByUsername(userName);
        if(user==null){
            throw new UsernameNotFoundException("User not Found!!!");
        }else{
            return new CustUserDetails(user);
        }

    }
}
