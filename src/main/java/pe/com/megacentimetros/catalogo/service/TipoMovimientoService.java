package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.TipoMovimientoEntity;

public interface TipoMovimientoService {

	List<TipoMovimientoEntity> findAll();

	List<TipoMovimientoEntity> findAllCustom();

	TipoMovimientoEntity findById(Long id);

	TipoMovimientoEntity add(TipoMovimientoEntity obj);

	TipoMovimientoEntity update(TipoMovimientoEntity obj, Long id);

	TipoMovimientoEntity delete(Long id);

	TipoMovimientoEntity enable(Long id);
}
