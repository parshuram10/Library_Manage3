// var db = openDataBase("itemDB","1.0","itemDB",65535);
// $('.submit-f').click(function(){

//     var name = $('.myName').val();
//     var email = $('.myEmail').val();
//     var phone = $('.myPhone').val();
//     $('#just').text(name+email+phone);
//     alert("Success");
//     // db.transaction(function(){
//     //     var sql = "CREATE TABLE items"+
//     //     "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
//     //     "name VARCHAR(100) NOT NULL,"+
//     //     "phone INT(10) NOT NULL)";
//     //     transaction.executeSql(sql,undefined,function(){
//     //         alert("Success");
//     //     },function(){
//     //         alert("fail");
//     //     });
//     // });
//     // alert("nothing");
// });
function addRecord(){
var mysql = require('mysql')

var con = mysql.createConnection({

    host :"localhost",
    user:"root",
    password:"Parshuram@1234",
    database:"stud"
})

con.connect(function(err){
    if(err) throw err;
    var sql = "INSERT into data values('9','Teja Patil')"
    con.query(sql,function(err,result){
    if(err) throw err;
    console.log("1 entry added")
    })
})
}
$('.submit-f').click(function(){
    var name = $('.myName').val();
    var email = $('.myEmail').val();
    var phone = $('.myPhone').val();
    $('#just').text(name+email+phone);
    addRecord();
    
})