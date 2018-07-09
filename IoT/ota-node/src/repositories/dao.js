import Sequelize from 'sequelize';
import logger from '~/utils/logger';
import config from '~/config';

export default class Dao {

    constructor() {
        this.repositories = [];
        this.connection = new Sequelize(config.dao.uri);
        this.connection.authenticate()
            .then(() => {
                logger.log('Repository: Connection has been established successfully.');
            })
            .catch(err => {
                logger.log(`Repository: Unable to connect to the database: ${err}`);
            });
    }

    init() {
        this.repositories.forEach(r => {
            r.init();
        });
        this.connection.sync({force: config.dao.force}).then(() => {
            logger.log(`Dao: Synced.`)
        });
    }

}