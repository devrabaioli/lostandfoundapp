package devrabaioli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devrabaioli.domain.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
