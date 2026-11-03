package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.UnidadMedidaEntity;

public interface UnidadMedidaRepository extends JpaRepository<UnidadMedidaEntity, Long> {

	@Query("select d from UnidadMedidaEntity d where d.estado = true")
	List<UnidadMedidaEntity> findAllCustom();
}
