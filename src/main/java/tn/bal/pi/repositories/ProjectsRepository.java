package tn.bal.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.bal.pi.entities.Option;
import tn.bal.pi.entities.Projects;
import tn.bal.pi.entities.TypeNiveau;

import java.util.List;
@Repository
public interface ProjectsRepository extends JpaRepository<Projects,Long> {
    List<Projects> findAllByNominated(boolean b);
    List<Projects> findAllByCoach(String coach);
    List<Projects> findAllByCategoryId(Long category);
    List<Projects> findAllByOptionSpeciality(Option option);
    List<Projects> findAllByNiveau(TypeNiveau niveau);

    List<Projects> findAllByWinnerAndAndScolarYear(boolean b,String scolarYear);
    List<Projects> findAllByWinner(boolean b);
    List<Projects> findGroupByGroupStreakGreaterThanOrderByGroupStreak(Integer streakValue);
    List<Projects> findAllByNiveauAndOptionSpeciality(TypeNiveau niveau, Option idOption);
}
