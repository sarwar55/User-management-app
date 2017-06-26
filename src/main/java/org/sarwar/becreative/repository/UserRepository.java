package org.sarwar.becreative.repository;

import java.util.Optional;
import java.util.UUID;

import org.sarwar.becreative.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UUID> {
	Optional<User> findByUserId(UUID userId);
}
