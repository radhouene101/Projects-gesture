package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.bal.pi.entities.Contest;
@Repository
public interface ContestRepository extends JpaRepository<Contest,Long> {
}
