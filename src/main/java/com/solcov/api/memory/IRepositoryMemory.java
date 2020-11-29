package com.solcov.api.memory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryMemory extends JpaRepository<Memory, Long> {
}
