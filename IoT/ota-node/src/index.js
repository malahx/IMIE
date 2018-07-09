import App from '~/api/app'
import Dao from '~/repositories/dao'
import DeviceRepository from "~/repositories/device";


let dao = new Dao();
export let deviceRepository = new DeviceRepository(dao);
dao.init();

let server = new App();
server.start();