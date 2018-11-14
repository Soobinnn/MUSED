package board.free;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class deleteAction extends ActionSupport {
	
	public static Reader reader; //파일 스트림을 위한 reader 객체 생성
	public static SqlMapClient sqlMapper; // SqlMapClient API를 사용하기 위한 sqlMapper 객체 생성
	
	private boardVO paramClass; // boardVO에서 생성한 parameter들을 저장할 객체 paramClass
	private boardVO resultClass; //처리된 쿼리 결과 값을 저장하기 위한 객체 resultClass
	
	private cboardVO cClass = new cboardVO();
	private cboardVO cResult = new cboardVO();
	
	private int currentPage;  //현재 페이지 객체 currentPage
	
	private String fileUploadPath = "c:\\Java\\upload\\";
	
	private int no; // 글 번호 객체 no
	
	private int name;
	// 생성자
	public deleteAction() throws IOException{
		
	  reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml파일의 설정 내용을 가져와서 reader 객체를 생성한다.
	  sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml 내용을 설정한 sqlMapper 객체 생성
	  
	  reader.close(); //reader 객체를 닫는다.
	  
	}
	
	
	// 실행 메소드
	public String execute() throws Exception{
		
		// boardVO에 있는 객체값을 가지고 parameter와 result객체 생성
		paramClass = new boardVO();
		resultClass = new boardVO();
		
		// 해당 번호의 글을 가져온다.
		resultClass = (boardVO) sqlMapper.queryForObject("free.selectOne", getNo());
		
		//서버 파일 삭제
		File deleteFile = new File(fileUploadPath + resultClass.getFile_savname());
		deleteFile.delete();
		
		//삭제할 항목 설정
		paramClass.setNo(getNo());
		
		//삭제 쿼리 수행
		sqlMapper.update("free.deleteBoard", paramClass);
		
		return SUCCESS;
	}
	
	    public String execute2() throws Exception{
	    	cClass = new cboardVO();
	    	cResult = new cboardVO();
	    	
	    	cClass.setNo(getNo());
	    	
	    	
	    sqlMapper.update("free.deleteComment", cClass);
	    	
	    	return SUCCESS;
	    }
	    
	    


	public int getName() {
			return name;
		}


		public void setName(int name) {
			this.name = name;
		}


	public cboardVO getcClass() {
			return cClass;
		}


		public void setcClass(cboardVO cClass) {
			this.cClass = cClass;
		}


		public cboardVO getcResult() {
			return cResult;
		}


		public void setcResult(cboardVO cResult) {
			this.cResult = cResult;
		}


	public static Reader getReader() {
		return reader;
	}


	public static void setReader(Reader reader) {
		deleteAction.reader = reader;
	}


	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}


	public static void setSqlMapper(SqlMapClient sqlMapper) {
		deleteAction.sqlMapper = sqlMapper;
	}


	public boardVO getParamClass() {
		return paramClass;
	}


	public void setParamClass(boardVO paramClass) {
		this.paramClass = paramClass;
	}


	public boardVO getResultClass() {
		return resultClass;
	}


	public void setResultClass(boardVO resultClass) {
		this.resultClass = resultClass;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public String getFileUploadPath() {
		return fileUploadPath;
	}


	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}

}
