package ua.ithillel.hw25_9.springlombokmigration.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import ua.ithillel.hw25_9.springlombokmigration.persistence.Order;

@Repository
public interface OrderRepository extends ListCrudRepository<Order, Long> {	
}