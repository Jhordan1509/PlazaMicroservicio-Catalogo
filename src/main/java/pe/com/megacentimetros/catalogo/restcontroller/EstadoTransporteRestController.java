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
import pe.com.megacentimetros.catalogo.entity.EstadoTransporteEntity;
import pe.com.megacentimetros.catalogo.service.EstadoTransporteService;

@RestController
@RequestMapping("/api/estadotransporte")
public class EstadoTransporteRestController {

	@Autowired
	private EstadoTransporteService servicio;

	@GetMapping
	public List<EstadoTransporteEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<EstadoTransporteEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public EstadoTransporteEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public EstadoTransporteEntity add(@RequestBody EstadoTransporteEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public EstadoTransporteEntity update(@RequestBody EstadoTransporteEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public EstadoTransporteEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public EstadoTransporteEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
