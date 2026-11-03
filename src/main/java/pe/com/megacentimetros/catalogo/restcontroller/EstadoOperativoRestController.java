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
import pe.com.megacentimetros.catalogo.entity.EstadoOperativoEntity;
import pe.com.megacentimetros.catalogo.service.EstadoOperativoService;

@RestController
@RequestMapping("/api/estadooperativo")
public class EstadoOperativoRestController {

	@Autowired
	private EstadoOperativoService servicio;

	@GetMapping
	public List<EstadoOperativoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<EstadoOperativoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public EstadoOperativoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public EstadoOperativoEntity add(@RequestBody EstadoOperativoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public EstadoOperativoEntity update(@RequestBody EstadoOperativoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public EstadoOperativoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public EstadoOperativoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
