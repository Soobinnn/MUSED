package product;

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

	private productVO paramClass; //파라미터를 저장할 객체
	private productVO resultClass; //쿼리 결과 값을 저장할 객체

	private int currentPage;	//현재 페이지
	
	private String fileUploadPath = "C:\\Users\\bogiy\\OneDrive\\바탕 화면\\자바\\MUSED\\MUSED\\WebContent\\product\\img\\";
	
	private int product_no;		
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
		paramClass = new productVO();
		resultClass = new productVO();
		
		// 해당 번호의 글을 가져온다.
		resultClass = (productVO) sqlMapper.queryForObject("product.selectOne", getProduct_no());

		//서버 파일 삭제
		File deleteFile = new File(fileUploadPath + resultClass.getMain_img());
		deleteFile.delete();
		
		
		a=resultClass.getProduct_image().split(",");		
		for(int i= 0 ; i < a.length;i++) {
			File deleteFile1 = new File(fileUploadPath+a[i]);
			deleteFile1.delete();
		}
				
		// 삭제할 항목 설정.
		paramClass.setProduct_no(getProduct_no());
				
		// 삭제 쿼리 수행.
		sqlMapper.update("product.deleteProduct", paramClass);

		return SUCCESS;
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

	public productVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(productVO paramClass) {
		this.paramClass = paramClass;
	}

	public productVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(productVO resultClass) {
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

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	
}
