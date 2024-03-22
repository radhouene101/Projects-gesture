package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.bal.pi.entities.Projects;
@Repository
public interface ProjectsRepository extends JpaRepository<Projects,Long> {
}
