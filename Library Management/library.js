$('.adm-btn').click(function(){
    window.location.href = 'admin/admin.html';
});
$('.adm-img').click(function(){
    window.location.href = 'admin/admin.html';
});
$('.stu-btn').click(function(){
    window.location.href='student/student.html';
});
$('.stu-img').click(function(){
    window.location.href='student/student.html';
});


$('.submit-f').click(function(){
    
    
    var db = openDatabase("itemDB","1.0","itemDB",65535);
    var name = $('.myName').val();
    var email = $('.myEmail').val();
    // var phone = $('.myPhone').val();
    // $('#just').text(name+email+phone);
    // alert("Success");
    
    db.transaction(function(transaction){
        var sql = "CREATE TABLE items "+
        "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
        "name VARCHAR(100) NOT NULL, "+
        "phone INT(10) NOT NULL); ";
        transaction.executeSql(sql,undefined,function(){
            alert("Success");
        },function(){
            alert("fail");
        })
    });
    $('#just').text(name+email);
});

$('.imgLogo').click(function(){
    window.location.href='library-main.html';
});