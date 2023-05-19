package pe.com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.example.model.Auto;
import pe.com.example.repository.AutoRepository;

@Service
public class AutoServiceImpl implements AutoService {

	private AutoRepository autoRepository;

	@Autowired
	public AutoServiceImpl(AutoRepository autoRepository) {
		this.autoRepository = autoRepository;
	}

	// Método para crear autos
	@Override
	public void crearAutos(Auto auto) {
		autoRepository.save(auto);
	}

	// Método para actualizar un auto
	@Override
	public void actualizarAuto(Auto auto) {
		autoRepository.saveAndFlush(auto);
	}

	// Método para eliminar un auto
	@Override
	public void eliminarAuto(Long id) {
		autoRepository.deleteById(id);
	}

	// Método para listar todos los autos
	@Override
	public List<Auto> listarAutos() {
		return autoRepository.findAll();
	}

	// Método para buscar un auto por id especifico
	@Override
	public Auto buscarPorId(Long id) {
		return autoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Auto> buscarPorMarca(String marca) {
		// TODO Auto-generated method stub
		return autoRepository.findByMarca(marca);
	}

	@Override
	public List<Auto> buscarPorColor(String color) {
		// TODO Auto-generated method stub
		return autoRepository.findByColor(color);
	}

	@Override
	public List<Auto> buscarPorModelo(String modelo) {
		// TODO Auto-generated method stub
		return autoRepository.findByModelo(modelo);
	}

	@Override
	public List<Auto> buscarPorAnio(int anio) {
		// TODO Auto-generated method stub
		return autoRepository.findByAnio(anio);
	}

}
