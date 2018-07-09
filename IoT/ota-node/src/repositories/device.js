import * as Sequelize from "sequelize/lib/data-types";
import Repository from "~/repositories/repository";
import logger from '~/utils/logger'

const repositoryName = "DeviceRepository";

export default class DeviceRepository extends Repository {
    init() {
        this.repository = this.dao.connection.define('device', {
            uid: Sequelize.STRING(10),
            version: Sequelize.STRING(5),
            uptime: Sequelize.FLOAT(11),
            lastSync: Sequelize.DATE
        });
    }

    findByUid(uid) {
        return new Promise((resolve, reject) => {

            this.repository.findOne({where: {uid}})
                .then(d => {
                    logger.log(`${repositoryName}(${req.params.uid}): Uid found.`);
                    resolve(d)
                })
                .catch(err => {
                    logger.log(`${repositoryName}(${req.params.uid}): findByUid failed. ${err}`);
                    reject();
                });
        });
    }

    deleteByUid(uid) {
        return this.repository.destroy({where: {uid}});
    }
}