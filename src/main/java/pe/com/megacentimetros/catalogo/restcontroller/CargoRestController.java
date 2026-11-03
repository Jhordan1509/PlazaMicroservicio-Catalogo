package pe.com.megacentimetros.catalogo.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.catalogo.entity.CargoEntity;
import pe.com.megacentimetros.catalogo.service.CargoService;

@RestController
@RequestMapping("/api/cargo")
public class CargoRestController {

	@Autowired
	private CargoService servicio;

	@GetMapping
	public List<CargoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<CargoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public CargoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public CargoEntity add(@RequestBody CargoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public CargoEntity update(@RequestBody CargoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public CargoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public CargoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
