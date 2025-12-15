package com.example.web_app.repository;

import com.example.web_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface UserRepository extends JpaRepository<User, Integer> {
}
