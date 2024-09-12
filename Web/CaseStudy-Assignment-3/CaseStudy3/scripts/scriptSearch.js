function showSelectedSearch(){
	       var childDivs=document.getElementById("offer_list").getElementsByClassName('offer_item');
		   
		   var modelToShow=location.search.split('model=')[1];
		   if(modelToShow!=null) {
		    	   
		   for(i=0;i<childDivs.length;i++){
		      var getChildElementId=childDivs[i].getAttribute('id');
			  if(childDivs[i].getAttribute('id')==modelToShow) {
			     childDivs[i].style.display='block';
			  }else {
			       childDivs[i].style.display='none';
			  } 
			  
		   }
		   }
	}