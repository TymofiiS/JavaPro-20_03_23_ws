package ua.ithillel.hw25_4.SpringStart.repository;

import java.util.List;

public interface CrudRepository<T> {
	
	List<T> findAll();
}
