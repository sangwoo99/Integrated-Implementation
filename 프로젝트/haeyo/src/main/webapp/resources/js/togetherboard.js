function insertReply(){
		var replyData = $('#t_replyForm').serialize();
		console.log(replyData);
		$.ajax({
			url:"t_insertSelectReply.do",
			type: "GET",
			data: replyData,
			contentType : "application/json; charset=UTF-8",
			dataType: "json",
			success: function(TogetherReplyVO){
				console.log(TogetherReplyVO);
				result="<tr>"
					+"<td>"+TogetherReplyVO.uPic+"</td>"
					+"<td>"+TogetherReplyVO.uNick+"</td>"
					+"<td>"+TogetherReplyVO.trContent+"</td>"
					+"<td>"+TogetherReplyVO.trCredate+"</td>"
					+"<td><button class='heayo_btn' onclick='updateReply();'>수정</button></td>"
					+"<td><button class='heayo_btn' onclick='deleteReply(${Reply.trNo},${Reply.tNo});'>삭제</button></td>"
					+"</tr>"
				$('#t_replyTable').append(result);
			}
		});
}

//function getReply(){
//	var replyData = $('#t_replyForm').serialize();
//	console.log(replyData);
//	$.ajax({
//		url:"t_insertSelectReply.do",
//		type: "GET",
//		data: replyData,
//		contentType : "application/json; charset=UTF-8",
//		dataType: "json",
//		success: function(TogetherReplyVO){
//			console.log(TogetherReplyVO);
//			result="<tr>"
//				+"<td>"+TogetherReplyVO.uPic+"</td>"
//				+"<td>"+TogetherReplyVO.uNick+"</td>"
//				+"<td>"+TogetherReplyVO.trContent+"</td>"
//				+"<td>"+TogetherReplyVO.trCredate+"</td>"
//				+"</tr>"
//			$('#t_replyTable').append(result);
//		}
//	});
//}

function deleteReply(trNo, tno){
//	var replyNo = $('#tJoinNow').value();
	var replyData = {"trNo":trNo, "tno":tno}
	console.log(replyData);
	$.ajax({
		url:"t_deleteReply.do",
		type: "GET",
		contentType : "application/json; charset=UTF-8",
		data: replyData,
		dataType: "json",
		success: function(data){
			console.log(data);
			t_reply_content = "<tr><td>"+data.userVO.uPic+"</td>"
				+"<th>"+data.userVO.uNick+"</th>"
				+"<td>"+data.trContent+"</td>"
				+"<td>"+data.trCredate+"</td>"
				+"<td><button class='heayo_btn' onclick='updateReply();'>수정</button></td>"
				+"<td><button class='heayo_btn' onclick='deleteReply(${Reply.trNo},${Reply.tNo});'>삭제</button></td>"
			$('#t_reply_content').html(t_reply_content);
		}
	});
}

//function editReply(){
//	var replyUpdateData = $('#tJoinNow').value();
//	
//	updateReplyInput = "<td>${Reply.userVO.uPic}</td>"
//					+"<th>${Reply.userVO.uNick}</th>"
//					+"<td><input type='text' id='updateTrContent'"
//					+"name='updateTrContent' value='"+data.+"'></td>"
//					+"<td>${Reply.trCredate}</td>"
//					+"<td><button class='heayo_btn' onclick='insertReply();'>등록</button></a></td>"
//					+"<td><button class='heayo_btn' onclick='deleteReply();'>삭제</button></a></td>"
//	$('#').replaceWith(updateReplyInput);
//	
//}


function updateReply(trNo, tno){
//	var replyNo = $('#tJoinNow').value();
	var replyData = {"trNo":trNo, "tno":tno}
	console.log(replyData);
	$.ajax({
		url:"t_deleteReply.do",
		type: "GET",
		contentType : "application/json; charset=UTF-8",
		data: replyData,
		success: function(data){
			console.log(data);
			t_reply_content = "<tr><td>"+data.userVO.uPic+"</td>"
				+"<th>"+data.userVO.uNick+"</th>"
				+"<td>"+data.trContent+"</td>"
				+"<td>"+data.trCredate+"</td>"
				+"<td><button class='heayo_btn' onclick='updateReply();'>수정</button></td>"
				+"<td><button class='heayo_btn' onclick='deleteReply(${Reply.trNo},${Reply.tNo});'>삭제</button></td>"
			$('#t_reply_content').html(t_reply_content);
		}
	});
}






//function tJoin(){
//	var joinData = $('#tJoinNow').value();
//	console.log(joinData);
//	$.ajax({
//		url:"t_updateJoinNow.do",
//		type: "GET",
//		data: joinData,
//		success: function(data){
//			console.log(data);
//			$().html(data);
//		}
//	});
//}
