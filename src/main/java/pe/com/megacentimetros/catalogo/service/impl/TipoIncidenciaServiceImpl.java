package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.TipoIncidenciaEntity;
import pe.com.megacentimetros.catalogo.repository.TipoIncidenciaRepository;
import pe.com.megacentimetros.catalogo.service.TipoIncidenciaService;

@Service
public class TipoIncidenciaServiceImpl implements TipoIncidenciaService {

	private final TipoIncidenciaRepository repositorio;

	public TipoIncidenciaServiceImpl(TipoIncidenciaRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoIncidenciaEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoIncidenciaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoIncidenciaEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public TipoIncidenciaEntity add(TipoIncidenciaEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public TipoIncidenciaEntity update(TipoIncidenciaEntity obj, Long id) {
		TipoIncidenciaEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoIncidenciaEntity delete(Long id) {
		TipoIncidenciaEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoIncidenciaEntity enable(Long id) {
		TipoIncidenciaEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
