package mx.com.tt.RegisterService.service;

import mx.com.tt.RegisterService.dto.request.UserRequest;
import mx.com.tt.RegisterService.dto.response.UserResponse;
import mx.com.tt.RegisterService.exceptions.RepeatedEmailException;
import mx.com.tt.RegisterService.exceptions.RepeatedUsernameException;
import mx.com.tt.RegisterService.model.User;
import mx.com.tt.RegisterService.repository.UserRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    @Autowired
    UserRepositorty userRepository;

    @Transactional
    @Override
    public UserResponse registerUser(UserRequest userRequest) throws Exception{

        User user = new User();

        User transactionUser = new User();
        String error = "";

        List<User> emailOccurrences = userRepository.findUserByEmail(userRequest.getEmail());
        List<User> usernameOccurrences = userRepository.findUserByUserName(userRequest.getUserName());

        int emailOccurrencesSize = emailOccurrences.size();
        int usernameOccurrencesSize = usernameOccurrences.size();

        user.setIdUser(userRequest.getIdUser());
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        user.setName(userRequest.getName());
        user.setLastname(userRequest.getLastname());
        user.setActivo(userRequest.isActivo());
        user.setEmail(userRequest.getEmail());
        user.setSex(userRequest.getSex());
        user.setRol(userRequest.getRol());

        UserResponse userResponse = new UserResponse();

        try{

            if(emailOccurrencesSize > 0) {
                error = "Ya existe un usuario registrado con ese email. Vuelve a intentar con otro.";
                throw new RepeatedEmailException("RESP_REGISTER_00_ERROR: "+"Ya existe un usuario registrado con ese email. Vuelve a intentar con otro.");
            } else if(usernameOccurrencesSize  > 0){
                error = "Ya existe un usuario registrado con ese username. Vuelve a intentar con otro.";
                throw new RepeatedUsernameException("RESP_REGISTER_00_ERROR: "+"Ya existe un usuario registrado con ese username. Vuelve a intentar con otro.");
            } else if(emailOccurrencesSize  == 0 && usernameOccurrencesSize == 0){
                transactionUser = userRepository.save(user);
            }

            userRepository.flush();

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            userResponse.setIdUser(transactionUser.getIdUser());
            userResponse.setUserName(transactionUser.getUserName());
            userResponse.setPassword(transactionUser.getPassword());
            userResponse.setName(transactionUser.getName());
            userResponse.setLastname(transactionUser.getLastname());
            userResponse.setActivo(transactionUser.isActivo());
            userResponse.setEmail(transactionUser.getEmail());
            userResponse.setSex(transactionUser.getSex());
            userResponse.setRol(transactionUser.getRol());
            userResponse.setRegisterStatus(true);
            userResponse.setRegisterMsg("Usuario registrado exitósamente. Enviando mensaje de confirmación.");
            userResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));


        }catch (Exception e){

            userResponse.setIdUser(user.getIdUser());
            userResponse.setUserName(user.getUserName());
            userResponse.setPassword(user.getPassword());
            userResponse.setName(user.getName());
            userResponse.setLastname(user.getLastname());
            userResponse.setActivo(user.isActivo());
            userResponse.setEmail(user.getEmail());
            userResponse.setSex(user.getSex());
            userResponse.setRol(user.getRol());
            userResponse.setRegisterStatus(false);
            userResponse.setRegisterMsg(error);
            userResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));

            e.printStackTrace();
        }

        return userResponse;
    }

}
