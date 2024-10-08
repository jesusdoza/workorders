package org.company.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<User, UUID> {

    Optional<User> findByAuthServerId(String authServerId);
}
