package lt.codeacademy.javau5.securitysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.javau5.securitysql.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByEmail(String email);
}
