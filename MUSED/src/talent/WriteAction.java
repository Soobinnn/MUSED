package talent;

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

import talent.talentVO;

public class WriteAction extends ActionSupport implements SessionAware{

	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private talentVO paramClass; //파라미터를 저장할 객체(ibatis에서 꺼내온거 받기위해)
	private talentVO resultClass; //쿼리 결과 값을 저장할 객체(select문 처리->받기위해)

	private MemberVO Mparam;
	private MemberVO Mresult;
	
	private int currentPage; //현재 페이지

	private String talent_id;
	private String talent_state;
	private String talent_subject;
	private String talent_name;
	private String talent_category;
	private int talent_price;
	private String talent_phone;
	private String talent_sido;
	private String talent_gogon;
	private String talent_image;
	private String talent_content;
	private String main_img;
	private File[] upload;
	private String[] uploadFileName;
	private String[] uploadContentType;
	private String fileUploadPath="C:\\Java\\MUSED\\MUSED\\MUSED\\WebContent\\talent\\img\\";

	private String imageName="";
	private String MainName="";
	
	private Map session;
	// 생성자
	public WriteAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	public String form() throws Exception {
		//등록 폼.
		return SUCCESS;
	}

	
	// 게시판 WRITE 액션
	public String execute() throws Exception {

		//파라미터와 리절트 객체 생성.
		paramClass = new talentVO();
		resultClass = new talentVO();
		
		// 등록할 항목 설정.
		paramClass.setTalent_id((String)session.get("ID"));
		paramClass.setTalent_state(getTalent_state());
		paramClass.setTalent_subject(getTalent_subject());
		paramClass.setTalent_name(getTalent_name());
		paramClass.setTalent_category(getTalent_category());
		paramClass.setTalent_price(getTalent_price());
		paramClass.setTalent_phone(getTalent_phone());
		paramClass.setTalent_sido(getTalent_sido());
		paramClass.setTalent_gogon(getTalent_gogon());
		paramClass.setTalent_content(getTalent_content());		

		for(int i=0;i<upload.length;i++) {
			File destFile = new File(fileUploadPath + getUploadFileName()[i]);
			FileUtils.copyFile(getUpload()[i], destFile);
			if(i==0) {
				MainName += getUploadFileName()[0];
				imageName += getUploadFileName()[i];
			}else{
				imageName += (getUploadFileName()[i].equals(""))?getUploadFileName()[i]:","+getUploadFileName()[i];
			}
		}
		paramClass.setMain_img(MainName);
		paramClass.setTalent_image(imageName);
		// 등록 쿼리 수행.
		sqlMapper.insert("talent.insertTalent", paramClass);	//입력 : insert
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

	public String getMainName() {
		return MainName;
	}

	public void setMainName(String mainName) {
		MainName = mainName;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getMain_img() {
		return main_img;
	}

	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}

	public static Reader getReader() {
		return reader;
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

	public String getTalent_id() {
		return talent_id;
	}

	public void setTalent_id(String talent_id) {
		this.talent_id = talent_id;
	}

	public String getTalent_state() {
		return talent_state;
	}

	public void setTalent_state(String talent_state) {
		this.talent_state = talent_state;
	}

	public String getTalent_subject() {
		return talent_subject;
	}

	public void setTalent_subject(String talent_subject) {
		this.talent_subject = talent_subject;
	}

	public String getTalent_name() {
		return talent_name;
	}

	public void setTalent_name(String talent_name) {
		this.talent_name = talent_name;
	}

	public String getTalent_category() {
		return talent_category;
	}

	public void setTalent_category(String talent_category) {
		this.talent_category = talent_category;
	}

	public int getTalent_price() {
		return talent_price;
	}

	public void setTalent_price(int talent_price) {
		this.talent_price = talent_price;
	}


	public String getTalent_phone() {
		return talent_phone;
	}

	public void setTalent_phone(String talent_phone) {
		this.talent_phone = talent_phone;
	}

	public String getTalent_sido() {
		return talent_sido;
	}

	public void setTalent_sido(String talent_sido) {
		this.talent_sido = talent_sido;
	}

	public String getTalent_gogon() {
		return talent_gogon;
	}

	public void setTalent_gogon(String talent_gogon) {
		this.talent_gogon = talent_gogon;
	}

	public String getTalent_image() {
		return talent_image;
	}

	public void setTalent_image(String talent_image) {
		this.talent_image = talent_image;
	}

	public String getTalent_content() {
		return talent_content;
	}

	public void setTalent_content(String talent_content) {
		this.talent_content = talent_content;
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	

}
