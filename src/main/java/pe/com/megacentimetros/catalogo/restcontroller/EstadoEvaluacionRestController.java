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
import pe.com.megacentimetros.catalogo.entity.EstadoEvaluacionEntity;
import pe.com.megacentimetros.catalogo.service.EstadoEvaluacionService;

@RestController
@RequestMapping("/api/estadoevaluacion")
public class EstadoEvaluacionRestController {

	@Autowired
	private EstadoEvaluacionService servicio;

	@GetMapping
	public List<EstadoEvaluacionEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<EstadoEvaluacionEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public EstadoEvaluacionEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public EstadoEvaluacionEntity add(@RequestBody EstadoEvaluacionEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public EstadoEvaluacionEntity update(@RequestBody EstadoEvaluacionEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public EstadoEvaluacionEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public EstadoEvaluacionEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
