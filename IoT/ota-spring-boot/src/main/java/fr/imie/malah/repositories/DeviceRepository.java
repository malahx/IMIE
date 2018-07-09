package fr.imie.malah.repositories;

import fr.imie.malah.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

    Device findByUuid(String uuid);

}
