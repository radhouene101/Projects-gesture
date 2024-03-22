package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.bal.pi.entities.Projects;

public interface ProjectsRepository extends JpaRepository<Projects,Long> {
}
