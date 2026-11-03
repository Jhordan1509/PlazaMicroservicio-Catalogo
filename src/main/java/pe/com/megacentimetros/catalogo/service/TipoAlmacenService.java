package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.TipoAlmacenEntity;

public interface TipoAlmacenService {

	List<TipoAlmacenEntity> findAll();

	List<TipoAlmacenEntity> findAllCustom();

	TipoAlmacenEntity findById(Long id);

	TipoAlmacenEntity add(TipoAlmacenEntity obj);

	TipoAlmacenEntity update(TipoAlmacenEntity obj, Long id);

	TipoAlmacenEntity delete(Long id);

	TipoAlmacenEntity enable(Long id);
}
