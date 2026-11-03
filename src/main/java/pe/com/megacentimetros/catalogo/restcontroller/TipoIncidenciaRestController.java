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
import pe.com.megacentimetros.catalogo.entity.TipoIncidenciaEntity;
import pe.com.megacentimetros.catalogo.service.TipoIncidenciaService;

@RestController
@RequestMapping("/api/tipoincidencia")
public class TipoIncidenciaRestController {

	@Autowired
	private TipoIncidenciaService servicio;

	@GetMapping
	public List<TipoIncidenciaEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<TipoIncidenciaEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public TipoIncidenciaEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public TipoIncidenciaEntity add(@RequestBody TipoIncidenciaEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public TipoIncidenciaEntity update(@RequestBody TipoIncidenciaEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public TipoIncidenciaEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public TipoIncidenciaEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
