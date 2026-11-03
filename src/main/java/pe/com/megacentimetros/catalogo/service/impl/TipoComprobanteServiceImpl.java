package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.TipoComprobanteEntity;
import pe.com.megacentimetros.catalogo.repository.TipoComprobanteRepository;
import pe.com.megacentimetros.catalogo.service.TipoComprobanteService;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService {

	private final TipoComprobanteRepository repositorio;

	public TipoComprobanteServiceImpl(TipoComprobanteRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoComprobanteEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoComprobanteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoComprobanteEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public TipoComprobanteEntity add(TipoComprobanteEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public TipoComprobanteEntity update(TipoComprobanteEntity obj, Long id) {
		TipoComprobanteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoComprobanteEntity delete(Long id) {
		TipoComprobanteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoComprobanteEntity enable(Long id) {
		TipoComprobanteEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
