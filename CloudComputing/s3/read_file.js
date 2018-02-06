var AWS = require('aws-sdk');
var fs = require('fs');
AWS.config.loadFromPath("../config.json");
var s3 = new AWS.S3({
    apiVersion: '2006-03-01'
});
var params = {
    Bucket: "bucket-glh",
    Key: "hello.world"
};
s3.getObject(params, function(err, data) {
    if (err) console.log(err, err.stack); // an error occurred
    else {
        console.log(data);
		fs.writeFile("hello.world", data.Body);
    };
});