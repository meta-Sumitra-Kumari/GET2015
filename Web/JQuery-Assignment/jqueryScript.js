$(document).ready(function(){
    $('#show').click(function(){
		$('#text_area').show();
		 $('#show_hide').prop('value', 'Hide');
    });
	 $('#hide').click(function(){
		
		$('#text_area').hide();
      
	   $('#show_hide').prop('value', 'Show');
		
    });
	 $('#show_hide').click(function(){
		$('#text_area').toggle();
		if(document.getElementById("show_hide").value=="show"){
		$('#show_hide').prop('value', 'Hide');	
		}
		else{
		 $('#show_hide').prop('value', 'show');	
		}
		
       
		
    });
});