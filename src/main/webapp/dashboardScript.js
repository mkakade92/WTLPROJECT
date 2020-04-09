



$(document).ready(function() {
	$('#viewG').click(function() {
		console.log("abcd");
		$(".displayGrievance").empty();
		var tabid="GrievanceTable";
		$(".displayGrievance").append("<table id="+tabid+"><thead></thead><tbody></tbody></table>");
		var th='<tr><th>ID</th><th>Title</th><th>Description</th><th>Delete</th></tr>'
		$("#"+tabid+" thead").append(th);
//		var user = "${sessionScope.uname}";
//		console.log(user);
		$.ajax({
			url : 'ViewGrievance',
			type: "GET",
			dataType:"json",
			contentType: 'application/json',
			mimeType: 'application/json',
			success : function(response) {
				$.each(response, function(i,item){
						var id=item.id;
						var title=item.title;
						var desc=item.grievance;
						var button="<input class=\"deleteBtn\" type=\"button\" value=\"Delete\" id="+id+">";
						console.log(title+desc);
						var trId="<td>"+(i+1)+"</td>";
						var trTitle="<td>"+title+"</td>";
						var trDesc="<td>"+desc+"</td>";
						var trBtn="<td>"+button+"</td>";
						var tr="<tr>"+trId+trTitle+trDesc+trBtn+"</tr>";
						$("#"+tabid+" tbody").append(tr);
//			        console.log(tr);
				});

			},
			error:function()
			{
				var errormsg="Data could not be retrived.Sorry :(";
				$("#UploadSuccessMsg").append("<p><h2>"+succesMesg+"</h2></p>");
			}
		});
	});

	$('#GrievanceTable').on('click','.deleteBtn',function()
			{ 
//			console.log("a;ksjd;lasd");		
			var id=this.id;
//			console.log("ID is : "+id);
			$.ajax({
				url : 'DeleteGrievance',
				type: "GET",
				data:{id:id},
				cache:false,
				success : function(response) {	
					$(this).closest("tr").remove();
					}			
				});
			});
});
