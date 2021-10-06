package com.hph.rise.repository;

import com.hph.rise.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> { }