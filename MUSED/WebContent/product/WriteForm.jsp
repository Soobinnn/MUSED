<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>악기 입력 폼</title>

<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
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

 deleteAll(selform.product_gogon); // 지금 있는 목록 삭제하기.
  
 sidoindex = selform.product_sido.selectedIndex;
 gogonlen = regionArray[sidoindex].length;
 cur_sido = selform.product_sido.options[selform.product_sido.selectedIndex].value;

	
 
 selform.product_gogon.length=gogonlen;

 for (i=0; i<gogonlen; i++) {
  selform.product_gogon.options[i] = new Option(regionArray[sidoindex][i], regionArray[sidoindex][i]);
  if (cur_sido == sproduct_sido && sproduct_gogon == regionArray[sidoindex][i])
   selform.product_gogon.options[i].selected = true;
 }
}

function initRegion()
{
 var sido = Array ( "시도선택",  "서울특별시", "인천광역시", "대전광역시",
      "광주광역시", "대구광역시", "울산광역시", "부산광역시",
      "경기도",  "강원도",  "충청북도",  "충청남도",
      "전라북도",  "전라남도",  "경상북도",  "경상남도",  "제주도");
 sidolen = sido.length;
 document.fwrite.product_sido.options.length = sidolen;
 for(var i=0; i<sidolen; i++) {
  document.fwrite.product_sido.options[i] = new Option(sido[i], sido[i]);
  if (sproduct_sido == sido[i]) {
   document.fwrite.product_sido.options[i].selected = true;
   document.fwrite.product_sido.selectedIndex = i;
  }
 }
}

