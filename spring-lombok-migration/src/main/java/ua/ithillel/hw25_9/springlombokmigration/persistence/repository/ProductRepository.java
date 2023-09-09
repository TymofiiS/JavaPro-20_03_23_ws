package ua.ithillel.hw25_9.springlombokmigration.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import ua.ithillel.hw25_9.springlombokmigration.persistence.Product;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Long> {	
}
