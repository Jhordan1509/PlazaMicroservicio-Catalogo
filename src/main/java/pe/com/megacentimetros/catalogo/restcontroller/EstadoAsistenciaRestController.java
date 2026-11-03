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
import pe.com.megacentimetros.catalogo.entity.EstadoAsistenciaEntity;
import pe.com.megacentimetros.catalogo.service.EstadoAsistenciaService;

@RestController
@RequestMapping("/api/estadoasistencia")
public class EstadoAsistenciaRestController {

	@Autowired
	private EstadoAsistenciaService servicio;

	@GetMapping
	public List<EstadoAsistenciaEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<EstadoAsistenciaEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public EstadoAsistenciaEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public EstadoAsistenciaEntity add(@RequestBody EstadoAsistenciaEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public EstadoAsistenciaEntity update(@RequestBody EstadoAsistenciaEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public EstadoAsistenciaEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public EstadoAsistenciaEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
