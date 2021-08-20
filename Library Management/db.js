var db = openDataBase("itemDB","1.0","itemDB",65535);
$('.submit-f').click(function(){

    var name = $('.myName').val();
    var email = $('.myEmail').val();
    var phone = $('.myPhone').val();
    $('#just').text(name+email+phone);
    alert("Success");
    // db.transaction(function(){
    //     var sql = "CREATE TABLE items"+
    //     "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
    //     "name VARCHAR(100) NOT NULL,"+
    //     "phone INT(10) NOT NULL)";
    //     transaction.executeSql(sql,undefined,function(){
    //         alert("Success");
    //     },function(){
    //         alert("fail");
    //     });
    // });
    // alert("nothing");
});

