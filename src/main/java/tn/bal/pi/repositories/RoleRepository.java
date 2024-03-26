package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.bal.pi.entities.Role;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String roleName);
}
