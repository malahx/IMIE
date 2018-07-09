import express from 'express';
import bodyParser from 'body-parser';
import router from '~/api/routes';
import logger from '~/utils/logger';
import config from '~/config';

export default class App {
    constructor() {
        this.app = express();
        this.app.use(bodyParser.json());
        this.app.use(bodyParser.urlencoded({extended: false}));
        this.app.use(logger.morgan);
        this.app.use(config.api.root, router);
    }

    start() {
        logger.log(`App Start ...`);
        this.app.listen(config.api.port, () => {
            logger.log(`App Listening port ${config.api.port}`);
        });
    }
}