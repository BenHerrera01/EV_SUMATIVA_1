package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	
	List<Role> findAll();
	
	List<Role> findByNombre(String nombre);
	
	@Query("SELECT r FROM Role r JOIN r.usuarios u where u.email=?1")
	List<Role> findByEmail(String email);
}
