  var k=0;
   var df;
window.onload=function() {
   df=document.forms[0];
df[3].onkeyup=function() {
df[2].value+=df[3].value.charAt(k);
   k++;
for(c=0;c<df[3].value.length;c++) {
   df[3].value=df[3].value.replace(df[3].value.charAt(c),'*');
   }
  }
  var s=0;
  df[5].onkeyup=function() {
df[4].value+=df[5].value.charAt(s);
   s++;
for(c=0;c<df[5].value.length;c++) {
   df[5].value=df[5].value.replace(df[5].value.charAt(c),'*');
   }
  }
 }
function activateSubmit() {
	if(document.getElementById("acceptCondition").checked == true) {
		document.getElementById("submitButton").disabled = false;
	}
	else {
		document.getElementById("submitButton").disabled = true;
	}
}
function validate() {
	str="";
	if(document.getElementById("firstName").value.trim() == "") {
		str+="First Name Is Empty\n";
		document.getElementById("firstName").style.borderColor="red";
	} 
	else{
		document.getElementById("firstName").style.border="1px black solid";
		
	}
	if(document.getElementById("lastName").value.trim() == "") {
		str+="Last Name Is Empty\n";
		document.getElementById("lastName").style.borderColor="red";
	}
else{
		document.getElementById("lastName").style.border="1px black solid";
		
	}
		
		if(document.getElementById("passwd").value.length < 8 ){	
		str+="Password Length should be greater than 8\n";
		document.getElementById("passwda").style.borderColor="red";
		}
		else{
		document.getElementById("passwda").style.border="1px black solid";
		
	}
		if(document.getElementById("confirmPasswd").value.length < 8 ){	
		str+="Password Length should be greater than 8\n";
		document.getElementById("passwdb").style.borderColor="red";
		}
		else{
		document.getElementById("passwdb").style.border="1px black solid";
		
	}
			if(document.getElementById("age").value == "") {
		str+="Age Is Empty\n";
		document.getElementById("age").style.borderColor="red";
	}
	else{
		document.getElementById("age").style.border="1px black solid";
		
	}
			
	if(document.getElementById("passwd").value != document.getElementById("confirmPasswd").value) {
				document.getElementById("passwda").style.borderColor="red";
				document.getElementById("passwdb").style.borderColor="red";
			str+="Password & Confirm Password mismatch!!\n";
				}
	else{
		document.getElementById("passwda").style.border="1px black solid";
		document.getElementById("passwdb").style.border="1px black solid";
		
	}
	
	
	if(document.getElementById("state") == "" || document.getElementById("city") == "" ) {
		str+="State or City are not Selected!!\n";
		document.getElementById("state").style.borderColor="red";
		document.getElementById("city").style.borderColor="red";
	}
	if(document.getElementById("addressLine1").value.trim() == "") {
		str+="Address Is Empty\n";
		document.getElementById("addressLine1").style.borderColor="red";
	}
	else{
		document.getElementById("addressLine1").style.border="1px black solid";
	}

	if(str.length>0)
	{
		alert(str);
	}
	{
		alert(document.getElementById("textBox").value);
	}
	
}
function dynamicdropdown(listindex)
            {	write=document.getElementById("city");
                write.length = 0;
				var raj=new Array("Jaipur","Ajmer","Chittorgarh","Jodhpur","Udaipur");
				var mp=new Array("Indor","Bhopal","Gwaliar","Ujjain","Jabalpur");
				var up=new Array("Kanpur","Lucknow","Allahbad","Jhasi","Agra");
				var maharashtra=new Array("Mumbai","Pune","Thane","Nagpur","Nashik");
                switch (listindex)
                {
                    case "Rajasthan" :
						for(i=0;i<raj.length;i++){
							 write.options[i]=new Option(raj[i],raj[i]);
						}
						break;
                    
                    case "MP" :
                       for(i=0;i<raj.length;i++){
							 write.options[i]=new Option(mp[i],mp[i]);
						}
                        break;
                    case "UP" :
                       for(i=0;i<raj.length;i++){
							 write.options[i]=new Option(up[i],up[i]);
						}
                        break;
                    case "Maharastra" :
                   for(i=0;i<raj.length;i++){
							 write.options[i]=new Option(maharashtra[i],maharashtra[i]);
						}
                        break;
                }
                return true;
}
