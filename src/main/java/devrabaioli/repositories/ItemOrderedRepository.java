package devrabaioli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devrabaioli.domain.ItemOrdered;

@Repository
public interface ItemOrderedRepository extends JpaRepository<ItemOrdered, Integer> {

}
