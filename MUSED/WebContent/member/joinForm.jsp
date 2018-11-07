<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>회원가입</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script language="javascript">
	function check() {

		var frm = document.join_form;
		var check = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{6,12}$/;
			
		if (frm.name.value == "") {
			alert("이름을 입력해주십시오.");
			frm.name.focus();
			return false;
		}
		if (frm.id.value == "") {
			alert("아이디를 입력해주십시오.");
			frm.id.focus();
			return false;
		}
		if (frm.password.value == "") {
			alert("비밀번호를 입력해주십시오.");
			frm.password.focus();
			return false;
		}
		if(frm.password.value.length < 6 || frm.password.value.length > 12) {
			alert("암호를 6 ~ 12자 이하로 설정해주세요.");
			return false;
		}
		if(!check.test(frm.password.value)) {
			alert("영문, 숫자, 특수문자 조합으로 입력해주세요.");
			return false;
		}
		if (frm.password.value != frm.password2.value) {
			alert("비밀번호가 다릅니다.");
			frm.password2.select();
			return false;
		}
		if (frm.jumin1.value == "") {
			alert("주민등록번호를 입력해주십시오.");
			frm.jumin1.focus();
			return false;
		}
		if (frm.jumin2.value == "") {
			alert("주민등록번호를 입력해주십시오.");
			frm.jumin2.focus();
			return false;
		}
		if (frm.sex[0].checked == false && frm.sex[1].checked == false) {
			alert("성별을 선택해주십시오.");
			return false;
		}
		if (frm.email.value == "") {
			alert("이메일을 입력해주십시오.");
			frm.email.focus();
			return false;
		}
		if (frm.phone.value == "") {
			alert("본인인증을 해주세요.");
			frm.phone.focus();
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
		if (frm.idCheckOn.value == 0) {
			alert("아이디 중복확인을 해주세요.");
			frm.id.focus();
			return false;
		}
	}

	function openConfirmId(joinform) {
		var id = join_form.id.value;
		var url = "checkIdAction.action?id=" + id;

		join_form.idCheckOn.value = 1;

		if (id.length == 0) {
			alert("아이디를 입력하십시오.");
			join_form.id.focus();
			return false;
		}
		if (document.join_form.id.value.length < 4) {
			alert("최소 4자리 이상 입력해주세요!");
			chk.M_ID.focus();
			return false;
		}

		open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"
				+ "scrollbars=no,resizable=no,width=400,height=200");
	}

	function authCheckForm(authform) {
		var url = "authCheckForm.action";

		open(url, "authcheck", "toolbar=no,location=no,status=no,menubar=no,"
				+ "scrollbars=no,resizable=no,width=400,height=200");
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
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
</head>
<center>
	<body>

		<h1>Join Us</h1>
		<br />
		<br />
		<form name="join_form" action="joinAction.action" method="post"
			onsubmit="return check()" enctype="multipart/form-data">
			<input type="hidden" name="idCheckOn" value="0" />
			<table>

				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Name</td>
					<td>&nbsp;<s:textfield name="name" theme="simple" /></td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">ID</td>
					<td>&nbsp;<s:textfield name="id" theme="simple" />&nbsp; <input
						type="button" name="confirm_id" value="Check"
						onclick="openConfirmId(this.form)" />
					</td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Password</td>
					<td>&nbsp;<s:password name="password" theme="simple" />
						영문/숫자/특수문자를 이용하여 6~12자
					</td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Confirm</td>
					<td>&nbsp;<input type="password" name="password2"
						placeholder="비밀번호 확인" /></td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Jumin
						Num</td>
					<td>&nbsp;<s:textfield name="jumin1" theme="simple"
							cssStyle="width:70px" maxlength="6" />&nbsp;-&nbsp; <s:password
							name="jumin2" theme="simple" cssStyle="width:70px" maxlength="7" />
					</td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Sex</td>
					<td><input type="radio" name="sex" value="M">&nbsp;Male
						<input type="radio" name="sex" value="F">&nbsp;Female</td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">E-mail</td>
					<td><input type="text" id="email" name="email"
						placeholder="이메일을 입력해주세요." /></td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Phone</td>
					<td><input type="text" id="phone" name="phone"
						placeholder="본인인증을 해주세요." readOnly /> &nbsp; <input type="button"
						value="본인인증" onclick="authCheckForm(this.form)"></td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Zipcode</td>&nbsp;
					<td><input type="text" name="zipcode" id="zipcode" size="7"
						placeholder="우편번호" />&nbsp; <input type="button" value="Search"
						onclick="DaumPostcode()"></td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Address</td>
					&nbsp;
					<td><input type="text" id="address1" name="address1"
						placeholder="주소" size="50" /><br> <input type="text"
						id="address2" name="address2" placeholder="상세주소" size="50" /></td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input type="submit" value="Join">&nbsp;<input
						type="button" value="Cancle"
						onclick="location.href='loginForm.action'"></td>

				</tr>
			</table>
	</body>
</center>
</html>