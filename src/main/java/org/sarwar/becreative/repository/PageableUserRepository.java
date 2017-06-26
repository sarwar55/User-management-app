package org.sarwar.becreative.repository;

import java.util.UUID;

import org.sarwar.becreative.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageableUserRepository extends 
		PagingAndSortingRepository<User, UUID> {
	Page<User> findByUserId(UUID userId, Pageable page);
}
