package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.TipoTransporteEntity;

public interface TipoTransporteRepository extends JpaRepository<TipoTransporteEntity, Long> {

	@Query("select d from TipoTransporteEntity d where d.estado = true")
	List<TipoTransporteEntity> findAllCustom();
}
