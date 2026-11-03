package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.CargoEntity;

public interface CargoService {

	List<CargoEntity> findAll();

	List<CargoEntity> findAllCustom();

	CargoEntity findById(Long id);

	CargoEntity add(CargoEntity obj);

	CargoEntity update(CargoEntity obj, Long id);

	CargoEntity delete(Long id);

	CargoEntity enable(Long id);
}
