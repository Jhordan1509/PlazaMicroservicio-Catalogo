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
import pe.com.megacentimetros.catalogo.entity.UnidadMedidaEntity;
import pe.com.megacentimetros.catalogo.service.UnidadMedidaService;

@RestController
@RequestMapping("/api/unidadmedida")
public class UnidadMedidaRestController {

	@Autowired
	private UnidadMedidaService servicio;

	@GetMapping
	public List<UnidadMedidaEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<UnidadMedidaEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public UnidadMedidaEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public UnidadMedidaEntity add(@RequestBody UnidadMedidaEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public UnidadMedidaEntity update(@RequestBody UnidadMedidaEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public UnidadMedidaEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public UnidadMedidaEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
