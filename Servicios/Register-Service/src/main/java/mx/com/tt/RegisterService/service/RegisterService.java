package mx.com.tt.RegisterService.service;

import mx.com.tt.RegisterService.dto.request.UserRequest;
import mx.com.tt.RegisterService.dto.response.UserResponse;

public interface RegisterService {

    UserResponse registerUser(UserRequest userRequest) throws Exception;

}
