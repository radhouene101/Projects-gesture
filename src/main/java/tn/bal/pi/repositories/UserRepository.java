package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.bal.pi.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
