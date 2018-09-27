package com.SennikovTestProject.DemoProject.Repository;

import com.SennikovTestProject.DemoProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRep extends JpaRepository<User,Long> {
    List<User> findBySecondName(String name);
}
