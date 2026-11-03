package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.TipoEmpaqueEntity;
import pe.com.megacentimetros.catalogo.repository.TipoEmpaqueRepository;
import pe.com.megacentimetros.catalogo.service.TipoEmpaqueService;

@Service
public class TipoEmpaqueServiceImpl implements TipoEmpaqueService {

	private final TipoEmpaqueRepository repositorio;

	public TipoEmpaqueServiceImpl(TipoEmpaqueRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoEmpaqueEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoEmpaqueEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoEmpaqueEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public TipoEmpaqueEntity add(TipoEmpaqueEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public TipoEmpaqueEntity update(TipoEmpaqueEntity obj, Long id) {
		TipoEmpaqueEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoEmpaqueEntity delete(Long id) {
		TipoEmpaqueEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoEmpaqueEntity enable(Long id) {
		TipoEmpaqueEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
