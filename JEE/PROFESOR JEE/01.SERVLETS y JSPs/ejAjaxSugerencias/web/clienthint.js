/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var xmlHttp

function showHint(str)
{
    if (str.length == 0)
    {
        document.getElementById("txtHint").innerHTML = "";
        return;
    }
    xmlHttp = GetXmlHttpObject();
    if (xmlHttp == null)
    {
        alert("Your browser does not support AJAX!");
        return;
    }
    var url = "MiServlet";
    url = url + "?q=" + str;
    xmlHttp.onreadystatechange = stateChanged;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
}

function stateChanged()
{
    if (xmlHttp.readyState == 4)
    {
        document.getElementById("txtHint").innerHTML = xmlHttp.responseText;
    }
}
function GetXmlHttpObject() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}