package j.m.w.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Implementation of Springs UserDetailsService, which is Springs core interface to load user data.
 * If you want to hook into a true datasource, wire one up here!
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("Jason".equals(username)) {

            //Note: passwords need to be stored in some kind of format??
           return new User("Jason", "$2a$10$tAlXr6fN0m0fCBSCSdOWxuvi9i15OZf/O9luCfyvPuVM4qs9Dtlji",
               new ArrayList<>());

        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
