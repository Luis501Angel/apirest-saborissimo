package com.solcov.api.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryMenu extends JpaRepository<Menu, Long> {

    @Query(value = "SELECT entrances FROM tb_menu", nativeQuery = true)
    public List<Long> findMenu_entrances();

}
