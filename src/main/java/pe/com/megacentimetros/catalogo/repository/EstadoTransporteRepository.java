package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.EstadoTransporteEntity;

public interface EstadoTransporteRepository extends JpaRepository<EstadoTransporteEntity, Long> {

	@Query("select d from EstadoTransporteEntity d where d.estado = true")
	List<EstadoTransporteEntity> findAllCustom();
}
