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
import pe.com.megacentimetros.catalogo.entity.TipoComprobanteEntity;
import pe.com.megacentimetros.catalogo.service.TipoComprobanteService;

@RestController
@RequestMapping("/api/tipocomprobante")
public class TipoComprobanteRestController {

	@Autowired
	private TipoComprobanteService servicio;

	@GetMapping
	public List<TipoComprobanteEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<TipoComprobanteEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public TipoComprobanteEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public TipoComprobanteEntity add(@RequestBody TipoComprobanteEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public TipoComprobanteEntity update(@RequestBody TipoComprobanteEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public TipoComprobanteEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public TipoComprobanteEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
