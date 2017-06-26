/**
 * 
 */

function memoView(num) {
	$.get("memoView?num="+num, function(data) {
		alert(data.writer);
		
	})
	
}

function memoWrite(writer,contents){
	
	$.ajax({
		url: "memoWrite",
		type:"POST",
		data:{
			writer:writer,
			contents:contents
		},
		success:function(data){
			$("#result").html(data);
			
		}
		
		
	})
}
function getList(curPage, find, search) {
	/* $.get("URL?parameter=val",function(data){
	}); */
	/* $.post("URL",{
		parameter: val
	},function(data){}); */
	$.ajax({
		url:"getMemoList",
		type:"GET",
		data:{
			curPage:curPage,
			find:find,
			search:search
		},
		success:function(data){
			
			
			
			var result = "<table>";
			$(data).each(function() {
				result = result + "<tr>";
				result = result +"<td>"+ this.num+"</td>";
				result = result +"<td>"+ this.contents+"</td>";
				result = result +"<td>"+ this.writer+"</td>";
				result = result +"<td>"+ this.reg_date+"</td>";
				result = result + "</tr>";
				
			});
			
			$("#result").html(result);
		}
	});
	/* $("#result").load() */
}