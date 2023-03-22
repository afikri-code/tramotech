package de.afikri.rest.quickdemo.repository;

import de.afikri.rest.quickdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
