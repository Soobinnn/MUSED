package board.free;

public class pagingAction {
   private int currentPage;  //현재 페이지
   private int totalCount; //총 게시물 수
   private int totalPage; //전체 페이지 수
   private int blockCount; //한 페이지의 게시물 수
   private int blockPage; //한 화면에 보여줄 페이지 수
   private int startCount; //한 페이지에서 보여줄 게시글의 시작 번호
   private int endCount; // 한 페이지에서 보여줄 게시글의 끝 번호(이걸 빼먹었는데 어떻게 작동했지 ㅡㅡㅋ)
   private int startPage; // 시작 페이지
   private int endPage; //마지막 페이지
   
   private StringBuffer pagingHtml; //스트링 버퍼 객체 pagingHtml 생성


//페이징 생성자 - struts.xml과 연계된다.
   public pagingAction(int currentPage, int totalCount, int blockCount, int blockPage, int searchNum, String isSearch) {
	   this.blockCount = blockCount;
	   this.blockPage = blockPage;
	   this.currentPage = currentPage;
	   this.totalCount = totalCount;
	   
	   //Math.ceil(올림함수)
	   //전체 페이지 수 = 총 게시물 수  / 한 페이지의 게시물 수(올림값->double 사용)
	   // 만약 전체 페이지 수가 0이라면 1로 한다(첫 페이지 설정?)
	   totalPage  = (int) Math.ceil((double) totalCount / blockCount);
	   if(totalPage ==0) {
		   totalPage = 1;
	   }
   
	   //현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정한다.
	   if(currentPage > totalPage) {
		   currentPage = totalPage;
	   }
       
	   //현재 페이지의 처음과 마지막 글의 번호 가져오기
	   //페이지에서 보여줄 게시글의 시작 번호 = (현재페이지-1) * 페이지 게시물 수
	   //페이지에서 보여줄 게시글의 끝 번호 = 게시글의 시작 번호 + 페이지 게시물 수 -1
	 

	   
	   startCount = (currentPage -1) * blockCount;
	   endCount = startCount + blockCount -1;
	   
	   //시작 페이지와 마지막 페이지의 값을 구한다.
	   startPage = (int) ((currentPage -1) / blockPage) * blockPage + 1;
	   endPage = startPage + blockPage - 1;
	   
	   //마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정한다.
	   if(endPage > totalPage) {
		   endPage = totalPage;
	   }
	   
	   //이전 block 페이지
	   pagingHtml = new StringBuffer(); 
	   if(currentPage > blockPage) {
	   
		   if(isSearch != "") 
		       pagingHtml.append("<a href=listAction.action?currentPage="+ (startPage -1) + "&searchKeyword=" + isSearch + "&searchNum="+searchNum+">");     
		   else 
		       pagingHtml.append("<a href=listAction.action?currentPage=" +(startPage - 1) + ">");
		   
		   pagingHtml.append("이전");
		   pagingHtml.append("</a>");
		   
	   }
	   
	   pagingHtml.append("&nbsp;|&nbsp;");
	   
	   //페이지 번호. 현재 페이지는 빨간색으로 강조하고 링크를 제거
	   for(int i=startPage; i<=endPage; i++) {
		   if(i>totalPage) {
			   break;
		   }
	   
		   if( i==currentPage) {
			     pagingHtml.append("&nbsp;<b> <font color='red'>");
			     pagingHtml.append(i);
			     pagingHtml.append("</font></b>");
		   }else {
			      pagingHtml.append("&nbsp;<a href='listAction.action?currentPage=");
			      pagingHtml.append(i);
			      if(isSearch != "") pagingHtml.append("&searchKeyword="+isSearch);
			      pagingHtml.append("'>");
			      pagingHtml.append(i);
			      pagingHtml.append("</a>");
		   }
		     pagingHtml.append("&nbsp;");
		   
	   }
	   pagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");
	   
	   //다음 block 페이지(다음 화면에 보여줄 게시물 수?)
	   if(totalPage - startPage >=blockPage) {
		     pagingHtml.append("&nbsp;<a href='listAction.action?currentPage=");
		     pagingHtml.append((endPage+1));
		     if(isSearch != "")
		    	       pagingHtml.append("&searchKeyword="+isSearch);
		     pagingHtml.append("'>");
		     pagingHtml.append("다음");
		     pagingHtml.append("</a>");
	   }
   }


public int getCurrentPage() {
	return currentPage;
}


public int getTotalCount() {
	return totalCount;
}


public int getTotalPage() {
	return totalPage;
}


public int getBlockCount() {
	return blockCount;
}


public int getBlockPage() {
	return blockPage;
}


public int getStartCount() {
	return startCount;
}


public int getEndCount() {
	return endCount;
}


public int getStartPage() {
	return startPage;
}


public int getEndPage() {
	return endPage;
}


public StringBuffer getPagingHtml() {
	return pagingHtml;
}


public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}


public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
}


public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}


public void setBlockCount(int blockCount) {
	this.blockCount = blockCount;
}


public void setBlockPage(int blockPage) {
	this.blockPage = blockPage;
}


public void setStartCount(int startCount) {
	this.startCount = startCount;
}


public void setEndCount(int endCount) {
	this.endCount = endCount;
}


public void setStartPage(int startPage) {
	this.startPage = startPage;
}


public void setEndPage(int endPage) {
	this.endPage = endPage;
}


public void setPagingHtml(StringBuffer pagingHtml) {
	this.pagingHtml = pagingHtml;
}
   
   
	   }