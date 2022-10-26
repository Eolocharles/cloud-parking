package one.digitalinnovation.cloudparking.config.security;

import one.digitalinnovation.cloudparking.model.User;
import one.digitalinnovation.cloudparking.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email: " + username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), true, true, true, true, user.getAuthorities());

    }
}
