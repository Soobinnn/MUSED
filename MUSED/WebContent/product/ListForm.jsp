<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import ="java.util.HashMap" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>악기 게시판</title>
</head>
<body>

<script language=javascript>

function deleteAll(f)
{
for (var i=0; i<f.length; i++) {
  f.options[i] = null;
}
f.length = 0;
}

function changeRegion(selform)
{
 var regionArray = Array();
 var regionNone = Array ( "시군구선택" );
 var regionSeoul = Array( "시군구선택", "강남구",  "강동구",  "강북구",
    "강서구",  "관악구",  "광진구",  "구로구",  "금천구",
    "노원구",  "도봉구",  "동대문구",  "동작구",  "마포구",
    "서대문구",  "서초구",  "성동구",  "성북구",  "송파구",
    "양천구",  "영등포구",  "용산구",  "은평구",  "종로구",
    "중구",   "중랑구");
 var regionIncheon = Array ( "시군구선택", "계양구",  "남구",   "남동구",
    "동구",   "부평구",  "서구",   "연수구",  "중구",
    "강화군",  "옹진군");
 var regionDaejeon = Array ( "시군구선택", "대덕구",  "동구",   "서구",
    "유성구",  "중구");
 var regionGwangju = Array ( "시군구선택", "광산구",  "남구",   "동구", 
    "북구",   "서구");
 var regionDaegu = Array ( "시군구선택", "남구",   "달서구",  "동구",
    "북구",   "서구",   "수성구",  "중구",   "달성군");
 var regionUlsan = Array ( "시군구선택", "남구",   "동구",   "북구",
    "중구",   "울주군");
 var regionBusan = Array ( "시군구선택", "강서구",  "금정구",  "남구",
    "동구",   "동래구",  "부산진구",  "북구",   "사상구",
    "사하구",  "서구",   "수영구",  "연제구",  "영도구",
    "중구",   "해운대구",  "기장군");
 var regionGyeonggi = Array ("시군구선택", "고양시",  "과천시",  "광명시",
    "광주시",  "구리시",  "군포시",  "김포시",  "남양주시",
    "동두천시",  "부천시",  "성남시",  "수원시",  "시흥시",
    "안산시",  "안성시",  "안양시",  "양주시",  "오산시",
    "용인시",  "의왕시",  "의정부시",  "이천시",  "파주시",
    "평택시",  "포천시",  "하남시",  "화성시",  "가평군",
    "양평군",  "여주군",  "연천군");
 var regionGangwon = Array ( "시군구선택", "강릉시",  "동해시",  "삼척시",
    "속초시",  "원주시",  "춘천시",  "태백시",  "고성군",
    "양구군",  "양양군",  "영월군",  "인제군",  "정선군",
    "철원군",  "평창군",  "홍천군",  "화천군",  "횡성군");
 var regionChungbuk = Array ("시군구선택", "제천시",  "청주시",  "충주시",
    "괴산군",  "단양군",  "보은군",  "영동군",  "옥천군",
    "음성군",  "증평군",  "진천군",  "청원군");
 var regionChungnam = Array ("시군구선택", "계룡시",  "공주시",  "논산시",
    "보령시",  "서산시",  "아산시",  "천안시",  "금산군",
    "당진군",  "부여군",  "서천군",  "연기군",  "예산군",
    "청양군",  "태안군",  "홍성군");
 var regionJeonbuk = Array ( "시군구선택", "군산시",  "김제시",  "남원시",
    "익산시",  "전주시",  "정읍시",  "고창군",  "무주군",
    "부안군",  "순창군",  "완주군",  "임실군",  "장수군",  "진안군");
 var regionJeonnam = Array ( "시군구선택", "광양시",  "나주시",  "목포시",
    "순천시",  "여수시",  "강진군",  "고흥군",  "곡성군",
    "구례군",  "담양군",  "무안군",  "보성군",  "신안군",
    "영광군",  "영암군",  "완도군",  "장성군",  "장흥군",
    "진도군",  "함평군",  "해남군",  "화순군");
 var regionGyeongbuk = Array ("시군구선택", "경산시",  "경주시",  "구미시",
    "김천시",  "문경시",  "상주시",  "안동시",  "영주시",
    "영천시",  "포항시",  "고령군",  "군위군",  "봉화군",
    "성주군",  "영덕군",  "영양군",  "예천군",  "울릉군",
    "울진군",  "의성군",  "청도군",  "청송군",  "칠곡군");
 var regionGyeongnam = Array ("시군구선택", "거제시",  "김해시",  "마산시",
    "밀양시",  "사천시",  "양산시",  "진주시",  "진해시",
    "창원시",  "통영시",  "거창군",  "고성군",  "남해군",
    "산청군",  "의령군",  "창녕군",  "하동군",  "함안군",
    "함양군",  "합천군");
 var regionJeju = Array ( "시군선택",  "서귀포시",  "제주시",  "남제주군",  "북제주군");

 regionArray[0] = regionNone;
 regionArray[1] = regionSeoul;
 regionArray[2] = regionIncheon;
 regionArray[3] = regionDaejeon;
 regionArray[4] = regionGwangju;
 regionArray[5] = regionDaegu;
 regionArray[6] = regionUlsan;
 regionArray[7] = regionBusan;
 regionArray[8] = regionGyeonggi;
 regionArray[9] = regionGangwon;
 regionArray[10] = regionChungbuk;
 regionArray[11] = regionChungnam;
 regionArray[12] = regionJeonbuk;
 regionArray[13] = regionJeonnam;
 regionArray[14] = regionGyeongbuk;
 regionArray[15] = regionGyeongnam;
 regionArray[16] = regionJeju;

 deleteAll(selform.gogon); // 지금 있는 목록 삭제하기.
  
 sidoindex = selform.sido.selectedIndex;
 gogonlen = regionArray[sidoindex].length;
 cur_sido = selform.sido.options[selform.sido.selectedIndex].value;

	
 
 selform.gogon.length=gogonlen;

 for (i=0; i<gogonlen; i++) {
  selform.gogon.options[i] = new Option(regionArray[sidoindex][i], regionArray[sidoindex][i]);
  if (cur_sido == ssido && sgogon == regionArray[sidoindex][i])
   selform.gogon.options[i].selected = true;
 }
}

