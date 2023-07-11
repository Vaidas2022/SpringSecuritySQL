package lt.codeacademy.javau5.securitysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.javau5.securitysql.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
