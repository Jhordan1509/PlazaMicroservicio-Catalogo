package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.EstadoTransporteEntity;
import pe.com.megacentimetros.catalogo.repository.EstadoTransporteRepository;
import pe.com.megacentimetros.catalogo.service.EstadoTransporteService;

@Service
public class EstadoTransporteServiceImpl implements EstadoTransporteService {

	private final EstadoTransporteRepository repositorio;

	public EstadoTransporteServiceImpl(EstadoTransporteRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<EstadoTransporteEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<EstadoTransporteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public EstadoTransporteEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public EstadoTransporteEntity add(EstadoTransporteEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public EstadoTransporteEntity update(EstadoTransporteEntity obj, Long id) {
		EstadoTransporteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public EstadoTransporteEntity delete(Long id) {
		EstadoTransporteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public EstadoTransporteEntity enable(Long id) {
		EstadoTransporteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
