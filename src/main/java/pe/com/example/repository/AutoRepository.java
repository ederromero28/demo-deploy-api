package pe.com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.example.model.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
	List<Auto> findByMarca(String marca);
	List<Auto> findByColor(String color);
	List<Auto> findByModelo(String modelo);
	List<Auto> findByAnio(int anio);
}
