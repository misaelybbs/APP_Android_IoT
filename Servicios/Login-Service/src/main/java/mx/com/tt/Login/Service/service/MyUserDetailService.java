package mx.com.tt.Login.Service.service;

import mx.com.tt.Login.Service.model.User;
import mx.com.tt.Login.Service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("El usuario "+userName+ " no se encuentra registrado. Volver a intentar con un usuario registrado."));

        boolean activo = false;

        if(user.get().isActivo() == 1){
            activo = true;
        }

        MyUserDetails myUserDetails = new MyUserDetails(user.get().getUserName(), user.get().getPassword(), activo, new ArrayList<>());

        return myUserDetails;
    }
}
