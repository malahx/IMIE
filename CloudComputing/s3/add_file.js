var AWS = require('aws-sdk');
var fs = require('fs');
AWS.config.loadFromPath("../config.json");
var s3 = new AWS.S3({
    apiVersion: '2006-03-01'
});
fs.readFile("read_file.js", 'utf8', function(err, data) {
    if (err) {
        return console.log(err);
    }
    console.log(data);
    var params = {
        ACL: "public-read",
        Body: data,
        Bucket: "bucket-glh",
        Key: "read_file.js",
        ServerSideEncryption: "AES256"
    };
    s3.putObject(params, function(err, data) {
        if (err) console.log(err, err.stack); // an error occurred
        else console.log(data); // successful response
    });
});