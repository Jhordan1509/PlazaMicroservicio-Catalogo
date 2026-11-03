package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.TipoTransporteEntity;
import pe.com.megacentimetros.catalogo.repository.TipoTransporteRepository;
import pe.com.megacentimetros.catalogo.service.TipoTransporteService;

@Service
public class TipoTransporteServiceImpl implements TipoTransporteService {

	private final TipoTransporteRepository repositorio;

	public TipoTransporteServiceImpl(TipoTransporteRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoTransporteEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoTransporteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoTransporteEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public TipoTransporteEntity add(TipoTransporteEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public TipoTransporteEntity update(TipoTransporteEntity obj, Long id) {
		TipoTransporteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoTransporteEntity delete(Long id) {
		TipoTransporteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoTransporteEntity enable(Long id) {
		TipoTransporteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
