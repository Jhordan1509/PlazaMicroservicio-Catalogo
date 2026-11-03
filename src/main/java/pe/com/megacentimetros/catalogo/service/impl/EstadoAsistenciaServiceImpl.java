package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.EstadoAsistenciaEntity;
import pe.com.megacentimetros.catalogo.repository.EstadoAsistenciaRepository;
import pe.com.megacentimetros.catalogo.service.EstadoAsistenciaService;

@Service
public class EstadoAsistenciaServiceImpl implements EstadoAsistenciaService {

	private final EstadoAsistenciaRepository repositorio;

	public EstadoAsistenciaServiceImpl(EstadoAsistenciaRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<EstadoAsistenciaEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<EstadoAsistenciaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public EstadoAsistenciaEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public EstadoAsistenciaEntity add(EstadoAsistenciaEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public EstadoAsistenciaEntity update(EstadoAsistenciaEntity obj, Long id) {
		EstadoAsistenciaEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public EstadoAsistenciaEntity delete(Long id) {
		EstadoAsistenciaEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public EstadoAsistenciaEntity enable(Long id) {
		EstadoAsistenciaEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
