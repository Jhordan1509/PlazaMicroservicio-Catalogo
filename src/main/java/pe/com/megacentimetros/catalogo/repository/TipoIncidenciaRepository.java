package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.TipoIncidenciaEntity;

public interface TipoIncidenciaRepository extends JpaRepository<TipoIncidenciaEntity, Long> {

	@Query("select d from TipoIncidenciaEntity d where d.estado = true")
	List<TipoIncidenciaEntity> findAllCustom();
}
