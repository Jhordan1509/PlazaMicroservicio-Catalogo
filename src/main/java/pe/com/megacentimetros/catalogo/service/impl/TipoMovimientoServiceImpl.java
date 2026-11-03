package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.TipoMovimientoEntity;
import pe.com.megacentimetros.catalogo.repository.TipoMovimientoRepository;
import pe.com.megacentimetros.catalogo.service.TipoMovimientoService;

@Service
public class TipoMovimientoServiceImpl implements TipoMovimientoService {

	private final TipoMovimientoRepository repositorio;

	public TipoMovimientoServiceImpl(TipoMovimientoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoMovimientoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoMovimientoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoMovimientoEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public TipoMovimientoEntity add(TipoMovimientoEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public TipoMovimientoEntity update(TipoMovimientoEntity obj, Long id) {
		TipoMovimientoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoMovimientoEntity delete(Long id) {
		TipoMovimientoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoMovimientoEntity enable(Long id) {
		TipoMovimientoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
