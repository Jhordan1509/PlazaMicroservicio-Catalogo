package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.EstadoAsistenciaEntity;

public interface EstadoAsistenciaService {

	List<EstadoAsistenciaEntity> findAll();

	List<EstadoAsistenciaEntity> findAllCustom();

	EstadoAsistenciaEntity findById(Long id);

	EstadoAsistenciaEntity add(EstadoAsistenciaEntity obj);

	EstadoAsistenciaEntity update(EstadoAsistenciaEntity obj, Long id);

	EstadoAsistenciaEntity delete(Long id);

	EstadoAsistenciaEntity enable(Long id);
}
