package message;

public class Msg_pagingAction2 {
	
	   private int currentPage;   //현재페이지
	   private int totalCount;      //전체 게시물 수
	   private int totalPage;      //전체 페이지 수
	   private int blockCount;      //한 페이지의 게시물의 수
	   private int blockPage;      //한 화면에 보여줄 페이지 수
	   private int startCount;    //한 페이지에서 보여줄 게시글의 시작 번호
	   private int endCount;      //한 페이지에서 보여굴 게시글의 끝 번호
	   private int startPage;      //시작 페이지
	   private int endPage;      //마지막 페이지

	   private StringBuffer pagingHtml2;
	   
	   //페이징 생성자
	   public Msg_pagingAction2(int currentPage, int totalCount, int blockCount,
	         int blockPage, int searchNum, String isSearch){
	      
	      this.blockCount = blockCount;
	      this.blockPage = blockPage;
	      this.currentPage = currentPage;
	      this.totalCount = totalCount;
	      
	      //전체페이지 수
	      totalPage = (int)Math.ceil((double) totalCount/blockCount);
	      if(totalPage == 0){
	         totalPage = 1;
	      }
	      
	      //현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
	      if(currentPage > totalPage){
	         currentPage = totalPage;
	      }
	      
	      //현재 페이지의 처음과 마지막 글의 번호 가져오기.
	      startCount = (currentPage - 1)*blockCount;
	      endCount = startCount + blockCount - 1;
	      
	      //시작 페이지와 마지막 페이지 값 구하기.
	      startPage = (int)((currentPage - 1) / blockPage) * blockPage + 1;
	      endPage = startPage + blockPage - 1;
	      
	      //마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
	      if(endPage > totalPage){
	         endPage = totalPage;
	      }
	      
	      //이전 block 페이지
	      pagingHtml2 = new StringBuffer();
	      if(currentPage > blockPage){
	         if(isSearch != "")
	            pagingHtml2.append("<a href=receivedMessage.action?currentPage="+(startPage-1)+"&searchKeyword="+isSearch+"&searchNum="+searchNum+">");
	         else
	            pagingHtml2.append("<a href=receivedMessage.action?currentPage="+(startPage - 1)+">");
	            pagingHtml2.append("이전");
	            pagingHtml2.append("</a>");
	      }
	      
	      pagingHtml2.append("&nbsp;|&nbsp;");
	   
	      //페이지 번호. 현재 페이지는 빨간색으로 강조하고 링크를 제거.
	      for(int i = startPage; i <= endPage; i++){
	         if ( i > totalPage){
	            break;
	         }
	         
	         if (i == currentPage) {
	            pagingHtml2.append("&nbsp;<b><font color='red'>");
	            pagingHtml2.append(i);
	            pagingHtml2.append("</font></b>");
	         } else 
	         {
	            pagingHtml2.append(
	                  "&nbsp;<a href='receivedMessage.action?currentPage=");
	            pagingHtml2.append(i);
	            if(isSearch != "")
	               pagingHtml2.append("&searchKeyword="+isSearch);
	            pagingHtml2.append("'>");
	            pagingHtml2.append(i);
	            pagingHtml2.append("</a>");
	         }
	         
	         pagingHtml2.append("&nbsp;");
	      }
	      
	      pagingHtml2.append("&nbsp;&nbsp;|&nbsp;&nbsp;");
	      //다음block페이지
	      if(totalPage - startPage >= blockPage){
	         pagingHtml2.append("&nbsp;<a href=receivedMessage.action?currentPage=");
	         pagingHtml2.append((endPage+1));
	         if(isSearch!="")
	            pagingHtml2.append("&searchKeyword="+isSearch);
	            pagingHtml2.append("다음");
	            pagingHtml2.append("</a>");
	      }
	      
	}

	   public int getCurrentPage() {
	      return currentPage;
	   }

	   public void setCurrentPage(int currentPage) {
	      this.currentPage = currentPage;
	   }

	   public int getTotalCount() {
	      return totalCount;
	   }

	   public void setTotalCount(int totalCount) {
	      this.totalCount = totalCount;
	   }

	   public int getTotalPage() {
	      return totalPage;
	   }

	   public void setTotalPage(int totalPage) {
	      this.totalPage = totalPage;
	   }

	   public int getBlockCount() {
	      return blockCount;
	   }

	   public void setBlockCount(int blockCount) {
	      this.blockCount = blockCount;
	   }

	   public int getBlockPage() {
	      return blockPage;
	   }

	   public void setBlockPage(int blockPage) {
	      this.blockPage = blockPage;
	   }

	   public int getStartCount() {
	      return startCount;
	   }

	   public void setStartCount(int startCount) {
	      this.startCount = startCount;
	   }

	   public int getEndCount() {
	      return endCount;
	   }

	   public void setEndCount(int endCount) {
	      this.endCount = endCount;
	   }

	   public int getStartPage() {
	      return startPage;
	   }

	   public void setStartPage(int startPage) {
	      this.startPage = startPage;
	   }

	   public int getEndPage() {
	      return endPage;
	   }

	   public void setEndPage(int endPage) {
	      this.endPage = endPage;
	   }

	   public StringBuffer getPagingHtml2() {
	      return pagingHtml2;
	   }

	   public void setPagingHtml2(StringBuffer pagingHtml2) {
	      this.pagingHtml2 = pagingHtml2;
	   }
}
