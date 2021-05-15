package mx.com.tt.RegisterService.repository;

import mx.com.tt.RegisterService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepositorty extends JpaRepository<User, Integer> {

    public static final String FIND_USER_BY_EMAIL = "SELECT * FROM user u WHERE u.email = ?1";
    public static final String FIND_USER_BY_USERNAME = "SELECT * FROM user u WHERE u.userName = ?1";

    @Query(value = FIND_USER_BY_EMAIL, nativeQuery = true)
    List<User> findUserByEmail(String email);

    @Query(value = FIND_USER_BY_USERNAME, nativeQuery = true)
    List<User> findUserByUserName(String username);

}
