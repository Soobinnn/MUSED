package message;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException; 


public class Msg_deleteAction extends ActionSupport {
	public static Reader reader;	//�뙆�씪 �뒪�듃由쇱쓣 �쐞�븳 reader
	public static SqlMapClient sqlMapper;	//SqlMapClient API瑜� �궗�슜�븯湲� �쐞�븳 sqlMapper媛앹껜
	
	private Message_VO paramClass;	//�뙆�씪誘명꽣瑜� ���옣�븷 媛앹껜
	private Message_VO resultClass;	//荑쇰━ 寃곌낵 媛믪쓣 ���옣�븷 媛앹껜
	private Message_VO paramClass2;
	private Message_VO resultClass2;
	
	private List<Message_VO> list = new ArrayList<Message_VO>();

	
	private int currentPage;	//�쁽�옱 �럹�씠吏�
	
	private int msg_no;
	private String msg_wrt_id;
	private String msg_rec_id;
	
	// 생성자
		public Msg_deleteAction() throws IOException {
			
			reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
			reader.close();
		}
	
		public String execute() throws Exception {
			
			//파라미터와 리절트 객체 생성.
			paramClass = new Message_VO();
			resultClass = new Message_VO();
			
			// 해당 번호의 글을 가져온다.
			resultClass = (Message_VO) sqlMapper.queryForObject("Message.Msg_selectOne", getMsg_no());

			
			// 삭제할 항목 설정.
			paramClass.setMsg_wrt_id(getMsg_wrt_id());
			paramClass.setMsg_no(getMsg_no());
			
			// 삭제 쿼리 수행.
			sqlMapper.update("Message.delete_Send", paramClass);

			return SUCCESS;
		}
		
		public String execute2() throws Exception {
			
			//파라미터와 리절트 객체 생성.
			paramClass2 = new Message_VO();
			resultClass2 = new Message_VO();
			
			// 해당 번호의 글을 가져온다.
			resultClass2 = (Message_VO) sqlMapper.queryForObject("Message.Msg_selectOne", getMsg_no());

			System.out.println(getMsg_no());
			
			// 삭제할 항목 설정.
			paramClass2.setMsg_rec_id(getMsg_rec_id());
			paramClass2.setMsg_no(getMsg_no());
			// 삭제 쿼리 수행.
			sqlMapper.update("Message.delete_Read", paramClass2);

			return SUCCESS;
		}

		

		public int getMsg_no() {
			return msg_no;
		}

		public void setMsg_no(int msg_no) {
			this.msg_no = msg_no;
		}

		public String getMsg_wrt_id() {
			return msg_wrt_id;
		}

		public void setMsg_wrt_id(String msg_wrt_id) {
			this.msg_wrt_id = msg_wrt_id;
		}

		public static Reader getReader() {
			return reader;
		}

		public static void setReader(Reader reader) {
			Msg_deleteAction.reader = reader;
		}

		public static SqlMapClient getSqlMapper() {
			return sqlMapper;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			Msg_deleteAction.sqlMapper = sqlMapper;
		}

		public Message_VO getParamClass() {
			return paramClass;
		}

		public void setParamClass(Message_VO paramClass) {
			this.paramClass = paramClass;
		}

		public Message_VO getResultClass() {
			return resultClass;
		}

		public void setResultClass(Message_VO resultClass) {
			this.resultClass = resultClass;
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

		public Message_VO getParamClass2() {
			return paramClass2;
		}

		public void setParamClass2(Message_VO paramClass2) {
			this.paramClass2 = paramClass2;
		}

		public Message_VO getResultClass2() {
			return resultClass2;
		}

		public void setResultClass2(Message_VO resultClass2) {
			this.resultClass2 = resultClass2;
		}

		public String getMsg_rec_id() {
			return msg_rec_id;
		}

		public void setMsg_rec_id(String msg_rec_id) {
			this.msg_rec_id = msg_rec_id;
		}
		
	
	
	
	
	
	
	
	
	
	
	
}
