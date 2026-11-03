package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.TipoAlmacenEntity;

public interface TipoAlmacenRepository extends JpaRepository<TipoAlmacenEntity, Long> {

	@Query("select d from TipoAlmacenEntity d where d.estado = true")
	List<TipoAlmacenEntity> findAllCustom();
}
