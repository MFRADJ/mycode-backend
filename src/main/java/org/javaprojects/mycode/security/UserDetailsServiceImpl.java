package org.javaprojects.mycode.security;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.javaprojects.mycode.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                //To-do check this error in the user class ( add findByusername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}