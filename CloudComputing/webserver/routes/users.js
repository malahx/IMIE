var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource HA');
});

/* GET users listing. */
router.get('/imie-a4-dev-user-06', function(req, res, next) {
  res.send('gmpvpc');
});


module.exports = router;
