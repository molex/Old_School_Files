function DoAllThese() {
	var retvalue;
	retvalue = valFields();
	if(retvalue == false) { return retvalue; }
	retvalue = valRadios(form);
	if(retvalue == false) { return retvalue; }
}

function valFields()
{
	if (document.survey.name.value=='')
		{
		alert("ERROR:  Please enter your name");
		document.survey.name.focus();
		return false;
		}
	else
	{
	return emailCheck('form','email');
	}
}

function emailCheck(form_id,email) 
	{
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var address = document.forms[form_id].elements[email].value;
	if((reg.test(address) == false)||(document.survey.email.value==''))
		{
		alert('ERROR:  Please enter a valid email address');
		document.survey.email.focus();		
		return false;
		}
	}	

function valRange(btn) 
	{
    var cnt = -1;
    for (var i=btn.length-1; i > -1; i--) 
		{
        if (btn[i].checked) {cnt = i; i = -1;
		}
    }
    if (cnt > -1) return btn[cnt].value;
    else return null;
}

function valRadios(form)
{
	var btn = valRange(form.age);
	if (btn == null)
	  { 
	  alert('ERROR:  No age range was selected');
	  return false;
	  }
	else{
	  return valRadios2(form);}
}

  // Original JavaScript code by Chirp Internet: www.chirp.com.au
  // Please acknowledge use of this code by including this header. 
function checkArray(form, arrayName)
  {
    var retval = new Array();
    for(var i=0; i < form.elements.length; i++) {
      var el = form.elements[i];
      if(el.type == "checkbox" && el.name == arrayName && el.checked) {
        retval.push(el.value);
      }
    }
    return retval;
  }
 
function checkForm4(form)
  {
    var itemsChecked = checkArray(form, "me");
    if(itemsChecked.length < 1) {
	  alert("ERROR:  Please select one or more of the checkboxes");
	  return false;
	}
    else if(itemsChecked.length > 0) {
      alert("Thank you for helping us serve you better");
    }
  }


//here you place the ids of every element you want.
var ids=new Array('yes','no');

function switchid(id){	
	hideallids();
	showdiv(id);
}

function hideallids(){
	//loop through the array and hide each element by id
	for (var i=0;i<ids.length;i++){
		hidediv(ids[i]);
	}		  
}

function hidediv(id) {
	//safe function to hide an element with a specified id
	if (document.getElementById) { // DOM3 = IE5, NS6
		document.getElementById(id).style.display = 'none';
	}
	else {
		if (document.layers) { // Netscape 4
			document.id.display = 'none';
		}
		else { // IE 4
			document.all.id.style.display = 'none';
		}
	}
}

function showdiv(id) {
	//safe function to show an element with a specified id
		  
	if (document.getElementById) { // DOM3 = IE5, NS6
		document.getElementById(id).style.display = 'block';
	}
	else {
		if (document.layers) { // Netscape 4
			document.id.display = 'block';
		}
		else { // IE 4
			document.all.id.style.display = 'block';
		}
	}
}
