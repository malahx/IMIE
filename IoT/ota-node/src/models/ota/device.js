import {Entity} from "~/models/entity";

export default class Device extends Entity {
    constructor() {
        super();
        this.version = null;
        this.uptime = null;
        this.lastSync = null;
    }
}