package message;

import com.opensymphony.xwork2.ActionSupport;

import message.Message_VO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;

import java.io.IOException;



public class Msg_viewAction<freeBoardc_VO> extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private Message_VO paramClass = new Message_VO();	//�Ķ���͸� ������ ��ü
	private Message_VO resultClass = new Message_VO();	//���� ��� ���� ������ ��ü

	private int check=0;

	

	private int currentPage;
	
	private int msg_no;
	


	//������
	public Msg_viewAction() throws IOException{
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");	//sqlMapConfig.xml������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	//sqlMapConfig.xml�� ������ ������ sqlMapper��ü ����
		
		reader.close();
	}
	
	//�󼼺���
	public String execute() throws Exception{
		
		setCheck(getCheck());
		paramClass = new Message_VO();
		//�ش� ���� ��ȸ�� +1
		paramClass.setMsg_no(getMsg_no());
		System.out.println(paramClass.getMsg_no());
		//�ش� ��ȣ�� ���� �����´�.
		resultClass = (Message_VO)sqlMapper.queryForObject("Message.Msg_selectOne", getMsg_no());
		System.out.println("보내는사람"+resultClass.getMsg_wrt_id());

		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		Msg_viewAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		Msg_viewAction.sqlMapper = sqlMapper;
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

	public int getMsg_no() {
		return msg_no;
	}

	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}
	
}
