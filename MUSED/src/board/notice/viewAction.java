package board.notice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class viewAction extends ActionSupport {
	  public static Reader reader;
	  public static SqlMapClient sqlMapper;
	  
	  private boardVO paramClass = new boardVO(); //boardVO에서 생성한 parameter들을 저장할 객체 paramClass
	  private boardVO resultClass = new boardVO(); //처리된 쿼리 결과 값을 저장하기 위한 객체
	 	  
	  private int currentPage;
	  
	  private int no;
	  private int originno;
	  
	  private String password;
	  
	  private String fileUploadPath = "c:\\Java\\upload\\";
	  
	  private InputStream inputStream;
	  private String contentDisposition; //파일명?파일 속성과 관련된 객체 생성
	  private long contentLength;
	  
	  //생성자
	  public viewAction() throws IOException{
		   
		  reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml xml파일의 설정 내용을 가져와서 reader 객체를 생성한다.
		  sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);//sqilMapConfig.xml의 내용을 적용한 sqlMapper객체 생성
		  
		  reader.close();
	  }

	  //실행 메소드
	  public String execute() throws Exception{
		  
		   // 해당 글의 조회수 +1
		    paramClass.setNo(getNo()); //글 번호 생성
		    sqlMapper.update("notice.updateReadHit", paramClass); // 조회수 증가
		    
		    //해당 번호의 글을 가져온다.
		    //queryForObect : DB로부터 1개의 레코드를 가져와 저장한다. 두개 이상의 레코드가 반환되는 경우 예외처리되며 값이 없을 경우 null을 반환한다.
		    //queryForList : DB로부터 2개 이상의 레코드를 가져와 자바 객체의 List를 만드는 데 사용한다.
		    resultClass = (boardVO) sqlMapper.queryForObject("notice.selectOne", getNo());
		    
		    		    
		    return SUCCESS;
	  }

       //첨부 파일 다운로드
	  public String download() throws Exception{
		    
		  //해당 번호의 파일 정보를 가져온다.
		  resultClass = (boardVO) sqlMapper.queryForObject("notice.selectOne", getNo());
		  
		  //파일 경로와 파일명을 file객체에 넣는다.
		  File fileInfo = new File(fileUploadPath + resultClass.getFile_savname());
		  
		  System.out.print(resultClass.getFile_savname());
		  
		  //다운로드 파일 정보 설정
		  setContentLength(fileInfo.length());
		  setContentDisposition("attachment;filename=" + URLEncoder.encode(resultClass.getFile_orgname(), "utf-8")); //파일이 한글인 경우 깨지는 것을 방지
		  setInputStream(new FileInputStream(fileUploadPath + resultClass.getFile_savname()));
		  
	      /*File fileInfo = new File(fileUploadPath + fileDownloadName);
	      setContentLength(fileInfo.length());
	      setContentDisposition("attachment; filename="+URLEncoder.encode(fileDownloadName, "utf-8"));
		  setInputStream(new FileInputStream(fileUploadPath + fileDownloadName));*/
		  
		  return SUCCESS;
	  }
	  
	   //비밀번호 체크 폼 -> checkPassword.jsp로 연결된다
	    public String checkForm() throws Exception{
	    	
	    	return SUCCESS;
	    }
	    
	    //비밀번호 체크 액션 -> checkAction 메소드는 error리턴 시 checkError.jsp로 연결되고 success리턴 시 checkSuccess.jsp로 연결된다.
	    public String checkAction() throws Exception{
	    	
	    	  // 비밀번호 입력값 파라미터 설정
	    	paramClass.setNo(getNo()); //글 번호를 받는다
	    	paramClass.setPassword(getPassword()); //비밀번호를 받는다
	    	
	    	//현재 글의 비밀번호 가져오기
	    	resultClass = (boardVO) sqlMapper.queryForObject("notice.selectPassword", paramClass);
	    	
	    	//입력 시 비밀번호가 틀리면 ERROR 리턴
	    	if(resultClass == null)
	    		return ERROR;
	    	
	    	return SUCCESS;
	    }

       
		public int getOriginno() {
			return originno;
		}

		public void setOriginno(int originno) {
			this.originno = originno;
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

		public String getPassword() {
			return password;
		}

		public String getFileUploadPath() {
			return fileUploadPath;
		}

		public InputStream getInputStream() {
			return inputStream;
		}

		public String getContentDisposition() {
			return contentDisposition;
		}

		public long getContentLength() {
			return contentLength;
		}

		public static void setReader(Reader reader) {
			viewAction.reader = reader;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			viewAction.sqlMapper = sqlMapper;
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

		public void setPassword(String password) {
			this.password = password;
		}

		public void setFileUploadPath(String fileUploadPath) {
			this.fileUploadPath = fileUploadPath;
		}

		public void setInputStream(InputStream inputStream) {
			this.inputStream = inputStream;
		}

		public void setContentDisposition(String contentDisposition) {
			this.contentDisposition = contentDisposition;
		}

		public void setContentLength(long contentLength) {
			this.contentLength = contentLength;
		}
	    
}	    