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
import pe.com.megacentimetros.catalogo.entity.TipoAlmacenEntity;
import pe.com.megacentimetros.catalogo.service.TipoAlmacenService;

@RestController
@RequestMapping("/api/tipoalmacen")
public class TipoAlmacenRestController {

	@Autowired
	private TipoAlmacenService servicio;

	@GetMapping
	public List<TipoAlmacenEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<TipoAlmacenEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public TipoAlmacenEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public TipoAlmacenEntity add(@RequestBody TipoAlmacenEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public TipoAlmacenEntity update(@RequestBody TipoAlmacenEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public TipoAlmacenEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public TipoAlmacenEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
