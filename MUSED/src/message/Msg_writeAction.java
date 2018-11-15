package message;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import message.Message_VO;
import member.MemberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException; 



public class Msg_writeAction extends ActionSupport{
	public static Reader reader;	//파일 스트림을 위한 reader
	public static SqlMapClient sqlMapper;	//SqlMapClient API를 사용하기 위한 sqlMapper객체
	
	private Message_VO paramClass;	//파라미터를 저장할 객체
	private Message_VO resultClass;	//쿼리 결과 값을 저장할 객체
	private MemberVO paramClass2;	//파라미터를 저장할 객체
	private MemberVO resultClass2;	//쿼리 결과 값을 저장할 객체
	private List<Message_VO> list = new ArrayList<Message_VO>();
	
	
	
	private int currentPage;	//현재 페이지
	
	private int Msg_No;
	private String msg_wrt_id;
	private String msg_rec_id;
	private String msg_content;
	private String msg_regdate;
	private String session_id;
	private String msg_subject;
	
	private String Member_ID;
	Calendar today = Calendar.getInstance();
	


	
	//생성자
	public Msg_writeAction() throws IOException{
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");//sqlMapConfig.xml파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	//sqlMapConfig.xml의 내용을 적용한 sqlMapper객체 생성.
		
		reader.close();
	}
	
	public String form() throws Exception{
		//등록 폼
		return SUCCESS;
	}
	
	
	//게시판 WRITE액션
	public String execute() throws Exception{
		
		//파라미터와 리절트 객체 생성
		paramClass=new Message_VO();
		resultClass=new Message_VO();
		paramClass2=new MemberVO();

		ActionContext context = ActionContext.getContext();
		Map<String, String> session = (Map<String, String>) context.getSession();
		setMember_ID(session.get("id"));
		
		
		//등록할 항목 설정
		paramClass.setMsg_wrt_id(getMsg_wrt_id());
		paramClass.setMsg_content(getMsg_content());
		paramClass.setMsg_rec_id(getMsg_rec_id());
		paramClass.setMsg_regdate(today.getTime());// 오늘 날짜 설정

	/*	paramClass2.setId(getRec_id());
		*/
		
		System.out.println(getMsg_wrt_id());
		System.out.println(getMsg_content());
		System.out.println(getMsg_rec_id());
		System.out.println(getMsg_regdate());


		/*resultClass2 = (MemberVO) sqlMapper.queryForObject("searchID2", paramClass2);*/
		
	/*	if(resultClass2 == null){
			return ERROR;
		}else{
				
				*/
		         sqlMapper.insert("Message.WriteMessage", paramClass);
	/*}*/
		
		//첨부파일을 선택했다면 파일을 업로드한다.
		return SUCCESS;
	}
	
	public String Form() throws Exception{
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		Msg_writeAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		Msg_writeAction.sqlMapper = sqlMapper;
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

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMsg_No() {
		return Msg_No;
	}

	public void setMsg_No(int msg_No) {
		Msg_No = msg_No;
	}



	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public MemberVO getParamClass2() {
		return paramClass2;
	}

	public void setParamClass2(MemberVO paramClass2) {
		this.paramClass2 = paramClass2;
	}

	public MemberVO getResultClass2() {
		return resultClass2;
	}

	public void setResultClass2(MemberVO resultClass2) {
		this.resultClass2 = resultClass2;
	}

	public String getMember_ID() {
		return Member_ID;
	}

	public void setMember_ID(String member_ID) {
		Member_ID = member_ID;
	}

	public List<Message_VO> getList() {
		return list;
	}

	public void setList(List<Message_VO> list) {
		this.list = list;
	}

	public String getMsg_wrt_id() {
		return msg_wrt_id;
	}

	public void setMsg_wrt_id(String msg_wrt_id) {
		this.msg_wrt_id = msg_wrt_id;
	}

	public String getMsg_rec_id() {
		return msg_rec_id;
	}

	public void setMsg_rec_id(String msg_rec_id) {
		this.msg_rec_id = msg_rec_id;
	}

	public String getMsg_content() {
		return msg_content;
	}

	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}

	public String getMsg_regdate() {
		return msg_regdate;
	}

	public void setMsg_regdate(String msg_regdate) {
		this.msg_regdate = msg_regdate;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getMsg_subject() {
		return msg_subject;
	}

	public void setMsg_subject(String msg_subject) {
		this.msg_subject = msg_subject;
	}
}