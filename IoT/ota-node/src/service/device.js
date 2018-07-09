import logger from "~/utils/logger"
import {Device} from "~/models/ota/device";
import Version from "~/models/dto/ota/version";
import {deviceRepository} from '~/index';

const serviceName = "DeviceService";

class DeviceService {

    register(uid) {
        logger.log(`${serviceName}(${uid}): Register...`);
        return new Promise((resolve, reject) => {
            deviceRepository.create({uid: uid})
                .then(d => {
                    logger.log(`${serviceName}(${uid}): Registered.`);
                    resolve(d);
                })
                .catch(err => {
                    logger.log(`${serviceName}(${uid}): Register failed - ${err}`);
                    reject();
                });
        });
    }

    unregister(uid) {
        logger.log(`${serviceName}(${uid}): Unregister...`);
        return new Promise((resolve, reject) => {
            deviceRepository.deleteByUid(uid)
                .then(d => {
                    logger.log(`${serviceName}(${uid}): Unregistered.`);
                    resolve(d);
                }).catch(err => {
                logger.log(`${serviceName}(${uid}): Unregister failed - ${err}`);
                reject();
            });
        })
    }

    info(uid, data) {
        logger.log(`${serviceName}(${uid}): Info...`);
        return new Promise((resolve, reject) => {
            deviceRepository.findByUid(uid)
                .then(d => {
                    if (d != null) {
                        deviceRepository.update(d.id, data);
                    }
                    logger.log(`${serviceName}(${uid}): Info gotten: ${d}`);
                    resolve(d);
                })
                .catch(err => {
                    logger.log(`${serviceName}(${uid}): Info failed - ${err}`);
                    reject();
                });
        });
    }

    version(uid) {
        logger.log(`${serviceName}(${uid}): Version...`);
        return new Promise((resolve, reject) => {
            deviceRepository.findByUid(uid)
                .then(d => {
                    let version = new Version();
                    if (d != null) {
                        version.link = "https://new_version";
                    }
                    logger.log(`${serviceName}(${uid}): Version gotten: ${version}`);
                    resolve(version);
                })
                .catch(err => {
                    logger.log(`${serviceName}(${uid}): Version failed - ${err}`);
                    reject();
                });
        });
    }

}

export default new DeviceService();