const http = require('http');
const fs = require('fs');
const con = require('./db');
const hostname = "127.0.0.1";
const port = "3000";

const server = http.createServer((req,res)=>{

	if(req.method=='GET' && req.url=='/'){
		res.statusCode = 200;
		res.setHeader('Content-Type','text/html');
		fs.createReadStream("./index.html").pipe(res);
		// var conn = con.getConnection();
		// conn.query('SELECT * FROM comments.comments',function(error,results,fields){
		// 	if(error) throw error;
		// 	results.forEach((comments)=>{
		// 		console.log(comments);
		// 	});
		// });
		// conn.end();
		
	}else if(req.method=='GET' && req.url=='/style.css'){
		res.statusCode = 200;
		res.setHeader('Content-Type','text/css');
		fs.createReadStream("./style.css").pipe(res);
	}else if(req.method=='GET' && req.url=='/functions.js'){
		res.writeHead(200,{"Content-Type":"text/javascript"});
		fs.createReadStream("./functions.js").pipe(res);
	}else if (req.method=='GET' && req.url=='/home') {
		res.statusCode = 200;
		res.setHeader('Content-Type','application/json');
		var conn = con.getConnection();
		conn.query('SELECT * FROM comments.comments',function(error,results,fields){
			if(error) throw error;
			var comments = JSON.stringify(results);
			res.end(comments);
		});
		conn.end();
	}else if(req.method=="POST" && req.url=="/insert"){
		res.statusCode = 200;
		res.setHeader('Content-Type','text/plain');
		var content = '';
		req.on('data',function(data){
			content +=data;

			var obj = JSON.parse(content);
			var conn = con.getConnection();
		conn.query('INSERT INTO comments.comments (comments.username,comments.comment) VALUES (?,?)',[obj.name,obj.message],function(error,results,fields){
			if(error) throw error;
			console.log("Success");
		});
		conn.end();
		res.end("Success!")
		});
	}
});

server.listen(port,hostname,()=>{
	console.log(`Server running at http://${hostname}:${port}/`)
});