import express from 'express';
import logger from '~/utils/logger'
import config from '~/config';
import deviceService from '~/service/device'

const api = config.api.ota;
const controllerName = "DeviceController";

let deviceController = express.Router();

deviceController.post(`${api.register}/:uid`, (req, res) => {
    logger.log(`${controllerName}(${req.params.uid}): Register...`);
    deviceService.register(req.params.uid).then(d => {
        logger.log(`${controllerName}(${req.params.uid}): Registered.`);
        res.end(d);
    });
});

deviceController.delete(`${api.unregister}/:uid`, (req, res) => {
    logger.log(`${controllerName}(${req.params.uid}): Unregister...`);
    deviceService.unregister(req.params.uid).then(d => {
        logger.log(`${controllerName}(${req.params.uid}): Unregistered.`);
        res.end(d);
    });
});

deviceController.post(`${api.info}/:uid`, (req, res) => {
    logger.log(`${controllerName}(${req.params.uid}): Info...`);
    deviceService.info(req.params.uid, req.body).then(d => {
        logger.log(`${controllerName}(${req.params.uid}): Info saved.`);
        res.end(d);
    });
});

deviceController.get(`${api.version}/:uid`, (req, res) => {
    logger.log(`${controllerName}(${req.params.uid}): Version...`);
    deviceService.version(req.params.uid).then(v => {
        logger.log(`${controllerName}(${req.params.uid}): Version gotten.`);
        res.end(v);
    });
});

export default deviceController;