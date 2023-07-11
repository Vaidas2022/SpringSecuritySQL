package lt.codeacademy.javau5.securitysql.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lt.codeacademy.javau5.securitysql.repositories.UserRepository;
import lt.codeacademy.javau5.securitysql.entities.UserData;
import lt.codeacademy.javau5.securitysql.entities.UserEntity;
import lt.codeacademy.javau5.securitysql.exceptions.UserAlreadyExistException;
import lt.codeacademy.javau5.securitysql.interfaces.UserService;

@Service("userService")
public class DefaultUserService implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void register(UserData user) throws UserAlreadyExistException {

        //Let's check if user already registered with us
        if(checkIfUserExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);
    }

	private void encodePassword(UserEntity userEntity, UserData user) {
		userEntity.setPassword( passwordEncoder.encode(user.getPassword()) );		
	}

	private boolean checkIfUserExist(String email) {
		return userRepository.findByEmail(email) !=null ? true : false;		
	}
}
