package board.notice;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class writeAction extends ActionSupport {
	
	    public static Reader reader; //파일 스트림을 위한 reader
	    public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체
	    
	    private boardVO paramClass; // 파라미터를 저장할 객체
	    private boardVO resultClass; //쿼리 결과 값을 저장할 객체
	    
	    private int currentPage; //현재 페이지
	    
	    private int no;
	    private String subject;
	    private String name;
	    private String password;
	    private String content;
	    private String file_orgName; //업로드 파일의 원래 이름
	    private String file_savName; //서버에 저장할 업로드 파일의 이름, 고유 번호로 구분한다.
	    Calendar today = Calendar.getInstance(); //오늘 날짜 구하기
	    
	    private File upload; //파일 객체, 객체값을 upload로 하고 초기화 한다.
	    private String uploadContentType; //업로드파일의 컨텐츠 타입
	    private String uploadFileName; //업로드 파일의 이름
	    private String fileUploadPath = "c:\\Java\\upload\\"; //업로드된 파일이 저장될 경로
	    
	    	    
	       
	    
	    
	    //생성자, reader를 쓸 때 입출력관련 IOException 선언
	    public writeAction() throws IOException{
	    	
	    	  reader = Resources.getResourceAsReader("sqlMapConfig.xml");// sqlMapConfig.xml의 설정 내용을 가져와서 reader객체를 생성한다.
	    	  sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성
	    	  
	    	  reader.close();
	    }
	    
	      public String form() throws Exception{
	    	  // 등록 폼, struts.xml에 등록한다. 
	    	  return SUCCESS;
	      }
	          
	      
	   	      
	      public String execute() throws Exception{
	    	   paramClass = new boardVO();
	    	   resultClass = new boardVO();
	    	   
	    	 
	      
	    /*  
	      // 게시판 WRITE 액션
	      public String execute() throws Exception{*/
	    	  
//	    	    // parameter와 result 객체 생성
//	    	  paramClass = new boardVO();
//	    	  resultClass = new boardVO();
	    	  
	    	  //등록할 항목 설정, boardVO에서 생성한 객체들을 가져와서 쓸 수 있게 세팅한다.
	    	  paramClass.setSubject(getSubject()); 
	    	  paramClass.setName(getName());
	    	  paramClass.setContent(getContent());
	    	  paramClass.setRegdate(today.getTime());
	    	  
	    	sqlMapper.insert("notice.insertBoard", paramClass);
	    	 
	    	  //선택된 첨부파일이 있다면 업로드를 수행한다. getUpload()메소드
	      if(getUpload() != null) {
	    	  
	    	  //등록한 글 번호 가져오기
	    	  resultClass= (boardVO) sqlMapper.queryForObject("notice.selectLastNo");
	    	  
	    	  //실제 서버에 저장될 파일 이름과 확장자 설정
	    	  String file_name = "file_" + resultClass.getNo();
	    	  String file_ext =    //lastIndexOf는 ()안에 들어간 문자뒤부터 찾아서 가져온다.
	    			  getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,
	    					                        getUploadFileName().length());
	    	  
	    	  //서버에 파일 저장
	    	   File destFile = new File(fileUploadPath + file_name+ "." + file_ext);
	    	   FileUtils.copyFile(getUpload(), destFile);
	    	   
	    	   //파일 정보 파라미터 설정
	    	   paramClass.setNo(resultClass.getNo());
	    	   paramClass.setFile_orgname(getUploadFileName()); // 원래 파일 이름
	    	   paramClass.setFile_savname(file_name + "." + file_ext); // 서버에 저장한 파일 이름
	    	   
	    	   //파일 정보 업데이트
	    	   sqlMapper.update("notice.updateFile", paramClass);
	      }
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

		public String getFile_orgName() {
			return file_orgName;
		}

		public String getFile_savName() {
			return file_savName;
		}

		public Calendar getToday() {
			return today;
		}

		public File getUpload() {
			return upload;
		}

		public String getUploadContentType() {
			return uploadContentType;
		}

		public String getUploadFileName() {
			return uploadFileName;
		}

		public String getFileUploadPath() {
			return fileUploadPath;
		}

		public static void setReader(Reader reader) {
			writeAction.reader = reader;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			writeAction.sqlMapper = sqlMapper;
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

		public void setFile_orgName(String file_orgName) {
			this.file_orgName = file_orgName;
		}

		public void setFile_savName(String file_savName) {
			this.file_savName = file_savName;
		}

		public void setToday(Calendar today) {
			this.today = today;
		}

		public void setUpload(File upload) {
			this.upload = upload;
		}

		public void setUploadContentType(String uploadContentType) {
			this.uploadContentType = uploadContentType;
		}

		public void setUploadFileName(String uploadFileName) {
			this.uploadFileName = uploadFileName;
		}

		public void setFileUploadPath(String fileUploadPath) {
			this.fileUploadPath = fileUploadPath;
		}
}