var add_form = document.getElementById("add-form");
var update_form = document.getElementById("update-form");
var del_form = document.getElementById("del-form");
var search_form = document.getElementById("search-form");
var view_form = document.getElementById("view-form");
function toggleHide() {
	// body...
	if(add_form.style.display!="none" || update_form.style.display != "none" || del_form.style.display != "none"
		|| search_form.style.display != "none" || view_form.style.display != "none"){
		add_form.style.display = "none";	
	update_form.style.display = "none";
	del_form.style.display = "none";
	search_form.style.display = "none";
	view_form.style.display = "none";
}

}

function addDate() {
	// body...
	let dateH1 = document.getElementById("date");
	let date = new Date();
	dateH1.innerHTML = date;

	setInterval(addDate,1000);
}

function addForm(){
	if(add_form.style.display!="none"){
		add_form.style.display = "none";	
	}else{
		add_form.style.display = "block";
		update_form.style.display = "none";
		del_form.style.display = "none";
		search_form.style.display = "none";
		view_form.style.display = "none";
	}
}

function updateForm() {
	// body...
	if(update_form.style.display!="none"){
		update_form.style.display = "none";	
	}else{
		update_form.style.display = "block";
		add_form.style.display = "none";
		del_form.style.display = "none";
		search_form.style.display = "none";
		view_form.style.display = "none";
	}
}

function delForm(){
	// body...
	if(del_form.style.display!="none"){
		del_form.style.display = "none";	
	}else{
		del_form.style.display = "block";
		add_form.style.display = "none";
		update_form.style.display = "none";
		search_form.style.display = "none";
		view_form.style.display = "none";
	}
}

function searchForm() {
	// body...
	if(search_form.style.display!="none"){
		search_form.style.display = "none";	
	}else{
		search_form.style.display = "block";
		add_form.style.display = "none";
		del_form.style.display = "none";
		update_form.style.display = "none";
		view_form.style.display = "none";
	}
}

function viewForm() {
	// body...
	if(view_form.style.display!="none"){
		view_form.style.display = "none";	
	}else{
		view_form.style.display = "block";
		add_form.style.display = "none";
		del_form.style.display = "none";
		search_form.style.display = "none";
		update_form.style.display = "none";
	}
}

function saveForm() {
	// body...
	// let name = document.getElementById("name");
	// let author = document.getElementById("author");
	// let lang = document.getElementById("lang");
	// let price = document.getElementById("price");
	let rIndex,table = document.getElementById("table");

	var newRow = table.insertRow(table.length),
	cell1 = newRow.insertCell(0),
	cell2 = newRow.insertCell(1),
	cell3 = newRow.insertCell(2),
	cell4 = newRow.insertCell(3),
	name = document.getElementById("name").value,
	author = document.getElementById("author").value,
	lang = document.getElementById("lang").value,
	price = document.getElementById("price").value;
	cell1.innerHTML = name;
	cell2.innerHTML = author;
	cell3.innerHTML = lang;
	cell4.innerHTML = price;
}

toggleHide();
addDate();


// $('#add-form').hide();
// $('#update-form').hide();
// $('#del-form').hide();
// $('#search-form').hide();
// $('#view-form').hide();
// $('#add').click(function(){
// 	$('#update-form').hide();
// 	$('#del-form').hide();
// 	$('#search-form').hide();
// 	$('#view-form').hide();
// 	$('#add-form').toggle();
// })
// $('#update').click(function(){
// 	$('#add-form').hide();
// 	$('#del-form').hide();
// 	$('#search-form').hide();
// 	$('#view-form').hide();
// 	$('#update-form').toggle();
// })
// $('#del').click(function(){
// 	$('#update-form').hide();
// 	$('#add-form').hide();
// 	$('#search-form').hide();
// 	$('#view-form').hide();
// 	$('#del-form').toggle();	
// })
// $('#search').click(function(){
// 	$('#update-form').hide();
// 	$('#del-form').hide();
// 	$('#add-form').hide();
// 	$('#view-form').hide();
// 	$('#search-form').toggle();
// })
// $('#view').click(function(){
// 	$('#update-form').hide();
// 	$('#del-form').hide();
// 	$('#search-form').hide();
// 	$('#add-form').hide();
// 	$('#view-form').toggle();
// })