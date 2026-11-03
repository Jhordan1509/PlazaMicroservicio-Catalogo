package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.CargoEntity;

public interface CargoRepository extends JpaRepository<CargoEntity, Long> {

	@Query("select d from CargoEntity d where d.estado = true")
	List<CargoEntity> findAllCustom();
}
