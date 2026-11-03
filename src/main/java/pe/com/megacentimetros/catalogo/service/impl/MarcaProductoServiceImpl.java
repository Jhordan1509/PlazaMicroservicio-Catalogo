package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.MarcaProductoEntity;
import pe.com.megacentimetros.catalogo.repository.MarcaProductoRepository;
import pe.com.megacentimetros.catalogo.service.MarcaProductoService;

@Service
public class MarcaProductoServiceImpl implements MarcaProductoService {

	private final MarcaProductoRepository repositorio;

	public MarcaProductoServiceImpl(MarcaProductoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<MarcaProductoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<MarcaProductoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public MarcaProductoEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public MarcaProductoEntity add(MarcaProductoEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public MarcaProductoEntity update(MarcaProductoEntity obj, Long id) {
		MarcaProductoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public MarcaProductoEntity delete(Long id) {
		MarcaProductoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public MarcaProductoEntity enable(Long id) {
		MarcaProductoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
