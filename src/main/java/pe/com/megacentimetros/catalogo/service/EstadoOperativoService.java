package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.EstadoOperativoEntity;

public interface EstadoOperativoService {

	List<EstadoOperativoEntity> findAll();

	List<EstadoOperativoEntity> findAllCustom();

	EstadoOperativoEntity findById(Long id);

	EstadoOperativoEntity add(EstadoOperativoEntity obj);

	EstadoOperativoEntity update(EstadoOperativoEntity obj, Long id);

	EstadoOperativoEntity delete(Long id);

	EstadoOperativoEntity enable(Long id);
}
