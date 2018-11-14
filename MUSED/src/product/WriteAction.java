package product;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import org.apache.struts2.interceptor.SessionAware;
import member.MemberVO;

import java.util.*;
import java.io.Reader;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import product.productVO;

public class WriteAction extends ActionSupport implements SessionAware {

	public static Reader reader; // 파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private productVO paramClass; // 파라미터를 저장할 객체(ibatis에서 꺼내온거 받기위해)
	private productVO resultClass; // 쿼리 결과 값을 저장할 객체(select문 처리->받기위해)

	private MemberVO Mparam;
	private MemberVO Mresult;

	private int currentPage; // 현재 페이지

	private String product_id;
	private String product_state;
	private String product_subject;
	private String product_name;
	private String product_category;
	private String product_brand;
	private int product_price;
	private String product_type;
	private String product_phone;
	private String product_sido;
	private String product_gogon;
	private String product_image;
	private String product_content;
	private String main_img;
	private File[] upload;
	private String[] uploadFileName;
	private String[] uploadContentType;

	private String fileUploadPath = "C:\\Users\\DONGKUK\\git\\MUSED\\MUSED\\WebContent\\product\\img\\";

	private String imageName = "";
	private String MainName = "";
	private String type = "";

	private Map session;

	// 생성자
	public WriteAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	public String form() throws Exception {
		// 등록 폼.
		return SUCCESS;
	}

	// 게시판 WRITE 액션
	public String execute() throws Exception {

		// 파라미터와 리절트 객체 생성.
		paramClass = new productVO();
		resultClass = new productVO();

		// 등록할 항목 설정.
		paramClass.setProduct_id((String) session.get("ID"));
		paramClass.setProduct_state(getProduct_state());
		paramClass.setProduct_subject(getProduct_subject());
		paramClass.setProduct_name(getProduct_name());
		paramClass.setProduct_category(getProduct_category());
		paramClass.setProduct_brand(getProduct_brand());
		paramClass.setProduct_price(getProduct_price());
		paramClass.setProduct_type(getProduct_type());
		paramClass.setProduct_phone(getProduct_phone());
		paramClass.setProduct_sido(getProduct_sido());
		paramClass.setProduct_gogon(getProduct_gogon());
		paramClass.setProduct_content(getProduct_content());

		if (upload.length > 0) {
			for (int i = 0; i < upload.length; i++) {
				File destFile = new File(fileUploadPath + getUploadFileName()[i]);
				FileUtils.copyFile(getUpload()[i], destFile);
				if (i == 0) {
					MainName += getUploadFileName()[0];
					imageName += getUploadFileName()[i];
				} else {
					imageName += (getUploadFileName()[i].equals("")) ? getUploadFileName()[i]
							: "," + getUploadFileName()[i];
				}
			}
		}
		paramClass.setMain_img(MainName);
		paramClass.setProduct_image(imageName);
		// 등록 쿼리 수행.

		sqlMapper.insert("product.insertProduct", paramClass);	//입력 : insert
				   //”insert의 id값”
		
		sqlMapper.update("product.writeScore", (String)session.get("ID"));	//등록 시 점수 증가
		

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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getMainName() {
		return MainName;
	}

	public void setMainName(String mainName) {
		MainName = mainName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getMain_img() {
		return main_img;
	}

	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}

	public static void setReader(Reader reader) {
		WriteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		WriteAction.sqlMapper = sqlMapper;
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

	public String getProduct_state() {
		return product_state;
	}

	public void setProduct_state(String product_state) {
		this.product_state = product_state;
	}

	public String getProduct_subject() {
		return product_subject;
	}

	public void setProduct_subject(String product_subject) {
		this.product_subject = product_subject;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getProduct_phone() {
		return product_phone;
	}

	public void setProduct_phone(String product_phone) {
		this.product_phone = product_phone;
	}

	public String getProduct_sido() {
		return product_sido;
	}

	public void setProduct_sido(String product_sido) {
		this.product_sido = product_sido;
	}

	public String getProduct_gogon() {
		return product_gogon;
	}

	public void setProduct_gogon(String product_gogon) {
		this.product_gogon = product_gogon;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_content() {
		return product_content;
	}

	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

}
