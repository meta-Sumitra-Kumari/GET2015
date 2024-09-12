// JavaScript Document
function byId(e) {
	return document.getElementById(e);
	}
 
function makeComboChange()
    {
        var combo1 = byId('makeCombo');
        var combo2 = byId('modelCombo');
        emptyCombo(combo2);
        switch(combo1.value)
        {
            case '-1':  addOption(combo2, -1, '-select company first-');
                        break;
            case '0':   addOption(combo2, 0, 'AudiQ3');
                        addOption(combo2, 1, 'AudiA7');
                        break;
            case '1':   addOption(combo2, 2, 'Fiesta');
                        addOption(combo2, 3, 'EcoSport');
                        break;
            case '2':   addOption(combo2, 4, 'Honda Jazz');
                        addOption(combo2, 5, 'Honda Vezel');
					    break;
        }
        modelComboChange();
    }
function modelComboChange()
    {
        var combo2;
        combo2 = byId('modelCombo');    
    }
 
function emptyCombo(e)
    {
        e.innerHTML = '';
    }
 
function addOption(combo, val, txt)
    {
        var option = document.createElement('option');
        option.value = val;
        option.title = txt;
        option.appendChild(document.createTextNode(txt));
        combo.appendChild(option);
    }
	
function submitSearch()
	{
	   var make= document.getElementById("makeCombo").value;
	   var model= document.getElementById("modelCombo").value;
	   if(make==-1)
	   {
		 alert("Please select a car to show");
		 return false;
		}
	   var frameUrl="search.html?make="+make+"&model="+model;
	   location.href=frameUrl;
	}
	