//Selects all span with class name: “message”
$(document).ready(function() {
	$("span[class='message']").css("background-color","#009ACD");
	});

//Selects first div in a document that has class: “box”	
$(document).ready(function() {
	$("div[class='box:first']").css("background-color","#00C78C");
	});
			
//Selects all buttons in a document.			
$(document).ready(function() {
	$("button").css("background-color","#0198E1").css("height","30px").css("width","70px").text("Click me");
	});
	
//Selects all images having alternate text as: “hello”	
$(document).ready(function() {
	$('img[alt="hello"]').click(function(){
		$("img").hide(); 
			});
		});

//Selects all text boxes under a div having Id = “myDiv”		
$(document).ready(function() {
	$("input[id=mydiv]").css("background-color","#20BF9F	");
		});

//Selects all text boxes with name starting by: “txt”		
$(document).ready(function() {
	$("input[name^='txt']").css("background-color","#7D9EC0	");
		});

//Selects all paragraphs element, not having class “box”		
$(document).ready(function() {
	if($("p:not(.box)")) {
		alert("paragraph element not having class box");
			}
		}); 

//Selects all the divs having either “box” or “error” class		
$(document).ready(function() {
	$(".box,.error").css("border","black");
		});
	
//Selects all the divs having either “box” and “error” class.	
$(document).ready(function(){
	alert($(".box.error").length);
		});
	
//Find all the span having “info” class in a div with id = “myDiv”	
$(document).ready(function() {
	alert($("div[id='mydiv']").find("span[class='info']").length);
		});