<html>
<head>
<style>
input {             /*input tag 공통 스타일*/
  width: 200px;
  height: 100px;
  border-radius: 3px;
  font-weight: 600;
  border-color: transparent;
  font-size: 25px;
  background: hotpink;
  color: #fff;
 cursor: pointer;
}
input.upload {  
  opacity: 0;       /*input type="file" tag 투명하게 처리*/
  position: relative;
}
button.replace {    /*button tag 에 원하는 스타일 적용*/
  position: absolute;
  width: 200px;
  height: 100px;
  border-radius: 3px;
  font-weight: 600;
  border-color: transparent;
  font-size: 25px;
  background: hotpink;
  color: #fff;
  cursor: pointer;
}
</style>
</head>
<body>
<input type="submit" value="등록">
<button class="replace">파일 업로드</button>
<input type="file" value="파일 업로드" class="upload">
</body>
</html>


