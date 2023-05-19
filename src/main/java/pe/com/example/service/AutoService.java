package pe.com.example.service;

import java.util.List;

import pe.com.example.model.Auto;

public interface AutoService {
	
	void crearAutos(Auto auto);
	void actualizarAuto(Auto auto);
	void eliminarAuto(Long id);
	List<Auto> listarAutos();
	Auto buscarPorId(Long id);
	
	List<Auto> buscarPorMarca(String marca);
	List<Auto> buscarPorColor(String color);
	List<Auto> buscarPorModelo(String modelo);
	List<Auto> buscarPorAnio(int anio);
		
}
