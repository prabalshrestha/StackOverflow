package com.et.stackoverflow.service;


import com.et.stackoverflow.config.MyUserDetails;
import com.et.stackoverflow.model.User;
import com.et.stackoverflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        /*Optional<User> user= userRepository.findByUserName(userName);*/
        User user=userRepository.getUserByUserName(userName);
       /* user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();*/
        if(user==null)
        {
            throw new UsernameNotFoundException("could not find username");
        }
        MyUserDetails myUserDetails=new MyUserDetails(user);
        return myUserDetails;
    }
}
