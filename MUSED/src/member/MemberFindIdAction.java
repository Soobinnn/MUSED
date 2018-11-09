package member;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;


public class MemberFindIdAction extends ActionSupport implements SessionAware {
		
	private Map session;
	private String name;
	private String email;
	private int jumin1;
	private int jumin2;
	private String id;
	private String phone;
		
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private List<MemberVO> list = new ArrayList<MemberVO>();
	
	private MemberVO paramClass = new MemberVO();
	private MemberVO resultClass = new MemberVO();
	
	public MemberFindIdAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		
		paramClass.setName(getName());
		paramClass.setJumin1(getJumin1());
		paramClass.setJumin2(getJumin2());
		paramClass.setPhone(getPhone());
		paramClass.setEmail(getEmail());
		
		list = sqlMapper.queryForList("member.findId",paramClass);
		
		if(list.size() > 0) {
			return SUCCESS;
		}else {
			return ERROR; //일치하는 아이디가 없습니다.jsp
		}
	}

	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<MemberVO> getList() {
		return list;
	}

	public void setList(List<MemberVO> list) {
		this.list = list;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJumin1() {
		return jumin1;
	}

	public void setJumin1(int jumin1) {
		this.jumin1 = jumin1;
	}

	public int getJumin2() {
		return jumin2;
	}

	public void setJumin2(int jumin2) {
		this.jumin2 = jumin2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		MemberFindIdAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		MemberFindIdAction.sqlMapper = sqlMapper;
	}

	public MemberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(MemberVO paramClass) {
		this.paramClass = paramClass;
	}

	public MemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MemberVO resultClass) 
	{
		this.resultClass = resultClass;
	}
	
	
}
