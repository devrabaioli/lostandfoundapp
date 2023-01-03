package devrabaioli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devrabaioli.domain.Found;

@Repository
public interface FoundRepository extends JpaRepository<Found, Integer> {

}
