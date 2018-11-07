<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ȸ������</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script language="javascript">
	function check() {

		var frm = document.join_form;
		var check = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{6,12}$/;
			
		if (frm.name.value == "") {
			alert("�̸��� �Է����ֽʽÿ�.");
			frm.name.focus();
			return false;
		}
		if (frm.id.value == "") {
			alert("���̵� �Է����ֽʽÿ�.");
			frm.id.focus();
			return false;
		}
		if (frm.password.value == "") {
			alert("��й�ȣ�� �Է����ֽʽÿ�.");
			frm.password.focus();
			return false;
		}
		if(frm.password.value.length < 6 || frm.password.value.length > 12) {
			alert("��ȣ�� 6 ~ 12�� ���Ϸ� �������ּ���.");
			return false;
		}
		if(!check.test(frm.password.value)) {
			alert("����, ����, Ư������ �������� �Է����ּ���.");
			return false;
		}
		if (frm.password.value != frm.password2.value) {
			alert("��й�ȣ�� �ٸ��ϴ�.");
			frm.password2.select();
			return false;
		}
		if (frm.jumin1.value == "") {
			alert("�ֹε�Ϲ�ȣ�� �Է����ֽʽÿ�.");
			frm.jumin1.focus();
			return false;
		}
		if (frm.jumin2.value == "") {
			alert("�ֹε�Ϲ�ȣ�� �Է����ֽʽÿ�.");
			frm.jumin2.focus();
			return false;
		}
		if (frm.sex[0].checked == false && frm.sex[1].checked == false) {
			alert("������ �������ֽʽÿ�.");
			return false;
		}
		if (frm.email.value == "") {
			alert("�̸����� �Է����ֽʽÿ�.");
			frm.email.focus();
			return false;
		}
		if (frm.phone.value == "") {
			alert("���������� ���ּ���.");
			frm.phone.focus();
			return false;
		}
		if (frm.zipcode.value == "") {
			alert("�����ȣ�� �Է����ֽʽÿ�.");
			frm.zipcode.focus();
			return false;
		}
		if (frm.address1.value == "") {
			alert("�ּҸ� �Է����ֽʽÿ�.");
			frm.address1.focus();
			return false;
		}
		if (frm.address2.value == "") {
			alert("���ּҸ� �Է����ֽʽÿ�.");
			frm.address2.focus();
			return false;
		}
		if (frm.idCheckOn.value == 0) {
			alert("���̵� �ߺ�Ȯ���� ���ּ���.");
			frm.id.focus();
			return false;
		}
	}

	function openConfirmId(joinform) {
		var id = join_form.id.value;
		var url = "checkIdAction.action?id=" + id;

		join_form.idCheckOn.value = 1;

		if (id.length == 0) {
			alert("���̵� �Է��Ͻʽÿ�.");
			join_form.id.focus();
			return false;
		}
		if (document.join_form.id.value.length < 4) {
			alert("�ּ� 4�ڸ� �̻� �Է����ּ���!");
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
						// �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

						// �� �ּ��� ���� ��Ģ�� ���� �ּҸ� �����Ѵ�.
						// �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
						var fullAddr = ''; // ���� �ּ� ����
						var extraAddr = ''; // ������ �ּ� ����

						// ����ڰ� ������ �ּ� Ÿ�Կ� ���� �ش� �ּ� ���� �����´�.
						if (data.userSelectedType === 'R') { // ����ڰ� ���θ� �ּҸ� �������� ���
							fullAddr = data.roadAddress;

						} else { // ����ڰ� ���� �ּҸ� �������� ���(J)
							fullAddr = data.jibunAddress;
						}

						// ����ڰ� ������ �ּҰ� ���θ� Ÿ���϶� �����Ѵ�.
						if (data.userSelectedType === 'R') {
							//���������� ���� ��� �߰��Ѵ�.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// �ǹ����� ���� ��� �߰��Ѵ�.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// �������ּ��� ������ ���� ���ʿ� ��ȣ�� �߰��Ͽ� ���� �ּҸ� �����.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
						document.getElementById('zipcode').value = data.zonecode; //5�ڸ� �������ȣ ���
						document.getElementById('address1').value = fullAddr;

						// Ŀ���� ���ּ� �ʵ�� �̵��Ѵ�.
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
						����/����/Ư�����ڸ� �̿��Ͽ� 6~12��
					</td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Confirm</td>
					<td>&nbsp;<input type="password" name="password2"
						placeholder="��й�ȣ Ȯ��" /></td>
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
						placeholder="�̸����� �Է����ּ���." /></td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Phone</td>
					<td><input type="text" id="phone" name="phone"
						placeholder="���������� ���ּ���." readOnly /> &nbsp; <input type="button"
						value="��������" onclick="authCheckForm(this.form)"></td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Zipcode</td>&nbsp;
					<td><input type="text" name="zipcode" id="zipcode" size="7"
						placeholder="�����ȣ" />&nbsp; <input type="button" value="Search"
						onclick="DaumPostcode()"></td>
				</tr>
				<tr>
					<td><img
						src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif">Address</td>
					&nbsp;
					<td><input type="text" id="address1" name="address1"
						placeholder="�ּ�" size="50" /><br> <input type="text"
						id="address2" name="address2" placeholder="���ּ�" size="50" /></td>
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