package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.TipoComprobanteEntity;

public interface TipoComprobanteRepository extends JpaRepository<TipoComprobanteEntity, Long> {

	@Query("select d from TipoComprobanteEntity d where d.estado = true")
	List<TipoComprobanteEntity> findAllCustom();
}
