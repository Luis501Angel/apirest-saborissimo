package com.solcov.api.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryOrder extends JpaRepository<Order, Long> {
}
