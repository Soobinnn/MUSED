package message;

public class Msg_pagingAction2 {
	
	   private int currentPage;   //����������
	   private int totalCount;      //��ü �Խù� ��
	   private int totalPage;      //��ü ������ ��
	   private int blockCount;      //�� �������� �Խù��� ��
	   private int blockPage;      //�� ȭ�鿡 ������ ������ ��
	   private int startCount;    //�� ���������� ������ �Խñ��� ���� ��ȣ
	   private int endCount;      //�� ���������� ������ �Խñ��� �� ��ȣ
	   private int startPage;      //���� ������
	   private int endPage;      //������ ������

	   private StringBuffer pagingHtml2;
	   
	   //����¡ ������
	   public Msg_pagingAction2(int currentPage, int totalCount, int blockCount,
	         int blockPage, int searchNum, String isSearch){
	      
	      this.blockCount = blockCount;
	      this.blockPage = blockPage;
	      this.currentPage = currentPage;
	      this.totalCount = totalCount;
	      
	      //��ü������ ��
	      totalPage = (int)Math.ceil((double) totalCount/blockCount);
	      if(totalPage == 0){
	         totalPage = 1;
	      }
	      
	      //���� �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
	      if(currentPage > totalPage){
	         currentPage = totalPage;
	      }
	      
	      //���� �������� ó���� ������ ���� ��ȣ ��������.
	      startCount = (currentPage - 1)*blockCount;
	      endCount = startCount + blockCount - 1;
	      
	      //���� �������� ������ ������ �� ���ϱ�.
	      startPage = (int)((currentPage - 1) / blockPage) * blockPage + 1;
	      endPage = startPage + blockPage - 1;
	      
	      //������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
	      if(endPage > totalPage){
	         endPage = totalPage;
	      }
	      
	      //���� block ������
	      pagingHtml2 = new StringBuffer();
	      if(currentPage > blockPage){
	         if(isSearch != "")
	            pagingHtml2.append("<a href=receivedMessage.action?currentPage="+(startPage-1)+"&searchKeyword="+isSearch+"&searchNum="+searchNum+">");
	         else
	            pagingHtml2.append("<a href=receivedMessage.action?currentPage="+(startPage - 1)+">");
	            pagingHtml2.append("����");
	            pagingHtml2.append("</a>");
	      }
	      
	      pagingHtml2.append("&nbsp;|&nbsp;");
	   
	      //������ ��ȣ. ���� �������� ���������� �����ϰ� ��ũ�� ����.
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
	      //����block������
	      if(totalPage - startPage >= blockPage){
	         pagingHtml2.append("&nbsp;<a href=receivedMessage.action?currentPage=");
	         pagingHtml2.append((endPage+1));
	         if(isSearch!="")
	            pagingHtml2.append("&searchKeyword="+isSearch);
	            pagingHtml2.append("����");
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