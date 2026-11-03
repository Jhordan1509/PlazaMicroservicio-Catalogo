package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.catalogo.entity.DistritoEntity;
import pe.com.megacentimetros.catalogo.repository.DistritoRepository;
import pe.com.megacentimetros.catalogo.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService {
	
	private final DistritoRepository repositorio;

	public DistritoServiceImpl(DistritoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<DistritoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<DistritoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public DistritoEntity findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public DistritoEntity add(DistritoEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}

	@Override
	public DistritoEntity update(DistritoEntity obj, Long id) {
		DistritoEntity objdis = repositorio.findById(id).orElse(null);
		if (objdis != null) {
			BeanUtils.copyProperties(obj, objdis, "codigo", "fechaCreacion", "usuarioCreacion");
			objdis.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(objdis);
		}
		return null;
	}

	@Override
	public DistritoEntity delete(Long id) {
		DistritoEntity objdis = repositorio.findById(id).orElse(null);
		if (objdis != null) {
			objdis.setEstado(false);
			objdis.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(objdis);
		}
		return null;
	}

	@Override
	public DistritoEntity enable(Long id) {
		DistritoEntity objdis = repositorio.findById(id).orElse(null);
		if (objdis != null) {
			objdis.setEstado(true);
			objdis.setFechaActualizacion(LocalDateTime.now());
			return repositorio.save(objdis);
		}
		return null;
	}
}