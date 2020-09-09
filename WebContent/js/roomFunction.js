var detailName = document.getElementById('detailRoomName');
	var detailID = document.getElementById('detailRoomID');
	var detailPrice = document.getElementById('detailRoomPrice');
	var detailStatus = document.getElementById('detailRoomStatus');
	var detailNote = document.getElementById('detailRoomNote');
	var detailImage = document.getElementById('detailRoomImage');
  var addButton = document.getElementById('addRoom');
  var detailButton = document.getElementById('roomDetail');
  var addRoomDialog = document.getElementById('addRoomDialog');
  var roomDetailDialog = document.getElementById('roomDetailDialog');
  addButton.addEventListener('click', function onOpen() {
	  if (typeof addRoomDialog.showModal === "function") {
		  addRoomDialog.showModal();
	  } else {
	    alert("The <dialog> API is not supported by this browser");
	  }
  });
  
  function openDialog()
{
document.getElementById("file1").click();
}
  function showDetails(button) {
		
		var ajaxdata = button.value;
	     var value ='id='+ajaxdata;
	     var responseText = '';
	     $.ajax({
	         url: 'roomDetail',
	         type: "GET",
	         dataType: 'json',
	         data: value,
	         success: function(roomDetail) {
	        	 var data1=roomDetail[0], data2=roomDetail[1];
	        	 detailID.value = data2.roomID;
	        	 detailName.value = data2.roomName;
	        	 detailPrice.value = data2.roomPrice;
	        	 detailStatus.value = data2.roomStatus;
	        	 detailNote.value = data2.roomNote;
				 $("#detailRoomImage").attr('src','data:image/jpeg;base64,'+ data2.roomImage64);
	        	 $.each(data1, function(i, value) {
	                 $('#roomType').append($('<option class="dropdown-item">').text(value.rtName).attr('value', value.rtID));
	                 if(value.rtID==data2.rt.rtID){
	                	 $("#roomType > [value=" + value.rtID + "]").attr("selected", "true");
	                 }
	             });
	            }
	         });
	     roomDetailDialog.showModal();
}




