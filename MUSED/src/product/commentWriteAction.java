package product;

import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.*;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import org.apache.struts2.interceptor.SessionAware;
import member.MemberVO;

import java.util.*;
import java.io.Reader;
import java.io.IOException;
public class commentWriteAction extends ActionSupport implements SessionAware{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	public product_cVO paramClass;
	public product_cVO resultClass;
	
	private MemberVO Mparam;
	private MemberVO Mresult;
	
	private int c_no;
	private int currentPage;
	
	private int c_contnum;		// 댓글 해당 글 번호
	private String c_id; 		// 아이디
	private String c_content; 	// 댓글 내용
	private Date c_regdate;   	// 날짜
	
	private Map session;
	
	Calendar today=Calendar.getInstance();
	
	public commentWriteAction() throws IOException{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception{
		return SUCCESS;
	}
	
	public String execute() throws Exception{
		paramClass=new product_cVO();
		resultClass=new product_cVO();
			
		paramClass.setC_contnum(getC_contnum());
		paramClass.setC_id((String)session.get("ID"));
		paramClass.setC_content(getC_content());
		paramClass.setC_regdate(today.getTime());
	
		sqlMapper.insert("product.insertComment",paramClass);
		
		sqlMapper.update("product.CwriteScore", (String)session.get("ID"));	//등록 시 점수 증가
		
		return SUCCESS;
	}
		
	
	public MemberVO getMparam() {
		return Mparam;
	}

	public void setMparam(MemberVO mparam) {
		Mparam = mparam;
	}

	public MemberVO getMresult() {
		return Mresult;
	}

	public void setMresult(MemberVO mresult) {
		Mresult = mresult;
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
		commentWriteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		commentWriteAction.sqlMapper = sqlMapper;
	}

	public product_cVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(product_cVO paramClass) {
		this.paramClass = paramClass;
	}

	public product_cVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(product_cVO resultClass) {
		this.resultClass = resultClass;
	}


	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getC_contnum() {
		return c_contnum;
	}

	public void setC_contnum(int c_contnum) {
		this.c_contnum = c_contnum;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public Date getC_regdate() {
		return c_regdate;
	}

	public void setC_regdate(Date c_regdate) {
		this.c_regdate = c_regdate;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}
	
}