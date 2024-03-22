package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.bal.pi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
