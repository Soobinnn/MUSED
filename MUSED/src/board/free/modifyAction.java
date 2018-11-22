package board.free;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.FileUtils;

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
	  private String old_file;
	  
	  private File upload; // 파일객체 upload 생성
	  private String uploadContentType; // 업로드파일의 형식
	  private String uploadFileName; // 업로드되는 파일의 이름
	  private String fileUploadPath = "/MUSED/board/img/"; //파일이 업로드되는 경로
	  
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
		  sqlMapper.update("free.updateBoard", paramClass);
		  
		  // DB에 파일이 업로드되었다면 DB의 파일 항목을 수정한다.
		    if(getUpload() != null) {
		    	
		    	  //실제 서버에 저장될 파일의 이름과 확장자 설정
		    	  String file_name = "file_" + getNo();
		    	  String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+
		    			  1, getUploadFileName().length());
		    	  
		    	  //수정하기 이전의 파일을 삭제한다.
		    	  File deleteFile = new File(fileUploadPath + getOld_file());
		    	  deleteFile.delete();
		    	  
		    	  //새 파일을 업로드한다.
		    	  File destFile = new File(fileUploadPath + file_name+"."+file_ext);
		    	  FileUtils.copyFile(getUpload(), destFile);
		    	  
		    	  //파일 정보 파라미터 설정
		    	  paramClass.setFile_orgname(getUploadFileName());
		    	  paramClass.setFile_savname(file_name+"."+file_ext);
		    	  
		    	  //파일 정보 업데이트
		    	  sqlMapper.update("free.updateFile", paramClass);
		    }
		    
		      //수정이 끝나면 view페이지로 이동, boardSQL.xml에 있는 selectOne을 호출한다.
		     //queryForObject ->DB로부터 1개의 레코드를 가져와 자바 객체에 저장한다.오직 한개만. 그 이상이 반환되면 예외처리되며 값이 없을 경우 null을 반환한다.
		    resultClass = (boardVO) sqlMapper.queryForObject("free.selectOne", getNo());
		    
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

	public String getOld_file() {
		return old_file;
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

	public void setOld_file(String old_file) {
		this.old_file = old_file;
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