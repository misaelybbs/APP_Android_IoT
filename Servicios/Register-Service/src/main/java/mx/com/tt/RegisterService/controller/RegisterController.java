package mx.com.tt.RegisterService.controller;

import mx.com.tt.RegisterService.dto.request.UserRequest;
import mx.com.tt.RegisterService.dto.response.GeneralAPIResponse;
import mx.com.tt.RegisterService.dto.response.UserResponse;
import mx.com.tt.RegisterService.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello")
    public  String hello(){
        return "Hello message!!!";
    }


    @PostMapping("/newUser")
    @ApiOperation(value = "Servicio de Registro de usuarios para TT2019-B087")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Respuesta éxitosa {code: RESP_REGISTER_00}."),
                    @ApiResponse(code = 400, message = "Error {code: Datos incompletos. Favor de volver a intentar. "),
                    @ApiResponse(code = 422, message = "Error {code: Datos incorrectos. Favor de volver a intentar. "),
                    @ApiResponse(code = 500, message = "Error {code: Error en el servicio de registro."),
                    @ApiResponse(code = 503, message = "Error {code: Servicio no disponible. Favor de intentar más tarde.")
            }
    )
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest){

        UserResponse userResponse = null;

        try{
            userResponse = registerService.registerUser(userRequest);


        } catch (Exception e){
            e.printStackTrace();
        }

        GeneralAPIResponse generalAPIResponse = new GeneralAPIResponse(
                userResponse.isRegisterStatus()?messageSource.getMessage("response.user.register", null, LocaleContextHolder.getLocale()):messageSource.getMessage("response.user.register.error", null, LocaleContextHolder.getLocale()),
                userResponse.isRegisterStatus()?"Usuario registrado exitósamente. Enviando mensaje de confirmación.":userResponse.getRegisterMsg(),
                userResponse
        );

        return new ResponseEntity<>(generalAPIResponse, userResponse.isRegisterStatus()?HttpStatus.CREATED:HttpStatus.BAD_REQUEST);

    }

}
