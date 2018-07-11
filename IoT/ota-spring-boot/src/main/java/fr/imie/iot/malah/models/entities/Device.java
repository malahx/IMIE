package fr.imie.iot.malah.models.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;

    @Column(name = "created_at")
    @CreatedDate
    protected ZonedDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    protected ZonedDateTime updatedAt;

    @Column(nullable = false)
    private String uuid;

    @Column(name = "hardware_version")
    private int hwVer = 1;

    @Column(name = "software_version")
    private int swVer = 1;

    @Column
    private int uptime;

    @Column(name = "last_sync")
    private ZonedDateTime lastSync;

    @PrePersist
    public void prePersist() {
        ZonedDateTime now = ZonedDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }

}
