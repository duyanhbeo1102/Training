var btnGetData = document.getElementById('btnGetData');
var txtLinkData = document.getElementById('jsonLink');
function showDetails(button) {
		
		var xhr = new XMLHttpRequest();
xhr.open("GET", txtLinkData.value, true);
xhr.onload = function(){
    console.log(xhr.responseText);
$.ajax({
                url :  'jsonTraining',
                type : 'POST',
                data : 'jsondata='+xhr.responseText,
                cache : false,
                dataType : 'json',
                processData : false,
                contentType : false,
                success : function(data, textStatus, jqXHR) {
                    alert(xhr.responseText);
                },
                error : function(jqXHR, textStatus, errorThrown) {
                    alert('ERRORS: ' + textStatus);
                }
            });
};
xhr.send();
}
