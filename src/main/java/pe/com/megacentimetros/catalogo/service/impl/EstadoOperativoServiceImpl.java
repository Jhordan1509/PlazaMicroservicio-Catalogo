package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.EstadoOperativoEntity;
import pe.com.megacentimetros.catalogo.repository.EstadoOperativoRepository;
import pe.com.megacentimetros.catalogo.service.EstadoOperativoService;

@Service
public class EstadoOperativoServiceImpl implements EstadoOperativoService {

	private final EstadoOperativoRepository repositorio;

	public EstadoOperativoServiceImpl(EstadoOperativoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<EstadoOperativoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<EstadoOperativoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public EstadoOperativoEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public EstadoOperativoEntity add(EstadoOperativoEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public EstadoOperativoEntity update(EstadoOperativoEntity obj, Long id) {
		EstadoOperativoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public EstadoOperativoEntity delete(Long id) {
		EstadoOperativoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public EstadoOperativoEntity enable(Long id) {
		EstadoOperativoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
