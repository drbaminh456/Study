package com.example.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.Users;

public interface UserDao extends CrudRepository<Users, Integer> {
	@Query("FROM Users a WHERE a.id = :id")
	public Users getBy(@Param("id") int id);

	@Query("FROM Users a WHERE a.userName = :userName AND a.status = 'ACT' AND a.isDeleted = FALSE")
	public Users getBy(@Param("userName") String userName);
}