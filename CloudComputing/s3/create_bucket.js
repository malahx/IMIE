var AWS = require('aws-sdk');
AWS.config.loadFromPath("../config.json");
var s3 = new AWS.S3({
    apiVersion: '2006-03-01'
});
var params = {
    Bucket: "bucket-gmpvpc-user-06",
    ACL: "public-read",
    CreateBucketConfiguration: {
        LocationConstraint: "eu-central-1"
    }
};
s3.createBucket(params, function(err, data) {
    if (err) console.log(err, err.stack); // an error occurred
    else console.log(data); // successful response
    data = {
        Location: "http://bucket-gmpvpc-user-06.s3.amazonaws.com/"
    }
});