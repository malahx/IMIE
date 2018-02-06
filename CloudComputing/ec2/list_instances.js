var AWS = require('aws-sdk');
AWS.config.loadFromPath("../config.json");
var ec2 = new AWS.EC2({
    apiVersion: '2016-11-15'
});
var params = {};
ec2.describeInstances(params, function(err, data) {
    if (err) {
        console.log(err, err.stack);
    } else {
        console.log(data);
    }
});