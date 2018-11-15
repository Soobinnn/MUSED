<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h2>상품관리</h2><br>
<input type="button" value="등록된 상품" onclick="javascript:location.href='myProduct.action'"><br>
<input type="button" value="등록된 재능" onclick="javascript:location.href='myTalent.action'"><br>
<input type="button" value="최근본 상품" onclick="javascript:location.href='myRecent.action'"><br>
<input type="button" value="찜한 상품" onclick="javascript:location.href='myZzim.action'"><br>
<input type="button" value="판매 내역" onclick="javascript:location.href='mySell.action'"><br>
<h2>쪽지</h2><br>
<input type="button" value="쪽지 보내기" onclick="javascript:location.href='sendMessageForm.action'"><br>
<input type="button" value="받은 쪽지" onclick="javascript:location.href='receivedMessage.action?check=0'"><br>
<input type="button" value="보낸 쪽지" onclick="javascript:location.href='sendedMessage.action?check=1'"><br>
<h2>댓글</h2><br>
<input type="button" value="내가 쓴 댓글" onclick="javascript:location.href='myComment.action'"><br>
<input type="button" value="내 게시글 댓글" onclick="javascript:location.href='myBoardComment.action'"><br> 
<h2>개인정보 관리</h2>
<input type="button" value="개인정보수정" onclick="javascript:location.href='memberUpdateForm.action'"><br>
<input type="button" value="비밀번호변경" onclick="javascript:location.href='modifyPwForm.action'"><br>
<input type="button" value="회원 탈퇴" onclick="javascript:location.href='memberDeleteForm.action'"><br>

</body>
</html>