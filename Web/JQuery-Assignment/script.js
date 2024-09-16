function show(){
	
		document.getElementById("text_area").style.display='inline';
		
		document.getElementById("show_hide").value="hide";
		document.getElementById("show_hide").onclick=hide;
}
function hide(){
		document.getElementById("text_area").style.display='none';
		
		document.getElementById("show_hide").value="show";
		document.getElementById("show_hide").onclick=show;
}
