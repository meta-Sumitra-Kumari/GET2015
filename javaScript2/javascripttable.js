function checkInteger(){
var c=document.getElementById("item");
if(isNaN(c.value))
{
	c.style.borderColor="red";
	c.value="";
	 c.placeholder="Enter a integer value";
}
  
else if(c.value=="" )
{
	c.style.borderColor="red";
	c.value="";
	c.placeholder="Enter a  value";
}
	else if( c.value==0)
	{
		c.style.borderColor="red";
	c.value="";
	c.placeholder="Zero is not allowed";
	}
else
{
	c.style.border="1px black solid";
	var str1=showdata(c.value);
	document.getElementById("div2").innerHTML=str1;
}
return true;
}

function showdata(c){
	var str;
	str="<table  cellspacing='2'  class='maketable'>";
	str+="<tr><th>Name</th><th>Minimum</th><th>Maximum</th></tr>";
		for(var i=0;i<c;i++)
		{
			str+="<tr><td><input type='text' class='name' placeholder='Enter name'/ ></td><td><input type='text' class='min' placeholder='Enter minimum value'/ ></td>"
			str+="<td><input type='text' class='max' placeholder='Enter maximum value'/ ></td></tr>";
		}
    str+="</table>";
	str+="<input type='button' value='OK' onclick='validate();'>";
    	return str;
}

function validate(){
	var str="";
	var name=document.getElementsByClassName("name");
	var min=document.getElementsByClassName("min");
	var max=document.getElementsByClassName("max");
	var rows=document.getElementById("item").value;
	
	for(var i=0;i<rows;i++){
		str+=checkName(name[i])+checkMin(min[i])+checkMax(max[i],min[i]);
		
		
	}
	if(str.length>0){
			
		}
		else
		{
			document.getElementById("div3").innerHTML="<h3>Coloured Table</h3>"+createTable(name,min,max,rows);
		}
	
}

function createTable(name,min,max,rows){
	var str;
	str="<table class='colortable' cellspacing='0'>";
	for(var i=0;i<rows;i++)
		{
			str+="<tr ><td id='namecolumn'>"+name[i].value+"</td>";
			for(var j=0;j<11;j++){
				if(min[i].value<=j && max[i].value>=j )
					str+="<td Style='background-color:red' class='innercolumn'></td>";
				else
			       str+="<td ></td>";
			}
		}
    str+="</table>";
	return str;
}

function checkName(name){
	var letters = /^[A-Za-z]+$/; 
	if(name.value==""){
		name.style.borderColor="red";
	return("Empty name value not allowed\n");
	}
	else if(!name.value.match(letters))
	{
		name.style.borderColor="red";
		name.value="";
		name.placeholder="enter alphabets only";
		return("Enter alphabets only\n");
	}
			
	else
	{
		name.style.border="1px black solid";
		return "";
	}
		
		
}

function checkMin(min){
	var x=min.value;
	if(isNaN(x)){
		min.style.borderColor="red";
		return("Enter a valid integer Number\n");
	}
	else if(x<=0 || x>10) {
		min.style.borderColor="red";
		min.value="";
		min.placeholder="Minimum value must be between 0 and 10";
	return("Minimum value must be between 0 and 10\n");
	}
	else
	{
		min.style.border="1px black solid";
		return "";
	}
		
}

function checkMax(max,min){
	var y=max.value;
	if(isNaN(y)){
		max.style.borderColor="red";
		return("Enter a valid integer Number\n");
	}
	else if(y<=0 || y>10){
		max.style.borderColor="red";
		max.value="";
		max.placeholder="Maximum value must be between 0 and 10";
		return("Maximum value must be between 0 and 10\n");
	}
    else if(y<=min.value){
		max.style.borderColor="red";
		max.value="";
		max.placeholder="Maximum must be greater than minimum";
		return("Maximum must be greater than minimum\n");
	}
	else
	{
		max.style.border="1px black solid";
		return "";
}
	}
		
