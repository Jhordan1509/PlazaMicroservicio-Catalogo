package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.TipoEmpleadoEntity;

public interface TipoEmpleadoRepository extends JpaRepository<TipoEmpleadoEntity, Long> {

	@Query("select d from TipoEmpleadoEntity d where d.estado = true")
	List<TipoEmpleadoEntity> findAllCustom();
}
