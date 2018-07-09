import express from 'express';
import config from '~/config';
import device from "~/api/controllers/device";

let router = express.Router();

router.use(config.api.device.root, device);

export default router;