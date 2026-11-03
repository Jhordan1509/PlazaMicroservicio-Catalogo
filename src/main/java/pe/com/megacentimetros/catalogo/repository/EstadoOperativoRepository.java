package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.EstadoOperativoEntity;

public interface EstadoOperativoRepository extends JpaRepository<EstadoOperativoEntity, Long> {

	@Query("select d from EstadoOperativoEntity d where d.estado = true")
	List<EstadoOperativoEntity> findAllCustom();
}
