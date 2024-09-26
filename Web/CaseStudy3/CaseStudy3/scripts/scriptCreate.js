// JavaScript Document

function validate(isEdit){
	var succeesMsg="";
    if(isEdit==1){
		succeesMsg="car edited successfully";
		}else {
			succeesMsg="car created sucessfully";
			}
	var engine_value=document.getElementById('EngineInCC').value;
	var milage_value=document.getElementById('Milage').value;
	var price_value=document.getElementById('Price').value;
	var filter = /^[0-9]+(.[0-9]{1,2})?$/;
	if (!filter.test(engine_value)) 
		{
			alert('Please provide a valid Engine value');
			document.getElementById("EngineInCC").value="";
			
			return false;
		}
		if (!filter.test(milage_value)) 
		{
			alert('Please provide a valid milage value');
			document.getElementById("Milage").value="";
			return false;
		}
		if (!filter.test(price_value)) 
		{
			alert('Please provide a valid price value');
			document.getElementById("Price").value="";
			return false;
		}
	else{
			alert(succeesMsg);
			return true;
		}
 
 
		
}
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