package board.free;

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
	    private String content;
	    private String file_orgName; //업로드 파일의 원래 이름
	    private String file_savName; //서버에 저장할 업로드 파일의 이름, 고유 번호로 구분한다.
	    Calendar today = Calendar.getInstance(); //오늘 날짜 구하기
	    
	    private File upload; //파일 객체, 객체값을 upload로 하고 초기화 한다.
	    private String uploadContentType; //업로드파일의 컨텐츠 타입
	    private String uploadFileName; //업로드 파일의 이름
	    private String fileUploadPath = "c:\\Java\\upload"; //업로드된 파일이 저장될 경로
	    
	    	    
	    /*답변글 객체 생성 추가 ref는 원글의 글번호를 따라가고 re_step과 re_level은 답변글이면 1씩 추가된다.*/
	    private int ref;
	    private int re_step;
	    private int re_level;
	    
	    boolean reply = false;
	    
	    
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
	          
	      
	      //게시판 답변 생성자 추가
	     public String reply() throws Exception{
	    	 
	    	   reply=true; //이 값을 지우면 답글이 제대로 달리지 않거나 원글이 사라진다?
	    	   resultClass = new boardVO(); //자바빈 객체 생성
	    	   
	    	   //[답변]+원글의 제목을 가져오고 나머지 값은 비워둔다.
	    	   resultClass = (boardVO) sqlMapper.queryForObject("free.selectOne", getNo()); //글 번호에 해당하는 한 줄 생성
	    	   resultClass.setSubject("[답변]" + resultClass.getSubject()); //답변 쓰고 꺼내온 제목 출력
	    	   /*resultClass.setPassword(""); */
	    	   resultClass.setName("#session.ID");
	    	   resultClass.setContent("");
	    	   resultClass.setFile_orgname(null);
	    	   resultClass.setFile_savname(null);
	    	   
	    	   return SUCCESS;
	     }
	      
	          public String execute() throws Exception{
	    	   paramClass = new boardVO();
	    	   resultClass = new boardVO();
	    	   
	    	   if(ref==0) { //ref==0, 답글이 아닌 원글이라는 의미. 답글이면 ref값이 0이 나올 수가 없다. 원글의 ref값을 답글이 가져가기 때문이다.
	    		   paramClass.setRe_step(0);
	    		   paramClass.setRe_level(0);
	    	   
	    	   }else {
	      
	    		   paramClass.setRef(getRef()); //전송된 값으로 설정
	    		   paramClass.setRe_step(getRe_step());
	    		   sqlMapper.update("free.updateReplyStep", paramClass); //업데이트 실행, sql문의 updateReplyStep을 호출하여 re_step값을 증가시킨다.
	    		   
	    		   paramClass.setRe_step(getRe_step() +1); // 답변글인 경우, re_step과 re_level값을 1씩 증가시킨다.
	    		   paramClass.setRe_level(getRe_level() + 1);
	    		   paramClass.setRef(getRef());
	    	         }
	    	  
	      
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
	    	  
	    	  if(ref == 0 ) {
	    		    sqlMapper.insert("free.insertBoard", paramClass);
	    	  }else {
	    		  	    	  
	    	  //등록 쿼리 수행
	    	  sqlMapper.insert("free.insertBoard", paramClass); //ref값에 상관없이? insertBoard 쿼리를 수행한다.
	    	  }
	    	  //선택된 첨부파일이 있다면 업로드를 수행한다. getUpload()메소드
	      if(getUpload() != null) {
	    	  
	    	  //등록한 글 번호 가져오기
	    	  resultClass= (boardVO) sqlMapper.queryForObject("free.selectLastNo");
	    	  
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
	    	   sqlMapper.update("free.updateFile", paramClass);
	      }
	      return SUCCESS;
	      }

		public int getRef() {
			return ref;
		}

		public void setRef(int ref) {
			this.ref = ref;
		}

		public int getRe_step() {
			return re_step;
		}

		public void setRe_step(int re_step) {
			this.re_step = re_step;
		}

		public int getRe_level() {
			return re_level;
		}

		public void setRe_level(int re_level) {
			this.re_level = re_level;
		}

		public boolean isReply() {
			return reply;
		}

		public void setReply(boolean reply) {
			this.reply = reply;
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