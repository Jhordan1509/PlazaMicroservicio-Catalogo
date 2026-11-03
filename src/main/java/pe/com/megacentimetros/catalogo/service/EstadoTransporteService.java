package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.EstadoTransporteEntity;

public interface EstadoTransporteService {

	List<EstadoTransporteEntity> findAll();

	List<EstadoTransporteEntity> findAllCustom();

	EstadoTransporteEntity findById(Long id);

	EstadoTransporteEntity add(EstadoTransporteEntity obj);

	EstadoTransporteEntity update(EstadoTransporteEntity obj, Long id);

	EstadoTransporteEntity delete(Long id);

	EstadoTransporteEntity enable(Long id);
}
