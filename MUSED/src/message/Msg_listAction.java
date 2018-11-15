
package message;

	import com.opensymphony.xwork2.ActionContext;
	import com.opensymphony.xwork2.ActionSupport;
	import com.ibatis.common.resources.Resources;
	import com.ibatis.sqlmap.client.SqlMapClient;
	import com.ibatis.sqlmap.client.SqlMapClientBuilder;

	import java.util.*;
	import java.io.Reader;
	import java.io.IOException;

	import message.Msg_pagingAction;

	import message.Message_VO;

	public class Msg_listAction extends ActionSupport{
		
		public static Reader reader;		//파일 스트림을 위한 reader.
		public static SqlMapClient sqlMapper;		//SqkMapClient API를 사용하기 위한 sqlMapper객체.
		
		private List<Message_VO> list = new ArrayList<Message_VO>();
		
		

		private int currentPage = 1;	//현재 페이지
		private int totalCount;			//총 게시물의 수
		private int blockCount = 10;	//한 페이지의 게시물의 수
		private int blockPage = 5;		//한 화면에 보여줄 페이지 수
		private String pagingHtml;
		private String pagingHtml2;//페이징을 구현한 HTML
		

		private Msg_pagingAction page;
		private Msg_pagingAction2 page2;//페이징 클래스
		
		private Message_VO paramClass;
		private String msg_rec_id;
		private String msg_wrt_id;

		private int num = 0;
		private String searchKeyword;
		private int searchNum;
		



		
		//생성자
		public Msg_listAction() throws IOException{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");	//sqlMapConfig.xml파일의 설정 내용을 가져온다.
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	//sqlMapConfig.xml의 내용을 적용한 sqlMapper객체 생성.
			
			reader.close();
		}
		
		//게시판 LIST액션 , 받은 쪽지함
				public String execute() throws Exception{
					//모든 글을 가져와 list에 넣는다.
					
					paramClass=new Message_VO();
					
					list = new ArrayList<Message_VO>();
					
					ActionContext context = ActionContext.getContext();
					Map<String, Object> session = context.getSession();
					System.out.println("세션아이디::" + (String) session.get("ID"));
					
					if(getSearchKeyword() != null)		//검색어가 있으면
					{
						return search();				//search()로 리턴
					}			
					list = sqlMapper.queryForList("Message.Msg_select_Rec", (String) session.get("ID"));
					
					
					totalCount = list.size(); //전체 글 갯수를 구한다.
					//pagingAction 객체 생성.
					page2 = new Msg_pagingAction2(currentPage, totalCount, blockCount, blockPage, num, "");
					pagingHtml2 = page2.getPagingHtml2().toString();//페이지HTML생성.
					
					//현재 페이지에서 보여줄 마지막 글의 번호 설정.
					int lastCount = totalCount;
					
					//현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1번호로 설정.
					if(page2.getEndCount() < totalCount)
						lastCount = page2.getEndCount() + 1;
					
					//전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
					list = list.subList(page2.getStartCount(), lastCount);
					
					
					return SUCCESS;
				}
				//보낸 쪽지함
				public String execute2() throws Exception{
					//모든 글을 가져와 list에 넣는다.
					
					paramClass=new Message_VO();
					list = new ArrayList<Message_VO>();
					
					ActionContext context = ActionContext.getContext();
					Map<String, Object> session = context.getSession();
					
					System.out.println("세션아이디::" +(String) session.get("ID"));
					
					if(getSearchKeyword() != null)		//검색어가 있으면
					{
						return search();				//search()로 리턴
					}			
					list = sqlMapper.queryForList("Message.Msg_select_Wrt", (String) session.get("ID"));

					
					totalCount = list.size(); //전체 글 갯수를 구한다.
					//pagingAction 객체 생성.
					page = new Msg_pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
					pagingHtml = page.getPagingHtml().toString();//페이지HTML생성.
					
					//현재 페이지에서 보여줄 마지막 글의 번호 설정.
					int lastCount = totalCount;
					
					//현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1번호로 설정.
					if(page.getEndCount() < totalCount)
						lastCount = page.getEndCount() + 1;
					
					//전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
					list = list.subList(page.getStartCount(), lastCount);
					
					
		
					return SUCCESS;
				}
		public String search() throws Exception{		//맨 위에(execute.if()에) 검색어가 있을때(null이 아닐때)여기로 리턴
			
			if(searchNum == 0){				//boardList.jsp의 select Name.searchNum부분에 option value가 0일때
				list = sqlMapper.queryForList("Message.Msg_selectSearchW", "%"+getSearchKeyword()+"%");	
								//보낸 사람 컬럼의 서치키워드가 포함된 모든 행 가져와 list에 저장
			}
			if(searchNum == 1){				//boardList.jsp의 select Name.searchNum부분에 option value가 0일때
				list = sqlMapper.queryForList("Message.Msg_selectSearchR", "%"+getSearchKeyword()+"%");	
								//받는 사람 컬럼의 서치키워드가 포함된 모든 행 가져와 list에 저장
			}
			if(searchNum == 2){				//option value가 1일때
				list = sqlMapper.queryForList("Message.Msg_selectSearchC", "%"+getSearchKeyword()+"%");	
								//내용 (Content)컬럼의 서치키워드가 포함된 모든 행 가져와 list에 저장
			}
			if(searchNum == 3){				//option value가 2일때
				list = sqlMapper.queryForList("Message.Msg_selectSearchD", "%"+getSearchKeyword()+"%");	
								//날자(content)컬럼에 서치키워드가 포함된 모든 행 가져와 list에 저장
			}
			
			totalCount = list.size();
			page = new Msg_pagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, getSearchKeyword());
			pagingHtml = page.getPagingHtml().toString();
			
			int lastCount = totalCount;
			
			if(page.getEndCount()<totalCount)
				lastCount = page.getEndCount()+1;
			
			list = list.subList(page.getStartCount(), lastCount);
			
			return SUCCESS;
		}
		
		
		public String list() throws Exception{
			return SUCCESS;
		}

		public static Reader getReader() {
			return reader;
		}

		public static void setReader(Reader reader) {
			Msg_listAction.reader = reader;
		}

		public static SqlMapClient getSqlMapper() {
			return sqlMapper;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			Msg_listAction.sqlMapper = sqlMapper;
		}

		public List<Message_VO> getList() {
			return list;
		}

		public void setList(List<Message_VO> list) {
			this.list = list;
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

		public String getPagingHtml() {
			return pagingHtml;
		}

		public void setPagingHtml(String pagingHtml) {
			this.pagingHtml = pagingHtml;
		}

		public Msg_pagingAction getPage() {
			return page;
		}

		public void setPage(Msg_pagingAction page) {
			this.page = page;
		}

		public Message_VO getParamClass() {
			return paramClass;
		}

		public void setParamClass(Message_VO paramClass) {
			this.paramClass = paramClass;
		}

		public String getMsg_rec_id() {
			return msg_rec_id;
		}

		public void setMsg_rec_id(String msg_rec_id) {
			this.msg_rec_id = msg_rec_id;
		}

		public String getMsg_wrt_id() {
			return msg_wrt_id;
		}

		public void setMsg_wrt_id(String msg_wrt_id) {
			this.msg_wrt_id = msg_wrt_id;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getSearchKeyword() {
			return searchKeyword;
		}

		public void setSearchKeyword(String searchKeyword) {
			this.searchKeyword = searchKeyword;
		}

		public int getSearchNum() {
			return searchNum;
		}

		public void setSearchNum(int searchNum) {
			this.searchNum = searchNum;
		}
		public String getPagingHtml2() {
			return pagingHtml2;
		}

		public void setPagingHtml2(String pagingHtml2) {
			this.pagingHtml2 = pagingHtml2;
		}

		public Msg_pagingAction2 getPage2() {
			return page2;
		}

		public void setPage2(Msg_pagingAction2 page2) {
			this.page2 = page2;
		}
		




		
		
}
