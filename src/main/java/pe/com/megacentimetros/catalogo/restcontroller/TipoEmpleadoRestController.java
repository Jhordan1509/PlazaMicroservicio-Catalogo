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
import pe.com.megacentimetros.catalogo.entity.TipoEmpleadoEntity;
import pe.com.megacentimetros.catalogo.service.TipoEmpleadoService;

@RestController
@RequestMapping("/api/tipoempleado")
public class TipoEmpleadoRestController {

	@Autowired
	private TipoEmpleadoService servicio;

	@GetMapping
	public List<TipoEmpleadoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<TipoEmpleadoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public TipoEmpleadoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public TipoEmpleadoEntity add(@RequestBody TipoEmpleadoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public TipoEmpleadoEntity update(@RequestBody TipoEmpleadoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public TipoEmpleadoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public TipoEmpleadoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
