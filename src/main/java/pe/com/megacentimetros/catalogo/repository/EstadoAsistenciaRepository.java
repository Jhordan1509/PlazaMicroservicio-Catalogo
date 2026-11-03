package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.EstadoAsistenciaEntity;

public interface EstadoAsistenciaRepository extends JpaRepository<EstadoAsistenciaEntity, Long> {

	@Query("select d from EstadoAsistenciaEntity d where d.estado = true")
	List<EstadoAsistenciaEntity> findAllCustom();
}
