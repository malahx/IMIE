var express = require('express');
var AWS = require('aws-sdk');
var fs = require('fs');

// Config
AWS.config.loadFromPath("config.json");
var s3 = new AWS.S3({
    apiVersion: '2006-03-01'
});
var router = express.Router();

router.get('/', function(req, res, next) {
  	var params = {};
	s3.listBuckets(params, function(err, data) {
	    if (err) console.log(err, err.stack); // an error occurred
	    else res.send(data); // successful response
	});
});

router.get('/:bucket', function(req, res, next) {
	var params = { 
		Bucket: req.params.bucket,
		Delimiter: '/'
	}

	s3.listObjects(params, function (err, data) {
	if(err)throw err;
		res.send(data);
	});
});

router.post('/:bucket/add/:file', function(req, res, next) {
    var params = {
        ACL: "public-read",
        Body: req.body.data,
        Bucket: req.params.bucket,
        Key: req.params.file,
        ServerSideEncryption: "AES256",
		// ContentEncoding: 'base64',
		// ContentType: 'image/jpeg'
    };
    s3.putObject(params, function(err, data) {
        if (err) console.log(err, err.stack); // an error occurred
        else res.send(data); // successful response
    });
});

router.get('/:bucket/:file/info', function(req, res, next) {
	var params = {
	    Bucket: req.params.bucket,
	    Key: req.params.file
	};
	s3.getObject(params, function(err, data) {
	    if (err) console.log(err, err.stack); // an error occurred
	    else {
	        res.send(data);
	    };
	});
});


router.get('/:bucket/:file', function(req, res, next) {
	var params = {
	    Bucket: req.params.bucket,
	    Key: req.params.file
	};
	s3.getObject(params, function(err, data) {
	    if (err) console.log(err, err.stack); // an error occurred
	    else {
	    	console.log(data.Body);
	    	res.
	        res.send(new Buffer(data.Body, 'base64'));
	    };
	});
});

module.exports = router;