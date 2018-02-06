var AWS = require('aws-sdk');
AWS.config.loadFromPath("../config.json");
var s3 = new AWS.S3({
    apiVersion: '2006-03-01'
});
var params = {};
s3.listBuckets(params, function(err, data) {
    if (err) console.log(err, err.stack); // an error occurred
    else console.log(data); // successful response
});