package NaniNaniApp.NaniNaniApp.service;

import NaniNaniApp.NaniNaniApp.model.CustomUserDetails;
import NaniNaniApp.NaniNaniApp.model.User;
import NaniNaniApp.NaniNaniApp.repo.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = jpaUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return (UserDetails) new CustomUserDetails(user);
    }

}

