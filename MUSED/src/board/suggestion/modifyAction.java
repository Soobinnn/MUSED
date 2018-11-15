package board.suggestion;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class modifyAction extends ActionSupport {
	
	  public static Reader reader;
	  public static SqlMapClient sqlMapper;
	  
	  private boardVO paramClass; // parameter를 저장할 객체 paramClass
	  private boardVO resultClass; // 쿼리 결과값을 저장할 객체 resultClass
	  
	  private int currentPage;
	  
	  private int no;
	  private String subject;
	  private String name;
	  private String password;
	  private String content;

	  
		  
	  // 생성자
	  public modifyAction() throws IOException{

       reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml 파일의 설정 내용을 가져와서 reader 객체를 생성
       sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml의 내용을 담은 sqlMapper 생성
       
       reader.close();
       
	  }
	  
	  // 게시글 수정 실행
	  public String execute() throws Exception{
		  
		    //parameter와 result 객체 생성
		paramClass= new boardVO(); //파라미터를 저장할 객체
		resultClass= new boardVO(); //쿼리 결과 값을 저장할 객체
		  
		  //수정할 항목 설정.(게시판에서 수정하기를 눌렀을 때 수정이 되는 항목들)
		  paramClass.setNo(getNo()); //struts.xml에서 설정해놓은 대로 간다.
		  paramClass.setSubject(getSubject());
		  paramClass.setName(getName());
		  paramClass.setPassword(getPassword());
		  paramClass.setContent(getContent());
		  
		  
		  //일단 항목만 수정?
		  sqlMapper.update("sug.updateBoard", paramClass);
		   //수정이 끝나면 view페이지로 이동, boardSQL.xml에 있는 selectOne을 호출한다.
		     //queryForObject ->DB로부터 1개의 레코드를 가져와 자바 객체에 저장한다.오직 한개만. 그 이상이 반환되면 예외처리되며 값이 없을 경우 null을 반환한다.
		    resultClass = (boardVO) sqlMapper.queryForObject("sug.selectOne", getNo());
		    
		    return SUCCESS;
		    
		    }

	public static Reader getReader() {
		return reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public boardVO getParamClass() {
		return paramClass;
	}

	public boardVO getResultClass() {
		return resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getNo() {
		return no;
	}

	public String getSubject() {
		return subject;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getContent() {
		return content;
	}

	

	public static void setReader(Reader reader) {
		modifyAction.reader = reader;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		modifyAction.sqlMapper = sqlMapper;
	}

	public void setParamClass(boardVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(boardVO resultClass) {
		this.resultClass = resultClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContent(String content) {
		this.content = content;
	}

}	  