package member;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class MemberFindPwAction extends ActionSupport implements SessionAware {
	
	private Map session;
	private String id;
	private String name;
	private int jumin1;
	private int jumin2;
	private String phone;
	private String password;
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private MemberVO paramClass;
	private MemberVO resultClass;
	
	public MemberFindPwAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String modifyPw() throws Exception {
		
		paramClass = new MemberVO();
		
		paramClass.setId(getId());
		paramClass.setPassword(getPassword());
		
		sqlMapper.update("member.modifyPw",paramClass);
		
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		
		paramClass = new MemberVO();
		resultClass = new MemberVO();
		
		paramClass.setId(getId());
		paramClass.setName(getName());
		paramClass.setPhone(getPhone());
		paramClass.setJumin1(getJumin1());
		paramClass.setJumin2(getJumin2());
		
		resultClass = (MemberVO) sqlMapper.queryForObject("member.findPw",paramClass);
		
		if(resultClass != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		MemberFindPwAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		MemberFindPwAction.sqlMapper = sqlMapper;
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

	public void setResultClass(MemberVO resultClass) {
		this.resultClass = resultClass;
	}
	
	

}
