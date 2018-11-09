package talent;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import java.io.IOException;

public class DeleteAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private talentVO paramClass; //파라미터를 저장할 객체
	private talentVO resultClass; //쿼리 결과 값을 저장할 객체

	private int currentPage;	//현재 페이지
	
	private String fileUploadPath = "C:\\Users\\bogiy\\OneDrive\\바탕 화면\\자바\\MUSED\\MUSED\\WebContent\\talent\\img\\";
	
	private int talent_no;		
	private List<String> image = new ArrayList();
	private String[] a;

	
	// 생성자
	public DeleteAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	// 게시글 글 삭제
	public String execute() throws Exception {
		
		//파라미터와 리절트 객체 생성.
		paramClass = new talentVO();
		resultClass = new talentVO();
		
		// 해당 번호의 글을 가져온다.
		resultClass = (talentVO) sqlMapper.queryForObject("talent.selectOne", getTalent_no());

		//서버 파일 삭제
		File deleteFile = new File(fileUploadPath + resultClass.getMain_img());
		deleteFile.delete();
		
		
		a=resultClass.getTalent_image().split(",");		
		for(int i= 0 ; i < a.length;i++) {
			File deleteFile1 = new File(fileUploadPath+a[i]);
			deleteFile1.delete();
		}
				
		// 삭제할 항목 설정.
		paramClass.setTalent_no(getTalent_no());
				
		// 삭제 쿼리 수행.
		sqlMapper.update("talent.deleteTalent", paramClass);

		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		DeleteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		DeleteAction.sqlMapper = sqlMapper;
	}

	public talentVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(talentVO paramClass) {
		this.paramClass = paramClass;
	}

	public talentVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(talentVO resultClass) {
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

	public int getTalent_no() {
		return talent_no;
	}

	public void setTalent_no(int talent_no) {
		this.talent_no = talent_no;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String[] getA() {
		return a;
	}

	public void setA(String[] a) {
		this.a = a;
	}

	
	
}
