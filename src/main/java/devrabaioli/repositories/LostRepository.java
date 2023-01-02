package devrabaioli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devrabaioli.domain.Lost;

@Repository
public interface LostRepository extends JpaRepository<Lost, Integer> {

}
