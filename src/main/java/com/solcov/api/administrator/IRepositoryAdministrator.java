package com.solcov.api.administrator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryAdministrator extends JpaRepository<Administrator, Long> {

    List<Administrator> findByUsername(String username);

}
