package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.EstadoEvaluacionEntity;
import pe.com.megacentimetros.catalogo.repository.EstadoEvaluacionRepository;
import pe.com.megacentimetros.catalogo.service.EstadoEvaluacionService;

@Service
public class EstadoEvaluacionServiceImpl implements EstadoEvaluacionService {

	private final EstadoEvaluacionRepository repositorio;

	public EstadoEvaluacionServiceImpl(EstadoEvaluacionRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<EstadoEvaluacionEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<EstadoEvaluacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public EstadoEvaluacionEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public EstadoEvaluacionEntity add(EstadoEvaluacionEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public EstadoEvaluacionEntity update(EstadoEvaluacionEntity obj, Long id) {
		EstadoEvaluacionEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public EstadoEvaluacionEntity delete(Long id) {
		EstadoEvaluacionEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public EstadoEvaluacionEntity enable(Long id) {
		EstadoEvaluacionEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
