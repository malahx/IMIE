var AWS = require('aws-sdk');
AWS.config.loadFromPath("../config.json");
var ec2 = new AWS.EC2({
    apiVersion: '2016-11-15'
});
var params = {
    ImageId: 'ami-1e339e71', //code de l'image ubuntu
    InstanceType: 't2.micro',
    MinCount: 1,
    MaxCount: 1,
    KeyName: 'gmpvpc-user-06',
    SecurityGroupIds: ['sg-9de97ff7']
};
ec2.runInstances(params, function(err, data) {
    if (err) {
        console.log("Could not create instance", err);
        return;
    }
    var instanceId = data.Instances[0].InstanceId;
    console.log("Created instance", instanceId);
    params = {
        Resources: [instanceId],
        Tags: [{
            Key: 'Name',
            Value: 'gmpvpc-user-06'
        }]
    };
    ec2.createTags(params, function(err) {
        console.log("Tagging instance", err ? "failure" : "success")
    });
});