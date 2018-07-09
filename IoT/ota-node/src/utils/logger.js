import morgan from 'morgan';
import fs from 'fs';
import config from '~/config';

class Logger {
    constructor() {
        this.logStream = fs.createWriteStream(config.logger.path, {flags: 'a'});
        this.morgan = morgan(config.logger.type, {stream: this.logStream});
    }

    log(message) {
        this.logStream.write(`${message}\n`);
        console.log(message);
    }
}

export default new Logger();