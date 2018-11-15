<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�޽��� �ڽ�</title>
<script language="javascript">
function openMessage() {
	var url = "MsgWriteForm.action"
	window.open(
			url,
			"�޽��� ������",
			"toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=620, height=450");
}
</script>

</head>
<body>
  
  
<center><h2>������ ȸ���� ���� �޽��� ������ �����Ͽ����ϴ�.<br>�ٽ� �����ðڽ��ϱ�?</h2>
<input type="button" value="�޽��� �ٽ� ������" onClick="return openMessage()" />
<input type="button" value="�ݱ�" onClick="self.close()" /></center> 

</body>
</html>