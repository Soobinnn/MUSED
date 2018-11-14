<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/MUSED_MUSED/tiles/style.css">
<meta charset="EUC-KR">
<title>Insert title here</title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#imgInp").on('change', function() {
			readURL(this);
		});
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}
</script>

<!-- �� ������������ style�����ϴ� ��. ���� style.css�� ��ġ�� ����. -->
<style>
.in { /*input tag ���� ��Ÿ��*/
	width: 100px;
	height: 30px;
	border-radius: 10px;
	font-weight: 600;
	border-color: transparent;
	font-size: 12px;
	background: black;
	color: #fff;
	cursor: pointer;
}

.upload {
	width: 100px;
	height: 30px;
	border-radius: 10px;
	font-weight: 600;
	border-color: transparent;
	font-size: 12px;
	background: black;
	color: #fff;
	cursor: pointer;
	opacity: 0; /*input type="file" tag �����ϰ� ó��*/
	position: relative;
}

.replace { /*button tag �� ���ϴ� ��Ÿ�� ����*/
	position: absolute;
	width: 100px;
	height: 30px;
	border-radius: 10px;
	font-weight: 600;
	border-color: transparent;
	font-size: 12px;
	background: hotpink;
	color: #fff;
	cursor: pointer;
}

.circle {
	border-radius: 1200px !important;
	overflow: hidden;
	width: 128px;
	height: 128px;
	border: 8px solid rgba(255, 255, 255, 0.7);
	position: relative;
	top: 0px;
}

.border {
	border-radius: 50%;
}
</style>
<!-- �� ������������ style�����ϴ� ��. ���� style.css�� ��ġ�� ����. -->

</head>
<body>
	<form method="post" enctype="multipart/form-data"
		action="updateProfile.action">
		<div>
			<!-- �̹������� �̹��� �ø��� -->
			<div style="position: absolute;">
				<div style="position: relative; top: 20px; left: 100px;">
					<table width="100%">
						<tr height="100px">
							<td width="20%" align="center">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������ ���� <br> <img
								class="circle" id="blah"
								src="C:/Java/upload/file_<s:property value="%{#session.ID}"/>.jpg"
								width="150" height="150" /><br>
								<button class="replace">�̹��� ���ε�</button> <input type="file"
								class="upload" id="imgInp" name="upload" accept="image/*"><input
								type="submit" class="in" value="Ȯ��">
							</td>
							<td width="10%"></td>
							<td width="35%" align="left">���̵�: <s:property
									value="%{#session.ID}" /> <br>���: <s:if
									test="#session.ACCESS_NUM == 1">
									<img class="border"
										src="/MUSED_MUSED/tiles/image/supervisor.jpg" width="15"
										height="15" />
								</s:if> <s:if
									test="#session.ACCESS_NUM != 1 && paramClass.score >= 0 && paramClass.score < 100">
									<img class="border" src="/MUSED_MUSED/tiles/image/bronze.png"
										width="15" height="15" />
								</s:if> <s:if
									test="#session.ACCESS_NUM != 1 && paramClass.score >= 100 && paramClass.score < 150">
									<img class="border" src="/MUSED_MUSED/tiles/image/silver.png"
										width="15" height="15" />
								</s:if> <s:if
									test="#session.ACCESS_NUM != 1 && paramClass.score >= 150 && paramClass.score < 200">
									<img class="border" src="/MUSED_MUSED/tiles/image/gold.png"
										width="15" height="15" />
								</s:if> <s:if
									test="#session.ACCESS_NUM != 1 && paramClass.score >= 200 && paramClass.score < 500">
									<img class="border" src="/MUSED_MUSED/tiles/image/vip.png"
										width="15" height="15" />
								</s:if> <s:if test="%{#session.ACCESS_NUM == 1}">������</s:if> <s:else>
									<s:property value="%{grade}" />
								</s:else>(<s:property value="%{paramClass.score}" />) <img
								class="border" src="/MUSED_MUSED/tiles/image/grade.png"
								width="15" height="15" />
								<p class="arrow_box">
									<img class="border" src="/MUSED_MUSED/tiles/image/bronze.png"
										width="15" height="15" />BRONZE : ~99<br> <img
										class="border" src="/MUSED_MUSED/tiles/image/silver.png"
										width="15" height="15" />SILVER : ~149<br> <img
										class="border" src="/MUSED_MUSED/tiles/image/gold.png"
										width="15" height="15" />GOLD : ~199<br> <img
										class="border" src="/MUSED_MUSED/tiles/image/vip.png"
										width="15" height="15" />VIP : ~499<br> <img
										class="border" src="/MUSED_MUSED/tiles/image/supervisor.jpg"
										width="15" height="15" />������<br>
								</p> <br> ������: <s:property value="%{#session.JOINDATE}" />
							</td>
							<td width="35%" align="left">��ϵ� ��ǰ:<s:property
									value="%{countPro}" /><br> ��ϵ� ���:<s:property
									value="%{countTal}" /><br> ���� ��ǰ:2<br> �Ǹ� ����:<s:property
									value="%{sum}" /><br>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- ����� �� �̹��� -->
			<img src="images/background.jpg" width="1500px" height="230px"
				align="center"></img>
		</div>
	</form>
</body>
</html>