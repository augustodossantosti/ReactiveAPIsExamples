var fs = require('fs');
var http = require('http');

var connectionCounter = 1;

http.createServer(function(request, response) {

    if (request.url === '/') {

        response.writeHead(200, { 'Content-Type': 'text/html' });
        response.write(fs.readFileSync('index.html'));
        response.end();

    } else {

        response.writeHead(404);
        response.end();

    }

}).listen(8888);