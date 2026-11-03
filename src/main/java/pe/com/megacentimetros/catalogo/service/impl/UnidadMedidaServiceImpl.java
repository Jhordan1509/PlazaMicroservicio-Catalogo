package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.UnidadMedidaEntity;
import pe.com.megacentimetros.catalogo.repository.UnidadMedidaRepository;
import pe.com.megacentimetros.catalogo.service.UnidadMedidaService;

@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService {

	private final UnidadMedidaRepository repositorio;

	public UnidadMedidaServiceImpl(UnidadMedidaRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<UnidadMedidaEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<UnidadMedidaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public UnidadMedidaEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public UnidadMedidaEntity add(UnidadMedidaEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public UnidadMedidaEntity update(UnidadMedidaEntity obj, Long id) {
		UnidadMedidaEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			BeanUtils.copyProperties(obj, actual, "codigo", "estado", "fechaCreacion", "usuarioCreacion", "fechaActualizacion");
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public UnidadMedidaEntity delete(Long id) {
		UnidadMedidaEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(false);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}

	@Override
	public UnidadMedidaEntity enable(Long id) {
		UnidadMedidaEntity actual = repositorio.findById(id).orElse(null);
		if (actual != null) {
			actual.setEstado(true);
			actual.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(actual);
		}
		return null;
	}
}
