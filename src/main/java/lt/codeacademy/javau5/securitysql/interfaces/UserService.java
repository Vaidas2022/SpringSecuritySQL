package lt.codeacademy.javau5.securitysql.interfaces;

import jakarta.validation.Valid;
import lt.codeacademy.javau5.securitysql.entities.UserData;
import lt.codeacademy.javau5.securitysql.exceptions.UserAlreadyExistException;

public interface UserService {

	void register(@Valid UserData userData)  throws UserAlreadyExistException ;

}
