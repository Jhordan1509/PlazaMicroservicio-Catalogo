package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.SexoEntity;
import pe.com.megacentimetros.catalogo.repository.SexoRepository;
import pe.com.megacentimetros.catalogo.service.SexoService;

@Service
public class SexoServiceImpl implements SexoService {
	
	private final SexoRepository repositorio;

	public SexoServiceImpl(SexoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<SexoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<SexoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public SexoEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public SexoEntity add(SexoEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public SexoEntity update(SexoEntity obj, Long id) {
		SexoEntity objdis = repositorio.findById(id).orElse(null);
		if (objdis != null) {
			BeanUtils.copyProperties(obj, objdis, "codigo", "fechaCreacion", "usuarioCreacion");
			objdis.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(objdis);
		}
		return null;
	}

	@Override
	public SexoEntity delete(Long id) {
		SexoEntity objdis = repositorio.findById(id).orElse(null);
		if (objdis != null) {
			objdis.setEstado(false);
			objdis.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(objdis);
		}
		return null;
	}

	@Override
	public SexoEntity enable(Long id) {
		SexoEntity objdis = repositorio.findById(id).orElse(null);
		if (objdis != null) {
			objdis.setEstado(true);
			objdis.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(objdis);
		}
		return null;
	}
}