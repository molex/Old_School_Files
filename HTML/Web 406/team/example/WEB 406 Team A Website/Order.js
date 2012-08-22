function dm(amount) 
{
  string = "" + amount;
  dec = string.length - string.indexOf('.');
  if (string.indexOf('.') == -1)
  return string + '.00';
  if (dec == 1)
  return string + '00';
  if (dec == 2)
  return string + '0';
  if (dec > 3)
  return string.substring(0,string.length-dec+3);
  return string;
}



function calculate()
{

  QtyA = 0;  QtyB = 0;  QtyC = 0; QtyD = 0; QtyE = 0; QtyF = 0; QtyG = 0; QtyH = 0; QtyI = 0; QtyJ = 0; QtyS = 0;
  TotA = 0;  TotB = 0;  TotC = 0; TotD = 0; TotE = 0; TotF = 0; TotG = 0; TotH = 0; TotI = 0; TotJ = 0; TotS = 0;


  PrcA = 800.00; PrcB = 225.00; PrcC = 49.00; PrcD = 25.00; PrcE = 12.00; PrcF = 31.00;
  PrcG = 19.00; PrcH = 15.00; PrcI = 11.00; PrcJ = 9.00; PrcS = 6.95; 

 
 
  if (document.ofrm.qtyA.value > "")
     { QtyA = document.ofrm.qtyA.value };
  document.ofrm.qtyA.value = eval(QtyA);  
 
  if (document.ofrm.qtyB.value > "")
     { QtyB = document.ofrm.qtyB.value };
  document.ofrm.qtyB.value = eval(QtyB);  
 
  if (document.ofrm.qtyC.value > "")
     { QtyC = document.ofrm.qtyC.value };
  document.ofrm.qtyC.value = eval(QtyC);

  if (document.ofrm.qtyD.value > "")
     { QtyD = document.ofrm.qtyD.value };
  document.ofrm.qtyD.value = eval(QtyD);
 
  if (document.ofrm.qtyE.value > "")
     { QtyE = document.ofrm.qtyE.value };
  document.ofrm.qtyE.value = eval(QtyE);

  if (document.ofrm.qtyF.value > "")
     { QtyF = document.ofrm.qtyF.value };
  document.ofrm.qtyF.value = eval(QtyF);

  if (document.ofrm.qtyG.value > "")
     { QtyG = document.ofrm.qtyG.value };
  document.ofrm.qtyG.value = eval(QtyG);

  if (document.ofrm.qtyH.value > "")
     { QtyH = document.ofrm.qtyH.value };
  document.ofrm.qtyH.value = eval(QtyH);

  if (document.ofrm.qtyI.value > "")
     { QtyI = document.ofrm.qtyI.value };
  document.ofrm.qtyI.value = eval(QtyI);

  if (document.ofrm.qtyJ.value > "")
     { QtyJ = document.ofrm.qtyJ.value };
  document.ofrm.qtyJ.value = eval(QtyJ);

  if (document.ofrm.qtyS.value > "")
     { QtyS = document.ofrm.qtyS.value };
  document.ofrm.qtyS.value = eval(QtyS);


  TotA = QtyA * PrcA;
  document.ofrm.totalA.value = dm(eval(TotA));
 
  TotB = QtyB * PrcB;
  document.ofrm.totalB.value = dm(eval(TotB));
 
  TotC = QtyC * PrcC;
  document.ofrm.totalC.value = dm(eval(TotC));

  TotD = QtyD * PrcD;
  document.ofrm.totalD.value = dm(eval(TotD));

  TotE = QtyE * PrcE;
  document.ofrm.totalE.value = dm(eval(TotE));

  TotF = QtyF * PrcF;
  document.ofrm.totalF.value = dm(eval(TotF));

  TotG = QtyG * PrcG;
  document.ofrm.totalG.value = dm(eval(TotG));

  TotH = QtyH * PrcH;
  document.ofrm.totalH.value = dm(eval(TotH));
 
  TotI = QtyI * PrcI;
  document.ofrm.totalI.value = dm(eval(TotI));

  TotJ = QtyJ * PrcJ;
  document.ofrm.totalJ.value = dm(eval(TotJ));

  TotS = QtyS * PrcS;
  document.ofrm.totalS.value = dm(eval(TotS));

 
  Totamt = 
     eval(TotA) +
     eval(TotB) +
     eval(TotC) +
     eval(TotD) +
     eval(TotE) +
     eval(TotF) +
     eval(TotG) +
     eval(TotH) +
     eval(TotI) +
     eval(TotJ) +
     eval(TotS) ;

  document.ofrm.GrandTotal.value = dm(eval(Totamt));
  
} 



function getCookie(c_name)
{
if (document.cookie.length>0)
  {
  c_start=document.cookie.indexOf(c_name + "=");
  if (c_start!=-1)
    { 
    c_start=c_start + c_name.length+1; 
    c_end=document.cookie.indexOf(";",c_start);
    if (c_end==-1) c_end=document.cookie.length;
    return unescape(document.cookie.substring(c_start,c_end));
    } 
  }
return "";
} 

function setCookie(c_name,value,expiredays){
     exdate=new Date();
     exdate.setDate(exdate.getDate()+expiredays);
     document.cookie=c_name+ "=" +escape(value)+ ((expiredays==null) ? "" : 

";expires="+exdate.toGMTString());
}

function checkCookie()
{
username=getCookie('username');
if (username!=null && username!=""){

setTimeout('this.document.location.href="FormSubmittedAlready.html"')
}
else
{
  username=1;
     if (username!=null && username!=""){
     setCookie('username',username ,1);
}
}
}


function validate_required(field,alerttxt)
{
with (field)
{
if (value==null||value=="")
  {alert(alerttxt);return false;}
else {return true}
	}
}


function validate_form(thisform)
{
with (thisform)
{
if (validate_required(CC_Number,"Credit Card must be filled out!")==false)
  {CC_Number.focus();return false;}

if (validate_required(First_Name,"First Name must be filled out!")==false)
  {Address.focus();return false;}

if (validate_required(Last_Name,"Last Name must be filled out!")==false)
  {Address.focus();return false;}

if (validate_required(Address,"Address must be filled out!")==false)
  {Address.focus();return false;}

if (validate_required(City,"City must be filled out!")==false)
  {Address.focus();return false;}

if (validate_required(State,"State must be filled out!")==false)
  {Address.focus();return false;}

if (validate_required(Zip,"Zip Code must be filled out!")==false)
  {Address.focus();return false;}

if (validate_required(Email,"Email must be filled out!")==false)
  {Email.focus();return false;}

if (validate_required(Phone,"Phone Number must be filled out!")==false)
  {Email.focus();return false;}

}
return true;
}

function confirmReset() {
     var resetForm = window.confirm("Are you sure you want to clear the form?");
     if (resetForm == true)
           return true;
     return false;
}

function formRedirect(){
   setTimeout('this.document.location.href="FormSubmitted.html"',2000)

}


function checkEmail() {
     var Email = document.forms[0].Email.value;
     if (Email.indexOf("@") == -1) {
           window.alert("Enter a valid Email address!");
           return false;
} 
}

