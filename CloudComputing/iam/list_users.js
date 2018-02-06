var AWS = require('aws-sdk');
AWS.config.loadFromPath("../config.json");
var iam = new AWS.IAM({
    apiVersion: '2010-05-08'
});
var params = {};
iam.listUsers(params, function(err, data) {
    if (err) {
        console.log(err, err.stack);
    } else {
        var i;
        for (i = 0; i < data.Users.length; i++) {
            console.log('UserName: ' + data.Users[i].UserName + '(' + data.Users[i].UserId + ')');
        }
    }
})