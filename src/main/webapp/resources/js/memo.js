/**
 * 
 */
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
			$("#result").html(data);
		}
	});
	/* $("#result").load() */
}