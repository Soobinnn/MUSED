<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<title>개인 정보 수정</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script language="javascript">
	function check() {
		var upda = document.update_form;
		if (upda.password.value == "") {
			alert("비밀번호를 입력해주십시오.");
			upda.password.focus();
			return false;
		}
		if (upda.password.value != upda.password2.value) {
			alert("비밀번호가 다릅니다.");
			upda.password2.focus();
			return false;
		}
		if (upda.email.value == "") {
			alert("이메일을 입력해주십시오.");
			upda.email.focus();
			return false;
		}
		if (frm.zipcode.value == "") {
			alert("우편번호를 입력해주십시오.");
			frm.zipcode.focus();
			return false;
		}
		if (frm.address1.value == "") {
			alert("주소를 입력해주십시오.");
			frm.address1.focus();
			return false;
		}
		if (frm.address2.value == "") {
			alert("상세주소를 입력해주십시오.");
			frm.address2.focus();
			return false;
		}
	}

	function DaumPostcode() {

		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('address1').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('address2').focus();
					}
				}).open();
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<center>
	<body>
		<h1>개인정보수정</h1>
		<br />
		<br />
		<form action="memberUpdateAction.action" name="update_form"
			method="post" onsubmit="return check()">

			<table>
				<tr>
					<td>Name</td>
					<td>&nbsp;<s:textfield name="name" theme="simple"
							value="%{resultClass.name}" readonly="true" /></td>
				</tr>
				<tr>
					<td>ID</td>
					<td>&nbsp;<s:textfield name="id" theme="simple"
							value="%{resultClass.id}" readonly="true" /></td>
				</tr>
				<tr>
					<td>Reg Number</td>
					<td>&nbsp;<s:textfield name="jumin1" theme="simple"
							value="%{resultClass.jumin1}" cssStyle="width:70px" maxlength="6"
							readonly="true" />&nbsp;-&nbsp; <s:textfield name="jumin2"
							theme="simple" value="%{resultClass.jumin2}"
							cssStyle="width:70px" maxlength="7" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>Sex</td>
					<td><input type="radio" name="sex" value="M" checked>&nbsp;Male
						<input type="radio" name="sex" value="F">&nbsp;Female</td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type="text" id="email" name="email"
						value="${resultClass.email}" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" id="phone" name="phone"
						value="${resultClass.phone}" /></td>
				</tr>
				<tr>
					<td>Zipcode</td>&nbsp;
					<td><input type="text" name="zipcode" id="zipcode" size="7"
						value="${resultClass.zipcode}" />&nbsp; <input type="button"
						value="Search" onclick="DaumPostcode()"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" id="address1" name="address1"
						placeholder="주소" size="50" value="${resultClass.address1}" /><br>
						<input type="text" id="address2" name="address2"
						placeholder="상세주소" size="50" value="${resultClass.address2}" /></td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input type="submit" value="변경">&nbsp;
						<input type="button" value="취소"
						onclick="javascript:history.back(-1)"></td>
				</tr>
			</table>
		</form>
	</body>

</html>