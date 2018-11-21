
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<section class="mypage_nav">
	<ul><h2>상품관리</h2><hr/>
		<li><input id="mypage_nav1" type="button" value="등록된 상품" onclick="javascript:location.href='myProduct.action'"></li>
		<li><input id="mypage_nav2" type="button" value="등록된 재능" onclick="javascript:location.href='myTalent.action'"></li>
		<li><input id="mypage_nav3" type="button" value="찜한 상품" onclick="javascript:location.href='myZzimProduct.action'"></li>
		<li><input id="mypage_nav4" type="button" value="찜한 재능" onclick="javascript:location.href='myZzimTalent.action'"></li>
	</ul>
	<ul><h2>판매내역</h2><hr/>
		<li><input id="mypage_nav5" type="button" value="제품 판매 내역" onclick="javascript:location.href='mySellProduct.action'"></li>
		<li><input id="mypage_nav6" type="button" value="재능 판매 내역" onclick="javascript:location.href='mySellTalent.action'"></li>
	</ul>
	<ul><h2>쪽지</h2><hr/>	
		<li><input id="mypage_nav7" type="button" value="쪽지 보내기" onclick="javascript:location.href='sendMessageForm.action'"></li>
		<li><input id="mypage_nav8" type="button" value="받은 쪽지" onclick="javascript:location.href='receivedMessage.action?check=0'"></li>
		<li><input id="mypage_nav9" type="button" value="보낸 쪽지" onclick="javascript:location.href='sendedMessage.action?check=1'"></li>
	</ul>
	<ul><h2>개인정보 관리</h2><hr/>
		<li><input id="mypage_nav10" type="button" value="개인정보수정" onclick="javascript:location.href='memberUpdateForm.action'"></li>
		<li><input id="mypage_nav11" type="button" value="비밀번호변경" onclick="javascript:location.href='modifyPwForm.action'"></li>
		<li><input id="mypage_nav12" type="button" value="회원 탈퇴" onclick="javascript:location.href='memberDeleteForm.action'"></li>
	</ul>
</section>

</body>
</html>