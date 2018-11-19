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
	public static Reader reader;	//�뙆�씪 �뒪�듃由쇱쓣 �쐞�븳 reader
	public static SqlMapClient sqlMapper;	//SqlMapClient API瑜� �궗�슜�븯湲� �쐞�븳 sqlMapper媛앹껜
	
	private Message_VO paramClass;	//�뙆�씪誘명꽣瑜� ���옣�븷 媛앹껜
	private Message_VO resultClass;	//荑쇰━ 寃곌낵 媛믪쓣 ���옣�븷 媛앹껜
	private MemberVO paramClass2;	//�뙆�씪誘명꽣瑜� ���옣�븷 媛앹껜
	private MemberVO resultClass2;	//荑쇰━ 寃곌낵 媛믪쓣 ���옣�븷 媛앹껜
	private List<Message_VO> list = new ArrayList<Message_VO>();
	
	
	
	private int currentPage;	//�쁽�옱 �럹�씠吏�
	
	private int Msg_No;
	private String msg_wrt_id;
	private String msg_rec_id;
	private String msg_content;
	private String msg_regdate;
	private String session_id;
	private String msg_subject;
	
	private String Member_ID;
	Calendar today = Calendar.getInstance();
	


	
	//�깮�꽦�옄
	public Msg_writeAction() throws IOException{
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");//sqlMapConfig.xml�뙆�씪�쓽 �꽕�젙�궡�슜�쓣 媛��졇�삩�떎.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	//sqlMapConfig.xml�쓽 �궡�슜�쓣 �쟻�슜�븳 sqlMapper媛앹껜 �깮�꽦.
		
		reader.close();
	}
	
	public String form() throws Exception{
		//�벑濡� �뤌
		return SUCCESS;
	}
	
	
	//寃뚯떆�뙋 WRITE�븸�뀡
	public String execute() throws Exception{
		
		//�뙆�씪誘명꽣�� 由ъ젅�듃 媛앹껜 �깮�꽦
		paramClass=new Message_VO();
		resultClass=new Message_VO();
		paramClass2=new MemberVO();

		ActionContext context = ActionContext.getContext();
		Map<String, String> session = (Map<String, String>) context.getSession();
		setMember_ID(session.get("id"));
		
		
		//�벑濡앺븷 �빆紐� �꽕�젙
		paramClass.setMsg_wrt_id(getMsg_wrt_id());
		paramClass.setMsg_content(getMsg_content());
		paramClass.setMsg_rec_id(getMsg_rec_id());
		paramClass.setMsg_regdate(today.getTime());// �삤�뒛 �궇吏� �꽕�젙

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
		
		//泥⑤��뙆�씪�쓣 �꽑�깮�뻽�떎硫� �뙆�씪�쓣 �뾽濡쒕뱶�븳�떎.
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
