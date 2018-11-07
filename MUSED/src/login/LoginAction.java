package login;

import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import member.MemberVO;
import util.CookieBox;

public class LoginAction extends ActionSupport implements SessionAware {

	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private MemberVO paramClass;
	private MemberVO resultClass;

	private HttpServletRequest request;
	private HttpServletResponse response;

	private String id;
	private String password;
	private String cid;

	private int access_num;
	private Date joindate;

	private int chkno;

	private Map session;
	
	private Cookie c[] = null;

	Calendar today = Calendar.getInstance();

	public LoginAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String form() throws Exception {
		return SUCCESS;
	}

	public String login() throws Exception {
		
		//쿠키 사용하기 위한 request, response객체
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		
		cid=request.getParameter("id");
		
		//아이디 저장
		if(request.getParameter("saveId") == null) { 
			response.addCookie(CookieBox.createCookie("ID","","/",-1));	
		} else {
			response.addCookie(CookieBox.createCookie("ID",cid,"/",-1));
		}
		
		//쿠키 저장확인
		/*c = request.getCookies();
		for(int i = 0 ; i<c.length; i++) {
		System.out.println("쿠키이름 : " + c[i].getValue());
		}*/
	
		paramClass = new MemberVO();

		paramClass.setId(getId());
		paramClass.setPassword(getPassword());

		resultClass = (MemberVO) sqlMapper.queryForObject("member.searchpw", getId());

		if (resultClass != null) {
			if (resultClass.getPassword().equals(getPassword())) {

				ActionContext context = ActionContext.getContext();
				session = context.getSession();
				session.put("ID", resultClass.getId());
				context.setSession(session);
				// 관리자면 관리자페이지로 로그인
				if (resultClass.getAccess_num() == 1) {
					return LOGIN;
				}
				return SUCCESS;
			}
		}
		return ERROR;
	}

	public String logout() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, String> session = (Map<String, String>) context.getSession();

		session.remove("ID");

		context.setSession(session); // 다시 session을 적용 시켜서 초기화

		return SUCCESS;
	}

	
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Cookie[] getC() {
		return c;
	}

	public void setC(Cookie[] c) {
		this.c = c;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		LoginAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		LoginAction.sqlMapper = sqlMapper;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccess_num() {
		return access_num;
	}

	public void setAccess_num(int access_num) {
		this.access_num = access_num;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public int getChkno() {
		return chkno;
	}

	public void setChkno(int chkno) {
		this.chkno = chkno;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

}
