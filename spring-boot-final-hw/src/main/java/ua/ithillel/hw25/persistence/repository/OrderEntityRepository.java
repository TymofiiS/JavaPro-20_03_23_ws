package ua.ithillel.hw25.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import ua.ithillel.hw25.persistence.OrderEntity;

@Repository
public interface OrderEntityRepository 
	extends ListCrudRepository<OrderEntity, Long> {
	
		
}
