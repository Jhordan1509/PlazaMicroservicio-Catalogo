package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.EstadoEvaluacionEntity;

public interface EstadoEvaluacionService {

	List<EstadoEvaluacionEntity> findAll();

	List<EstadoEvaluacionEntity> findAllCustom();

	EstadoEvaluacionEntity findById(Long id);

	EstadoEvaluacionEntity add(EstadoEvaluacionEntity obj);

	EstadoEvaluacionEntity update(EstadoEvaluacionEntity obj, Long id);

	EstadoEvaluacionEntity delete(Long id);

	EstadoEvaluacionEntity enable(Long id);
}
