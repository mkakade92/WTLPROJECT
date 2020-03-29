/**
 * 
 */


$(document).ready(function() {
	$('#viewG').click(function() {
		console.log("in the click function");
//		var user = "${sessionScope.uname}";
//		console.log(user);
		$.ajax({
			url : 'ViewGrievance',
			type: "GET",
			dataType:"json",
			contentType: 'application/json',
			mimeType: 'application/json',
			success : function(response) {
				var th="<tr><th>Title</th><th>Description</th></tr>";
				$('#GrievanceTable').append(th);
				$.each(response, function(i,item){
						console.log(item.title);
						var $tr=$('<tr>').append(
						$('<td>').text(item.title),
						$('<td>').text(item.grievance)
					).appendTo('#GrievanceTable');
			        console.log($tr.wrap('<p>').html());
				});
			},
			error:function()
			{
				var errormsg="Data could not be retrived.Sorry :(";
				$('#GrievanceTable').append(errormsg);
			}
		});
	});
});
