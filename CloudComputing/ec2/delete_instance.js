var AWS = require('aws-sdk');
AWS.config.loadFromPath("../config.json");
var ec2 = new AWS.EC2({
    apiVersion: '2016-11-15'
});
var params = {
    InstanceIds: ['i-0e43d55dee8adb348'],
};
ec2.terminateInstances(params, function(err, data) {
    if (err) {
        console.log("Could not terminate instance", err);
        return;
    }
    console.log("Created terminate");
});