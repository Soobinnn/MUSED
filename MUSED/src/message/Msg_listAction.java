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
		
		public static Reader reader;		//�뙆�씪 �뒪�듃由쇱쓣 �쐞�븳 reader.
		public static SqlMapClient sqlMapper;		//SqkMapClient API瑜� �궗�슜�븯湲� �쐞�븳 sqlMapper媛앹껜.
		
		private List<Message_VO> list = new ArrayList<Message_VO>();
		
		

		private int currentPage = 1;	//�쁽�옱 �럹�씠吏�
		private int totalCount;			//珥� 寃뚯떆臾쇱쓽 �닔
		private int blockCount = 10;	//�븳 �럹�씠吏��쓽 寃뚯떆臾쇱쓽 �닔
		private int blockPage = 5;		//�븳 �솕硫댁뿉 蹂댁뿬以� �럹�씠吏� �닔
		private String pagingHtml;
		private String pagingHtml2;//�럹�씠吏뺤쓣 援ы쁽�븳 HTML
		

		private Msg_pagingAction page;
		private Msg_pagingAction2 page2;//�럹�씠吏� �겢�옒�뒪
		
		private Message_VO paramClass;
		private String msg_rec_id;
		private String msg_wrt_id;

		private int num = 0;
		private String searchKeyword;
		private int searchNum;
		



		
		//�깮�꽦�옄
		public Msg_listAction() throws IOException{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");	//sqlMapConfig.xml�뙆�씪�쓽 �꽕�젙 �궡�슜�쓣 媛��졇�삩�떎.
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	//sqlMapConfig.xml�쓽 �궡�슜�쓣 �쟻�슜�븳 sqlMapper媛앹껜 �깮�꽦.
			
			reader.close();
		}
		
		//寃뚯떆�뙋 LIST�븸�뀡 , 諛쏆� 履쎌��븿
				public String execute() throws Exception{
					//紐⑤뱺 湲��쓣 媛��졇�� list�뿉 �꽔�뒗�떎.
					
					paramClass=new Message_VO();
					
					list = new ArrayList<Message_VO>();
					
					ActionContext context = ActionContext.getContext();
					Map<String, Object> session = context.getSession();
					System.out.println("�꽭�뀡�븘�씠�뵒::" + (String) session.get("ID"));
					
					if(getSearchKeyword() != null)		//寃��깋�뼱媛� �엳�쑝硫�
					{
						return search();				//search()濡� 由ы꽩
					}			
					list = sqlMapper.queryForList("Message.Msg_select_Rec", (String) session.get("ID"));
					
					
					totalCount = list.size(); //�쟾泥� 湲� 媛��닔瑜� 援ы븳�떎.
					//pagingAction 媛앹껜 �깮�꽦.
					page2 = new Msg_pagingAction2(currentPage, totalCount, blockCount, blockPage, num, "");
					pagingHtml2 = page2.getPagingHtml2().toString();//�럹�씠吏�HTML�깮�꽦.
					
					//�쁽�옱 �럹�씠吏��뿉�꽌 蹂댁뿬以� 留덉�留� 湲��쓽 踰덊샇 �꽕�젙.
					int lastCount = totalCount;
					
					//�쁽�옱 �럹�씠吏��쓽 留덉�留� 湲��쓽 踰덊샇媛� �쟾泥댁쓽 留덉�留� 湲� 踰덊샇蹂대떎 �옉�쑝硫� lastCount瑜� +1踰덊샇濡� �꽕�젙.
					if(page2.getEndCount() < totalCount)
						lastCount = page2.getEndCount() + 1;
					
					//�쟾泥� 由ъ뒪�듃�뿉�꽌 �쁽�옱 �럹�씠吏�留뚰겮�쓽 由ъ뒪�듃留� 媛��졇�삩�떎.
					list = list.subList(page2.getStartCount(), lastCount);
					
					
					return SUCCESS;
				}
				//蹂대궦 履쎌��븿
				public String execute2() throws Exception{
					//紐⑤뱺 湲��쓣 媛��졇�� list�뿉 �꽔�뒗�떎.
					
					paramClass=new Message_VO();
					list = new ArrayList<Message_VO>();
					
					ActionContext context = ActionContext.getContext();
					Map<String, Object> session = context.getSession();
					
					System.out.println("�꽭�뀡�븘�씠�뵒::" +(String) session.get("ID"));
					
					if(getSearchKeyword() != null)		//寃��깋�뼱媛� �엳�쑝硫�
					{
						return search();				//search()濡� 由ы꽩
					}			
					list = sqlMapper.queryForList("Message.Msg_select_Wrt", (String) session.get("ID"));

					
					totalCount = list.size(); //�쟾泥� 湲� 媛��닔瑜� 援ы븳�떎.
					//pagingAction 媛앹껜 �깮�꽦.
					page = new Msg_pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
					pagingHtml = page.getPagingHtml().toString();//�럹�씠吏�HTML�깮�꽦.
					
					//�쁽�옱 �럹�씠吏��뿉�꽌 蹂댁뿬以� 留덉�留� 湲��쓽 踰덊샇 �꽕�젙.
					int lastCount = totalCount;
					
					//�쁽�옱 �럹�씠吏��쓽 留덉�留� 湲��쓽 踰덊샇媛� �쟾泥댁쓽 留덉�留� 湲� 踰덊샇蹂대떎 �옉�쑝硫� lastCount瑜� +1踰덊샇濡� �꽕�젙.
					if(page.getEndCount() < totalCount)
						lastCount = page.getEndCount() + 1;
					
					//�쟾泥� 由ъ뒪�듃�뿉�꽌 �쁽�옱 �럹�씠吏�留뚰겮�쓽 由ъ뒪�듃留� 媛��졇�삩�떎.
					list = list.subList(page.getStartCount(), lastCount);
					
					
		
					return SUCCESS;
				}
		public String search() throws Exception{		//留� �쐞�뿉(execute.if()�뿉) 寃��깋�뼱媛� �엳�쓣�븣(null�씠 �븘�땺�븣)�뿬湲곕줈 由ы꽩
			
			if(searchNum == 0){				//boardList.jsp�쓽 select Name.searchNum遺�遺꾩뿉 option value媛� 0�씪�븣
				list = sqlMapper.queryForList("Message.Msg_selectSearchW", "%"+getSearchKeyword()+"%");	
								//蹂대궦 �궗�엺 而щ읆�쓽 �꽌移섑궎�썙�뱶媛� �룷�븿�맂 紐⑤뱺 �뻾 媛��졇�� list�뿉 ���옣
			}
			if(searchNum == 1){				//boardList.jsp�쓽 select Name.searchNum遺�遺꾩뿉 option value媛� 0�씪�븣
				list = sqlMapper.queryForList("Message.Msg_selectSearchR", "%"+getSearchKeyword()+"%");	
								//諛쏅뒗 �궗�엺 而щ읆�쓽 �꽌移섑궎�썙�뱶媛� �룷�븿�맂 紐⑤뱺 �뻾 媛��졇�� list�뿉 ���옣
			}
			if(searchNum == 2){				//option value媛� 1�씪�븣
				list = sqlMapper.queryForList("Message.Msg_selectSearchC", "%"+getSearchKeyword()+"%");	
								//�궡�슜 (Content)而щ읆�쓽 �꽌移섑궎�썙�뱶媛� �룷�븿�맂 紐⑤뱺 �뻾 媛��졇�� list�뿉 ���옣
			}
			if(searchNum == 3){				//option value媛� 2�씪�븣
				list = sqlMapper.queryForList("Message.Msg_selectSearchD", "%"+getSearchKeyword()+"%");	
								//�궇�옄(content)而щ읆�뿉 �꽌移섑궎�썙�뱶媛� �룷�븿�맂 紐⑤뱺 �뻾 媛��졇�� list�뿉 ���옣
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

