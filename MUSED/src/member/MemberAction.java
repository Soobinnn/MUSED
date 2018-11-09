package member;

import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport implements SessionAware {
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private MemberVO paramClass;
	private MemberVO resultClass;
	
	private String id;
	private String name;
	private String password;
	private int jumin1;
	private int jumin2;
	private String sex;
	private String email;
	private String phone;
	private String zipcode;
	private String address1;
	private String address2;
	private Date joindate;
	private int access_num;
	private int score;
	private int logincount;
	
	private Map session;
	
	Calendar today = Calendar.getInstance();
	
	public MemberAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	
	public String joinConfirm() throws Exception {
		return SUCCESS;
	}
	
	public String joinForm() throws Exception {
		return SUCCESS;
	}
	
	public String join() throws Exception {
		paramClass = new MemberVO();
		
		paramClass.setId(getId());
		paramClass.setName(getName());
		paramClass.setPassword(getPassword());
		paramClass.setJumin1(getJumin1());
		paramClass.setJumin2(getJumin2());
		paramClass.setSex(getSex());
		paramClass.setEmail(getEmail());
		paramClass.setPhone(getPhone());
		paramClass.setZipcode(getZipcode());
		paramClass.setAddress1(getAddress1());
		paramClass.setAddress2(getAddress2());
		paramClass.setJoindate(today.getTime());
		paramClass.setAccess_num(getAccess_num());
		paramClass.setScore(getScore());
		paramClass.setLogincount(getLogincount());
		
		
		sqlMapper.insert("member.memberInsert",paramClass);
		
		return SUCCESS;
	}
	
	
	public String modifyForm() throws Exception{
		resultClass = (MemberVO)sqlMapper.queryForObject("member.selectOne",(String)session.get("ID"));
		return SUCCESS;
	}
	
	public String modifyAction() throws Exception{
		paramClass = new MemberVO();
		
		paramClass.setId(getId());
		paramClass.setEmail(getEmail());
		paramClass.setPhone(getPhone());
		paramClass.setZipcode(getZipcode());
		paramClass.setAddress1(getAddress1());
		paramClass.setAddress2(getAddress2());
		
		sqlMapper.update("member.modifyInfo",paramClass);
		
		return SUCCESS;
	}
	/*ȸ��Ż��*/
	public String deleteForm() throws Exception{
		resultClass = (MemberVO)sqlMapper.queryForObject("member.selectOne",(String)session.get("ID"));
		return SUCCESS;
	}
	/*ȸ��Ż��Ϸ�*/
	public String deleteAction() throws Exception{
		sqlMapper.delete("member.deleteMem",(String)session.get("ID"));
		
		ActionContext context = ActionContext.getContext();
		Map<String, String> session = (Map<String, String>) context.getSession();
		
		session.remove("ID");

		context.setSession(session); // �ٽ� session�� ���� ���Ѽ� �ʱ�ȭ
		return SUCCESS;
	}
	
	
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		MemberAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		MemberAction.sqlMapper = sqlMapper;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public int getAccess_num() {
		return access_num;
	}

	public void setAccess_num(int access_num) {
		this.access_num = access_num;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLogincount() {
		return logincount;
	}

	public void setLogincount(int logincount) {
		this.logincount = logincount;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}
	
	
	

}
