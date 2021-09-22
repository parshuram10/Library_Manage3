YUI().use('datatable','datatype-number',function(Y){
	
	var data = [
		{id:1, name:"Vaibhav", city:"Indapur", age:23123445, 
		details:"<a href='details.html'>details</a>"},
		{id:2, name:"Sana", city:"Akluj", age:21553543, details:"<a href='details.html'>details</a>"},
		{id:3, name:"Pooja", city:"Mumbai", age:22533, details:"<a href='details.html'>details</a>"}
	];
	
	function formatNumber(cell){
		//console.log(JSON.stringify(cell));
		//cell.value = "***";
		//return "....";
		return Y.DataType.Number.format(cell.value,{
			thousandsSeparator: ","
			//thousandsSeparator: "."
		});
	}
	
	var table = new Y.DataTable({
		data: data,
		columns:[
			{key:"id", label:"ID"},
			{key:"name", label:"Name"},
			{key:"city", label:"ID"},
			{key:"age", label:"Age", formatter:formatNumber, className:"number"},
			{key:"details",label:"",allowHTML:true}],
		caption:"Employee Details"
	});
	table.render("#cities");
});