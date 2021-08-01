/*
 * creates a new XMLHttpRequest object which is the backbone of AJAX,
 * or returns false if the browser doesn't support it
 */
function getXMLHttpRequest()
{
  var xmlHttpReq = false;
  // to create XMLHttpRequest object in non-Microsoft browsers
  if (window.XMLHttpRequest) {
    xmlHttpReq = new XMLHttpRequest();
  } else if (window.ActiveXObject) {
    try {
      // to create XMLHttpRequest object in later versions
      // of Internet Explorer
      xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (exp1) {
      try {
        // to create XMLHttpRequest object in older versions
        // of Internet Explorer
        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
      } catch (exp2) {
        xmlHttpReq = false;
      }
    }
  }
  return xmlHttpReq;
}
/*
 * AJAX call starts with this function
 */
function makeRequest(str)
{
	  var xmlHttpRequest = getXMLHttpRequest();
	  xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);
	  xmlHttpRequest.open("GET",str,true);
	  xmlHttpRequest.send();
}
 
/*
 * Returns a function that waits for the state change in XMLHttpRequest
 */
function getReadyStateHandler(xmlHttpRequest) {
  // an anonymous function returned
  // it listens to the XMLHttpRequest instance
  return function() {
	  
    if (xmlHttpRequest.readyState == 4) {
      if (xmlHttpRequest.status == 200) {
    	  if((xmlHttpRequest.responseText).indexOf("pincodeajax") > -1)
		  {
    		  var res = xmlHttpRequest.responseText.split("&");
	    	  var pinc = document.getElementById("pincodeid");
	    	  var statec = document.getElementById("stateid");
	    	  pinc.value=res[0];
	    	  statec.value=res[1];
    	  }
    	  else
    		  if((xmlHttpRequest.responseText).indexOf("accntinfoajax") > -1)
			  {
    			var res = xmlHttpRequest.responseText.split("&");
			  	var r1=document.getElementById("firstbankholdernamesid");
			  	var r2=document.getElementById("firstamounttextid");
			  	var r3=document.getElementById("firstphonetextid");
			  	var r4=document.getElementById("firstmailtextid");
			  	var r5=document.getElementById("firstaddresstextid");
			  	var r6=document.getElementById("firstcitytextid");
			  	var r7=document.getElementById("firstpincodetextid");
			  	var r8=document.getElementById("firststatetextid");
			  	r1.value=res[1];
			  	r2.value=res[2];
			  	r3.value=res[3];
			  	r4.value=res[4];
			  	r5.value=res[5];
			  	r6.value=res[6];
			  	r7.value=res[7];
			  	r8.value=res[8];
			  }
    	  else
    		  if((xmlHttpRequest.responseText).indexOf("addamountinfoajax") > -1)
			  {
    			  var res = xmlHttpRequest.responseText.split("&");
    			 	var r1=document.getElementById("addamountaccountnameid");
    			  r1.value=res[1];
			  }    		  
    	  
      } else {
        alert("HTTP error " + xmlHttpRequest.status + ": " + xmlHttpRequest.statusText);
      }
    }
  };
}