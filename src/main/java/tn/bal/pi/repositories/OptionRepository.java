package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.bal.pi.entities.Option;

public interface OptionRepository extends JpaRepository<Option,Long> {
}
