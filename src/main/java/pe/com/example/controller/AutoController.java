package pe.com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.example.model.Auto;
import pe.com.example.service.AutoService;

@RestController
@RequestMapping("/autos")
@CrossOrigin("*")
public class AutoController {

	private AutoService autoService;

	@Autowired
	public AutoController(AutoService autoService) {
		this.autoService = autoService;
	}

	@PostMapping(value = "/crear", headers = "Accept=application/json")
	public ResponseEntity<?> crearAuto(@RequestBody Auto auto) {

		HashMap<String, Object> json = new HashMap<>();
		json.put("mensaje", "Auto creado correctamente");
		autoService.crearAutos(auto);

		return new ResponseEntity<>(json, HttpStatus.OK);
	}

	@GetMapping(value = "/listar", headers = "Accept=application/json")
	public ResponseEntity<?> listar() {
		List<Auto> listar = autoService.listarAutos();
		return new ResponseEntity<>(listar, HttpStatus.OK);
	}

	@GetMapping(value = "/buscar_id/{idAuto}", headers = "Accept=application/json")
	public ResponseEntity<?> buscarxId(@PathVariable Long idAuto) {

		Auto autoDB = autoService.buscarPorId(idAuto);
		if (autoDB != null) {
			return new ResponseEntity<>(autoDB, HttpStatus.OK);
		}

		return new ResponseEntity<>("Auto no existe", HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/actualizar/{idAuto}", headers = "Accept=application/json")
	public ResponseEntity<?> actualizar(@RequestBody Auto autoNew, @PathVariable Long idAuto) {

		Auto autoDB = autoService.buscarPorId(idAuto);
		HashMap<String, Object> json = new HashMap<>();

		if (autoDB != null) {
			autoDB.setMarca(autoNew.getMarca());
			autoDB.setModelo(autoNew.getModelo());
			autoDB.setColor(autoNew.getColor());
			autoDB.setAnio(autoNew.getAnio());

			autoService.actualizarAuto(autoDB);
			json.put("mensaje", "Auto actualizado");
			return new ResponseEntity<>(json, HttpStatus.OK);
		}
		json.put("mensaje", "Auto no existe");
		return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/eliminar/{idAuto}", headers = "Accept=application/json")
	public ResponseEntity<?> eliminar(@PathVariable Long idAuto) {

		Auto autoDB = autoService.buscarPorId(idAuto);
		HashMap<String, Object> json = new HashMap<>();

		if (autoDB != null) {
			autoService.eliminarAuto(idAuto);
			json.put("mensaje", "Auto eliminado correctamente");
			return new ResponseEntity<>(json, HttpStatus.OK);
		}
		json.put("mensaje", "Auto no encontrado");
		return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/listarMarca/{marca}", headers = "Accept=application/json")
	public List<Auto> listarPorMarca(@PathVariable String marca) {
		return autoService.buscarPorMarca(marca);
	}

	@GetMapping(value = "/listarModelo/{modelo}", headers = "Accept=application/json")
	public List<Auto> listarPorModelo(@PathVariable String modelo) {
		return autoService.buscarPorModelo(modelo);
	}

	@GetMapping(value = "/listarPorColor/{color}", headers = "Accept=application/json")
	public List<Auto> listarPorColor(@PathVariable String color) {
		return autoService.buscarPorColor(color);
	}

	@GetMapping(value = "/listarPorAnio/{anio}", headers = "Accept=application/json")
	public List<Auto> listarPorAnio(@PathVariable int anio) {
		return autoService.buscarPorAnio(anio);
	}

}
