package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.TipoMovimientoEntity;

public interface TipoMovimientoRepository extends JpaRepository<TipoMovimientoEntity, Long> {

	@Query("select d from TipoMovimientoEntity d where d.estado = true")
	List<TipoMovimientoEntity> findAllCustom();
}
