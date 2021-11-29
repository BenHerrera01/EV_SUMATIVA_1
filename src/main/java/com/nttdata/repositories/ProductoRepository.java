package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{
	List<Producto> findAll();
	
	@Query("SELECT p FROM Producto p JOIN p.categorias c where c.nombre LIKE CONCAT('%',?1,'%')")
	List<Producto> findByCategory(String categoria);
	
	@Query("SELECT p FROM Producto p where p.marca LIKE CONCAT('%',?1,'%') or p.nombre LIKE CONCAT('%',?1,'%') or p.descripcion LIKE CONCAT('%',?1,'%')")
	List<Producto> findByKeyword(String palabra);
	
	@Query("SELECT p FROM Producto p JOIN p.categorias c where c.nombre=?1")
	List<Producto> findByDynamicCategory(String nombreCategoria);
}
