package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.TipoComprobanteEntity;

public interface TipoComprobanteService {

	List<TipoComprobanteEntity> findAll();

	List<TipoComprobanteEntity> findAllCustom();

	TipoComprobanteEntity findById(Long id);

	TipoComprobanteEntity add(TipoComprobanteEntity obj);

	TipoComprobanteEntity update(TipoComprobanteEntity obj, Long id);

	TipoComprobanteEntity delete(Long id);

	TipoComprobanteEntity enable(Long id);
}
