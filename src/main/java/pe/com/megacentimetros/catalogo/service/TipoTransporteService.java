package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.TipoTransporteEntity;

public interface TipoTransporteService {

	List<TipoTransporteEntity> findAll();

	List<TipoTransporteEntity> findAllCustom();

	TipoTransporteEntity findById(Long id);

	TipoTransporteEntity add(TipoTransporteEntity obj);

	TipoTransporteEntity update(TipoTransporteEntity obj, Long id);

	TipoTransporteEntity delete(Long id);

	TipoTransporteEntity enable(Long id);
}
