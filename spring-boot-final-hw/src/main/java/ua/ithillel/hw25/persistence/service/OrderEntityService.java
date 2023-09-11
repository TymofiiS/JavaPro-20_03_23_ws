package ua.ithillel.hw25.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.ithillel.hw25.persistence.OrderEntity;
import ua.ithillel.hw25.persistence.repository.OrderEntityRepository;

@Service
@Transactional
public class OrderEntityService {
	
	@Autowired
	private OrderEntityRepository orderEntityRepository;
	
	public OrderEntity save(OrderEntity orderEntity) {
		return orderEntityRepository.save(orderEntity);
	}

	public void delete(OrderEntity order1) {
		orderEntityRepository.delete(order1);
		
	}

	public boolean existsById(Long id) {
		return orderEntityRepository.existsById(id);
	}

	public List<OrderEntity> findAll() {
		return orderEntityRepository.findAll();
	}

	public Optional<OrderEntity> getById(Long orderId) {
		return orderEntityRepository.findById(orderId);
	}
}
