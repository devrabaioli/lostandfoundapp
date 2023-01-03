package devrabaioli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devrabaioli.domain.Ordered;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered, Integer> {

}
