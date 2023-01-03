package com.javabank.javabankapp.config;

import com.javabank.javabankapp.model.Customer;
import com.javabank.javabankapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JavaBankUserDetails implements UserDetailsService {

    CustomerRepository customerRepository;

    @Autowired
    public JavaBankUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> user = customerRepository.findByEmail(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("User with this credentials: " + username + " do not exist!");
        }else{
            String userName = user.get().getEmail();
            String password = user.get().getPassword();
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.get().getRole().toString()));
            return new User(username,password,authorities);
        }
    }
}
