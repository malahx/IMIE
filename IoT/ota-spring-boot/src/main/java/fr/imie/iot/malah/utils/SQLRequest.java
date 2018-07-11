package fr.imie.iot.malah.utils;

public interface SQLRequest {

    String THERMAL_FROM_SENSOR = "SELECT * FROM thermal WHERE uuid=`%s`";

}
