package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.EstadoEvaluacionEntity;

public interface EstadoEvaluacionRepository extends JpaRepository<EstadoEvaluacionEntity, Long> {

	@Query("select d from EstadoEvaluacionEntity d where d.estado = true")
	List<EstadoEvaluacionEntity> findAllCustom();
}