</script>
<script type="text/javascript">

		function validation() {
			var frm = document.fwrite;
			
			if(frm.product_id.value == "") {
				alert("아이디를 입력해주세요.(수정 예정)");
				frm.product_id.focus();
				return false;
			} 
			
			else if(frm.product_state.value == "") {
				alert("판매 상태를 체크해주세요.");
				frm.product_state.focus();
				return false;
			}
/* 
			else if(frm.product_type.value == "") {
				alert("거래 형식을 입력해주세요.");
				return false;			
			} 
			 */
			else if(frm.product_subject.value == "") {
				alert("제목을 입력해주세요.");
				frm.product_subject.focus();
				return false;
			}

			else if(frm.product_name.value == "") {
				alert("상품명을 입력해주세요.");
				frm.product_name.focus();
				return false;			
			} 
			
			else if(frm.product_category.value == "") {
				alert("카테고리를 정해주세요.");
				frm.product_category.focus();
				return false;			
			} 

			else if(frm.product_price.value == "") {
				alert("가격을 입력해주세요.");
				frm.product_price.focus();
				return false;			
			} 
			else if(frm.file.value==""){
				alert("파일을 업로드해주세요.");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
<div id="heading" >
<h1>악기판매</h1>
</div>
 <nav id="main_gnb">
				<ul class="left">
					<li><a href="productList.action?currentPage=1&sort=0">중고악기거래</a></li>
					<li><a href="talentList.action?currentPage=1&sort=0">재능거래</a></li>
					<li><a href="/MUSED/tiles/free/listAction.action?currentPage=1">커뮤니티</a></li>

				</ul>
				<ul class="right">
					<s:if test='%{#session.ID != null}'>
						<li class="active"><a href="productWriteForm.action">악기판매</a></li>
						<li><a href="talentWriteForm.action">재능판매</a></li>
					</s:if>
				</ul>
			</nav>
<div id="main" align="center">
	<s:if test="resultClass == NULL">
			<form name="fwrite" action="productWrite.action" method="post" enctype="multipart/form-data" onsubmit="return validation();">
		</s:if>
		
		<s:else>
		  <form name="fwrite" action="productUpdate.action" method="post" enctype="multipart/form-data" onsubmit="return validation();">
		  <s:hidden name="product_no" value="%{resultClass.product_no}" />
		  <s:hidden name="currentPage" value="%{currentPage}" />
		 
		</s:else>

       <table width="80%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><br></br></td>
          </tr>
        <tr>
          <td colspan="2"><br/>&nbsp;<font size="2p" color="#FF0000">* 는 필수 입력사항입니다.</font></td>
                   <s:hidden name="product_id" value="%{#session.ID}" />         
        </tr>
         <tr>
          <td><br></br></td>
          </tr>
        <tr>
          <td height="1" colspan="2"></td>
        </tr>
        <tr>
          <td>&nbsp;<font color="#FF0000">*</font>  판매 상태</td>
          <td>
          <!-- 나중에 checkbox 선택 시 저장.. 이런거 다시 구현 -->
			<input id="product_ing" type="radio" checked="checked" name="product_state" value="현"><label for="product_ing">&nbsp;판매중</label></input>
			<input id="product_end" type="radio" name="product_state" value="완"><label for="product_end">&nbsp;판매 완료</label></input>
          </td>
        </tr>
        <tr>
          <td height="1" colspan="2"></td>	
        </tr>
				
        <tr>
          <td>&nbsp;<font color="#FF0000">*</font>   카테고리</td>
          <td>
          
          <!-- 나중에 category 선택 시 저장.. 이런거 다시 구현 -->
       			<select name="product_category">
					<option value="classic">클래식(관악기/현악기)</option>
					<option value="guiter">기타</option>
					<option value="drum">드럼/타악기</option>
					<option value="piano">건반악기</option>
					<option value="sound">음향악기</option>
					<option value="etc">그 외 악기</option>
					
				</select>
		
       	</td>
       </tr>							
        <tr>
          <td height="1" colspan="2"></td>
        </tr>
        
        <tr>
          <td>&nbsp;<font color="#FF0000">*</font>  상품 판매 형식</td>
          <td>
          <!-- 나중에 checkbox 선택 시 저장.. 이런거 다시 구현 -->
			<input type="checkbox" name="product_type" value="직" id="cb5">
				<label for="cb5" style="width:160px">
					일반형
					<font size="2p">(비배송형)</font>
					</label></input>
			<input type="checkbox" name="product_type" value="포" id="cb6" checked="checked">
				<label for="cb6" style="width:160px">
					배송형 
					<font size="2p">(택배비 포함)</font>
					</label></input>
			<input type="checkbox" name="product_type" value="미" id="cb7">
				<label for="cb7" style="width:160px">
					배송형 
					<font size="2p">(택배비 미포함)</font>
					</label></input>
          </td>
        </tr>
        
        <tr>
          <td height="1" colspan="2"></td>	
        </tr>
 
    	<tr>
          <td>&nbsp;<font color="#FF0000">*</font>  제목</td>
          <td>
            <s:textfield id="text" name="product_subject" theme="simple" value="%{resultClass.product_subject}" cssStyle="width:300px" maxlength="50"/>
          </td>
        </tr>
        <tr>
          <td height="1" colspan="2"></td>	
        </tr>
     
        <tr>
          <td>&nbsp;<font color="#FF0000">*</font>  상품명</td>
          <td>
            <s:textfield name="product_name" theme="simple" value="%{resultClass.product_name}" cssStyle="width:300px" maxlength="50"/>
          </td>
        </tr>
        <tr>
          <td height="1" colspan="2"></td>	
        </tr>
        	
        <tr>
          <td> &nbsp;&nbsp; 브랜드 및 모델명</td>
          <td>
            <s:textfield name="product_brand" theme="simple" value="%{resultClass.product_brand}" cssStyle="width:300px" maxlength="50"/>
          </td>
        </tr>
        <tr>
          <td height="1" colspan="2"></td>	
        </tr>
        	
        <tr>
          <td>&nbsp;<font color="#FF0000">*</font>  가격</td>
          <td>
            <s:textfield name="product_price" theme="simple" value="%{resultClass.product_price}" cssStyle="width:160px" maxlength="20"/>원
          </td>
        </tr>
        <tr>
          <td height="1" colspan="2"></td>	
        </tr>
        
        
        <tr>
          <td>  &nbsp;&nbsp;&nbsp;거래 시 연락처</td>	
          <td>
            <s:textfield name="product_phone" theme="simple" value="%{resultClass.product_phone}" cssStyle="width:88px" maxlength="11"/>
          </td>
        </tr>
        <tr>
          <td height="1" colspan="2"></td>	
        </tr>
        <tr>
          <td> &nbsp;&nbsp; 거래 선호 지역</td>
          <td>
  
					<select name="product_sido" OnChange="changeRegion(fwrite)"></select>
					<select name="product_gogon"></select><br><font size="2p">* 직거래를 선택하셨다면 거래 지역을 선택하세요.</font></br>
					
					
					<script language="javascript">
					
					var sproduct_sido = "<?=$product_sido?>"; // php 변수를 자바스크립트 변수로 저장 - 현재 선택된 시도.
					var sproduct_gogon = "<?=$product_gogon?>"; // php 변수를 자바스크립트 변수로 저장 - 현재 선택된 시군구.
					initRegion();
					changeRegion(fwrite);
					
					</script>
					
					            
          </td>
        </tr>
       
        <tr>
          <td height="1" colspan="2"></td>	
        </tr> 
        <tr>
        <td colspan="2">
			<br><font size="2p" color="red">&nbsp;&nbsp;&nbsp; * 파일을 하나 이상 첨부 하지 않을 시 에러가 발생하여 상품이 등록되지 않습니다.</font></br><br/>
		</td>
		</tr>
		
        <tr>
          <td>&nbsp;<font color="#FF0000">*</font>  메인 사진 등록</td>  
          <td>
             <s:file id="f" name="upload"/>   	      
          </td>
        </tr>
        <tr>
          <td>  &nbsp;&nbsp;&nbsp;추가 사진 등록</td> 
          <td>
             <s:file name="upload"/>  
             <s:file name="upload"/>  
             <s:file name="upload"/>       
          </td>
        </tr>
                <tr>
          <td height="1" colspan="2"></td>
        </tr>
		<tr>
          <td>&nbsp;<font color="#FF0000">*</font>  상품 상세 설명 </td>
          <td >
            <s:textarea id="texthigh" name="product_content" theme="simple" value="%{resultClass.product_content}" cols="50" rows="10" />
          </td>
        </tr>
        <tr>
          <td height="3" colspan="2"></td>
        </tr>
        
        
        <tr>
          <td align="right" colspan="2">
          	<input id="write" name="submit" type="submit" value="작성완료" class="inputb">
            <input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='productList.action?sort=0&currentPage=1'">
          </td>
        </tr>
        <tr>
          <td><br></br></td>
          </tr> 
    </table>
    </form>
</div>

</body>
</html>