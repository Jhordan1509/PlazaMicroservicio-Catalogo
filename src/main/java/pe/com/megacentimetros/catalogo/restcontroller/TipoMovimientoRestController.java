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
import pe.com.megacentimetros.catalogo.entity.TipoMovimientoEntity;
import pe.com.megacentimetros.catalogo.service.TipoMovimientoService;

@RestController
@RequestMapping("/api/tipomovimiento")
public class TipoMovimientoRestController {

	@Autowired
	private TipoMovimientoService servicio;

	@GetMapping
	public List<TipoMovimientoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<TipoMovimientoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public TipoMovimientoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public TipoMovimientoEntity add(@RequestBody TipoMovimientoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public TipoMovimientoEntity update(@RequestBody TipoMovimientoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public TipoMovimientoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public TipoMovimientoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
