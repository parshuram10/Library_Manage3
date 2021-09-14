var m=0;
var y;
function start() {
	// body...
y=setInterval(run,100);

function run() {
	// body...

	if(m==1190){
		clearInterval(y);
		m=0;
	}else{
		m+=10;
		var car = document.getElementById("img");
		car.style.marginLeft=m+"px";
	}
}

}
function stop(){
	clearInterval(y);
}