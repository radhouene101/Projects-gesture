package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.bal.pi.entities.CategoryProjects;

@Repository
public interface CategoryProjectsRepository extends JpaRepository<CategoryProjects,Long> {
}
