package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.TipoAlmacenEntity;
import pe.com.megacentimetros.catalogo.repository.TipoAlmacenRepository;
import pe.com.megacentimetros.catalogo.service.TipoAlmacenService;

@Service
public class TipoAlmacenServiceImpl implements TipoAlmacenService {

	private final TipoAlmacenRepository repositorio;

	public TipoAlmacenServiceImpl(TipoAlmacenRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoAlmacenEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoAlmacenEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoAlmacenEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public TipoAlmacenEntity add(TipoAlmacenEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public TipoAlmacenEntity update(TipoAlmacenEntity obj, Long id) {
		TipoAlmacenEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoAlmacenEntity delete(Long id) {
		TipoAlmacenEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoAlmacenEntity enable(Long id) {
		TipoAlmacenEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
