package fr.imie.iot.malah.repositories;

import fr.imie.iot.malah.models.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

    Device findByUuid(String uuid);

}
