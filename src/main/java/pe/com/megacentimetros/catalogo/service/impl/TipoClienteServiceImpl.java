package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.TipoClienteEntity;
import pe.com.megacentimetros.catalogo.repository.TipoClienteRepository;
import pe.com.megacentimetros.catalogo.service.TipoClienteService;

@Service
public class TipoClienteServiceImpl implements TipoClienteService {

	private final TipoClienteRepository repositorio;

	public TipoClienteServiceImpl(TipoClienteRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoClienteEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoClienteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoClienteEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public TipoClienteEntity add(TipoClienteEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public TipoClienteEntity update(TipoClienteEntity obj, Long id) {
		TipoClienteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoClienteEntity delete(Long id) {
		TipoClienteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoClienteEntity enable(Long id) {
		TipoClienteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
