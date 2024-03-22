package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.bal.pi.entities.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option,Long> {
}