function initRegion()
{
 var sido = Array ( "시도선택",  "서울특별시", "인천광역시", "대전광역시",
      "광주광역시", "대구광역시", "울산광역시", "부산광역시",
      "경기도",  "강원도",  "충청북도",  "충청남도",
      "전라북도",  "전라남도",  "경상북도",  "경상남도",  "제주도");
 sidolen = sido.length;
 document.fwrite.sido.options.length = sidolen;
 for(var i=0; i<sidolen; i++) {
  document.fwrite.sido.options[i] = new Option(sido[i], sido[i]);
  if (ssido == sido[i]) {
   document.fwrite.sido.options[i].selected = true;
   document.fwrite.sido.selectedIndex = i;
  }
 }
}

</script>
<style>
input[type="checkbox"] + label {
	display: inline-block;
	width: 90px;
	height: 20px;
	border: 2px solid #4e4e4e;
	cursor: pointer;
	font-weight:bold
}
input[type="checkbox"]:checked + label {
	background-color: #292929;
	color:#ffffff;
}
input[type="checkbox"]{
	display: none;
}
input[type="submit"]{
	 width:40;
}
#searchkeyword{
	width:350px;
}
select, input{
	height:25px
}
</style>

<table width="600" border="0" cellspacing="0" cellspadding="2">
		  <s:hidden name="currentPage" value="%{currentPage}" />
		  <form name="fwrite" action="search.action">
	<tr align="center" height="30px">
	<!-- 버튼 말고 check같은 거로 해야됨 -->
	<br></br>
		<td colspan="5">
		  	<input name="type" type="checkbox" id="classic" value="classic">
   			 	<label for="classic">클래식</label>
   			 	
   			<input name="type" type="checkbox" id="guiter" value="guiter">
   				<label for="guiter">기타</label>
   				
	   		<input name="type" type="checkbox" id="drum" value="drum">
	   			 <label for="drum">드럼/타악기</label>
	   			 
	   		<input name="type" type="checkbox" id="piano" value="piano">
	   			 <label for="piano">건반악기</label>
	   			 
	   		<input name="type" type="checkbox" id="sound" value="sound">
	   			 <label for="sound">음향악기</label>
	   			 
	   	   	<input name="type" type="checkbox" id="etc" value="etc">
	   			 <label for="etc">그 외 악기</label>
	   	
		</td>
	</tr>
		<tr align="left" height="30px">
		<td colspan="5">
		&nbsp;&nbsp;가 격 
		<input name="priceA" type="text">원 ~ <input name="priceB" type="text">원
		</td>
		</tr>
	<tr align="left" height="30px">
		<td colspan="5">

		&nbsp;&nbsp;지 역 
				<select name="sido" OnChange="changeRegion(fwrite)"></select>
					<select name="gogon"></select>
					
					
				<script language="javascript">
					
					var ssido = "<?=$sido?>"; // php 변수를 자바스크립트 변수로 저장 - 현재 선택된 시도.
					var sgogon = "<?=$gogon?>"; // php 변수를 자바스크립트 변수로 저장 - 현재 선택된 시군구.
					initRegion();
					changeRegion(fwrite);
		
		</script>

		</td>
	</tr>
	<tr align="left" height="30px">
		<td colspan="5">
				&nbsp;&nbsp;<input type="text" name="searchKeyword" id="searchkeyword" theme="simple" placeholder="내용+제목"/>
				<input name="submit" type="submit" value="검색" class="inputb">
		</td>
	</tr>
		</form>
		
	<tr align="left">
		<td colspan="5">
	<br>
				<select name="sort">
					<option value="0">최신순</option>
					<option value="1">인기순</option>
					<option value="2">최저가순</option>
					<option value="3">최고가순</option>
					
				</select>	
				<br>
		</td>
	</tr>

   		<s:if test="list.size()<=0">
			<tr bgcolor="#FFFFFF" align="center">
				<td colspan="5">등록된 게시물이 없습니다.</td>
			</tr>
		</s:if>
	<tr>
	<!-- 로그인 했을 때 상세보기 들어가짐 -->
      <s:if test='%{#session.ID != null}'>
      	<s:iterator value="list" status="stat">
	      	<s:url id="DetailURL" action="productDetail">
				<s:param name="product_no">
					<s:property value="product_no"/>
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage"/>
				</s:param>
			</s:url>
      <td>	 
          &nbsp;<s:a href="%{DetailURL}">
      			<img src="/MUSED/product/img/<s:property value="main_img"/>" style="height: 100px; width: 100px; display: block;"/>
				<br><s:property value="product_subject" />
				</br></s:a>
				<br>판매자 : <s:property value="product_id"/>	
	  </td>
	  	     	<s:if test="#stat.count%5==0">
  					<tr></tr>
				</s:if>	  
		</s:iterator>  		
		</s:if>
		
		<!-- 로그인 안했을 때 로그인 폼으로 -->
	 <s:if test='%{#session.ID == null}'>
	 <s:iterator value="list" status="stat">
      <td>	 
          &nbsp;<s:a href="loginForm.action">
      			<img src="/MUSED/product/img/<s:property value="main_img"/>" style="height: 100px; width: 100px; display: block;"/>
				<br><s:property value="product_subject"/>
				</br></s:a>
				<br><s:property value="product_id"/>	
				<br><s:property value="product_price"/>원
	  </td>
	  	     	<s:if test="#stat.count%5==0">
  					<tr></tr>
				</s:if>	  
		</s:iterator>  		
	 </s:if>
	</tr>
   	

	<tr align="center">
		<td colspan="5"><s:property value="pagingHtml" escape="false" /></td>
	</tr>
</table>
</body>
</html>