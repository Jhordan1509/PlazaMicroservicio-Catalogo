package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.CategoriaProductoEntity;
import pe.com.megacentimetros.catalogo.repository.CategoriaProductoRepository;
import pe.com.megacentimetros.catalogo.service.CategoriaProductoService;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

	private final CategoriaProductoRepository repositorio;

	public CategoriaProductoServiceImpl(CategoriaProductoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<CategoriaProductoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<CategoriaProductoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public CategoriaProductoEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public CategoriaProductoEntity add(CategoriaProductoEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public CategoriaProductoEntity update(CategoriaProductoEntity obj, Long id) {
		CategoriaProductoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public CategoriaProductoEntity delete(Long id) {
		CategoriaProductoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public CategoriaProductoEntity enable(Long id) {
		CategoriaProductoEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
