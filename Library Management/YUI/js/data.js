YUI({skin:"night" , lang:"en"}).use('datatable','datatype',function(Y){
	
	var data = [
		
		{number:"1", issued:new Date(2012,5,1), amount:813.56, varp:0},
		{number:"2", issued:new Date("MAY 7, 2021 UTC"), amount:94.43, varp:17.5},
		{number:"3", issued:new Date("June 5, 2021"), amount:1973.36, varp:17.5}
	];
	
	function formateDate(cell){
		return Y.DataType.Date.format(cell.value,{
			format:"%d %b %Y"
		})
	}
	
	function formateCurrency(cell){
		format={
        thousandsSeparator: ".",
        decimalSeparator: ",",
        decimalPlaces: 2,
        suffix: " (YEN)"
		}
		return Y.DataType.Number.format(cell.value,format);
	}
	
	var table = new Y.DataTable({
	
		data: data,
		columns:[
			{key:"number", lable:"Number"},
			{key:"issued", lable:"Issued Date", formatter:formateDate},
			{key:"amount", lable:"Amount", formatter:formateCurrency},
			{key:"varp", lable:"Varp"},
		],sortable:true,
		caption:"Invoice List"
	});
	
	table.render("#divTable");
})