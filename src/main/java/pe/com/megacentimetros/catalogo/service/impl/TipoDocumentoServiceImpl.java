package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.TipoDocumentoEntity;
import pe.com.megacentimetros.catalogo.repository.TipoDocumentoRepository;
import pe.com.megacentimetros.catalogo.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	private final TipoDocumentoRepository repositorio;

	public TipoDocumentoServiceImpl(TipoDocumentoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoDocumentoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoDocumentoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoDocumentoEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public TipoDocumentoEntity add(TipoDocumentoEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public TipoDocumentoEntity update(TipoDocumentoEntity obj, Long id) {
		TipoDocumentoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoDocumentoEntity delete(Long id) {
		TipoDocumentoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public TipoDocumentoEntity enable(Long id) {
		TipoDocumentoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
