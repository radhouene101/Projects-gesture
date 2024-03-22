package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.bal.pi.entities.Projects;

import java.util.List;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects,Long> {

    List<Projects> findAllByNominatedIsTrue();
}
