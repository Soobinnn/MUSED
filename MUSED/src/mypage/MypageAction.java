package mypage;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import member.MemberVO;
import product.pagingAction;
import product.productVO;


import java.io.File;
import org.apache.commons.io.FileUtils;

import java.awt.Image;
import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiException;
import com.sun.jimi.core.JimiUtils;

public class MypageAction extends ActionSupport implements SessionAware{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private String email;
	private String phone;
	private String zipcode;
	private String address1;
	private String address2;
	
	private MemberVO paramClass;
	private MemberVO resultClass;
	
	/*페이징에러때매 임시방편 수정해야함-수빈*/
	private String searchKeyword;
	private int searchNum;
	private int num =0;
	
	/*마이페이지 내 이름*/
	private String id;
	/*마이페이지 내 등급*/
	private String grade;
	/*제품 판매 개수*/
	private int sellCountProduct;
	/*재능 판매 개수*/
	private int sellCountTalent;
	/*재능+제품*/
	private int sum;
	
	/*내가 등록한 상품,재능개수*/
	private int countPro;
	private int countTal;
	
	private Map session;
	
	private List<productVO> list = new ArrayList<productVO>();
	private productVO resultClass2 = new productVO(); //쿼리 결과 값을 저장할 객체
	
	private int currentPage=1;	//현재 페이지
	private int totalCount;		
	private int blockCount=5;   //5*5 이미지 정렬
	private int blockPage=5;
	private String pagingHtml;
	private pagingAction page;
	private String a[];
	
	private String file_orgName; // 업로드 파일의 원래 이름
	private String file_savName; // 서버에 저장할 업로드 파일의 이름. 고유 번호로 구분한다.

	private File[] upload; // 파일 객체
	private String[] uploadContentType; // 컨텐츠 타입
	private String[] uploadFileName; // 파일 이름
	private String fileUploadPath = "C:\\Java\\upload\\"; // 업로드 경로
	
	String file_ext;
	String filePath = "C:\\Java\\upload\\";
	
	/*생성자*/
	public MypageAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		common();
		return SUCCESS;
	}
	
	public String updateProfile() throws Exception {
		common();
		paramClass = new MemberVO();
		resultClass = new MemberVO();

		if (upload.length > 0) {

			resultClass = (MemberVO) sqlMapper.queryForObject("member.selectOne", (String) session.get("ID"));
			for (int i = 0; i < upload.length; i++) {

				// 실제 서버에 저장될 파일 이름과 확장자 설정
				String file_name = "file_" + resultClass.getId();
				file_ext = getUploadFileName()[i].substring(getUploadFileName()[i].lastIndexOf('.') + 1,
						getUploadFileName()[i].length());

				// 서버에 파일 저장
				File destFile = new File(fileUploadPath + file_name + "." + file_ext);
				FileUtils.copyFile(getUpload()[i], destFile);

				// 파일 정보 파라미터 설정
				paramClass.setId(resultClass.getId());
				paramClass.setFile_orgname(getUploadFileName()[i]);
				paramClass.setFile_savname(file_name + "." + file_ext);
			}
			// 파일 정보 업데이트
			sqlMapper.update("member.updateProfile", paramClass);
			
			//썸네일 만들기
			String orgImg = filePath + "file_" + resultClass.getId() + "." + file_ext;// 원본파일
			String thumbImg = filePath + "thum_" + resultClass.getId() + "." + file_ext;// 썸네일파일
			int thumbWidth = 160;// 썸네일 가로
			int thumbHeight = 160;// 썸네일 세로
			Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// 썸네일 설정
			Jimi.putImage(thumbnail, thumbImg);// 썸네일 생성
			
		}

		return SUCCESS;
	}
	
	/*마이페이지 등록된 상품 리스트*/
	public String myProductList() throws Exception {
		common();
		list = sqlMapper.queryForList("product.selectMyProduct",(String)session.get("ID"));
		
		totalCount = list.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage,searchNum, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) {
			lastCount=page.getEndCount()+1;
		}
		list=list.subList(page.getStartCount(), lastCount);
		
		return SUCCESS;
	}
	
	/*마이페이지 등록된 재능 리스트*/
	public String myTalentList() throws Exception{
		common();
		list=sqlMapper.queryForList("talent.selectMyTalent",(String)session.get("ID"));
		
		totalCount = list.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage,searchNum, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) {
			lastCount=page.getEndCount()+1;
		}
		list=list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	/*마이페이지 제품 판매 내역*/
	public String mySellProductList() throws Exception{
		common();
		list=sqlMapper.queryForList("product.selectMySellProduct",(String)session.get("ID"));
		
		totalCount = list.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage,searchNum, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) {
			lastCount=page.getEndCount()+1;
		}
		list=list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	/*마이페이지 재능 판매 내역*/
	public String mySellTalentList() throws Exception{
		common();
		
		list=sqlMapper.queryForList("talent.selectMySellTalent",(String)session.get("ID"));
		totalCount = list.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage,searchNum, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) {
			lastCount=page.getEndCount()+1;
		}
		list=list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	/*회원정보변경*/
	public String modifyForm() throws Exception{
		common();
		resultClass = (MemberVO)sqlMapper.queryForObject("member.selectOne",(String)session.get("ID"));
		return SUCCESS;
	}
	
	/*회원정보변경확인*/
	public String modifyAction() throws Exception{
		common();
		paramClass = new MemberVO();
		
		paramClass.setId(getId());
		paramClass.setEmail(getEmail());
		paramClass.setPhone(getPhone());
		paramClass.setZipcode(getZipcode());
		paramClass.setAddress1(getAddress1());
		paramClass.setAddress2(getAddress2());
		
		sqlMapper.update("member.modifyInfo",paramClass);
		
		return SUCCESS;
	}
	
	/*회원탈퇴*/
	public String deleteForm() throws Exception{
		common();
		resultClass = (MemberVO)sqlMapper.queryForObject("member.selectOne",(String)session.get("ID"));
		return SUCCESS;
	}
	/*회원탈퇴완료*/
	public String deleteAction() throws Exception{
		common();
		sqlMapper.delete("member.deleteMem",(String)session.get("ID"));
		
		ActionContext context = ActionContext.getContext();
		Map<String, String> session = (Map<String, String>) context.getSession();
		
		session.remove("ID");

		context.setSession(session); // 다시 session을 적용 시켜서 초기화
		return SUCCESS;
	}
	
	/*마이페이지 공통*/
	public void common() throws Exception {
		paramClass = new MemberVO();
		paramClass = (MemberVO)sqlMapper.queryForObject("member.selectOne",(String)session.get("ID"));
		
		/*마이페이지 아이디*/
		id = (String)session.get("ID");
		/*마이페이지 등급*/
		if(paramClass.getScore()>500)
			grade = "VVIP";
		else if(paramClass.getScore()>=200)
			grade = "VIP";
		else if(paramClass.getScore()>=150)
			grade = "GOLD";
		else if(paramClass.getScore()>=100)
			grade = "SILVER";
		else 
			grade = "BRONZE";
		/*마이페이지 등록된 상품 수*/
		countPro = (Integer)sqlMapper.queryForObject("product.countProduct",(String)session.get("ID"));
		/*마이페이지 등록되 재능 수*/
		countTal = (Integer)sqlMapper.queryForObject("talent.countTalent",(String)session.get("ID"));
		
		/*마이페이지 판매 내역*/
		sellCountProduct = (Integer)sqlMapper.queryForObject("product.countSellProduct",(String)session.get("ID"));
		sellCountTalent = (Integer)sqlMapper.queryForObject("talent.countSellTalent",(String)session.get("ID"));
		sum = sellCountProduct + sellCountTalent;
	
	}
	
	
	


	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		MypageAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		MypageAction.sqlMapper = sqlMapper;
	}

	public String getFile_orgName() {
		return file_orgName;
	}

	public void setFile_orgName(String file_orgName) {
		this.file_orgName = file_orgName;
	}

	public String getFile_savName() {
		return file_savName;
	}

	public void setFile_savName(String file_savName) {
		this.file_savName = file_savName;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public String getFile_ext() {
		return file_ext;
	}

	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<productVO> getList() {
		return list;
	}

	public void setList(List<productVO> list) {
		this.list = list;
	}

	public productVO getResultClass2() {
		return resultClass2;
	}

	public void setResultClass2(productVO resultClass2) {
		this.resultClass2 = resultClass2;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public pagingAction getPage() {
		return page;
	}

	public void setPage(pagingAction page) {
		this.page = page;
	}

	public String[] getA() {
		return a;
	}

	public void setA(String[] a) {
		this.a = a;
	}

	public int getSellCountTalent() {
		return sellCountTalent;
	}

	public void setSellCountTalent(int sellCountTalent) {
		this.sellCountTalent = sellCountTalent;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getSellCountProduct() {
		return sellCountProduct;
	}

	public void setSellCountProduct(int sellCountProduct) {
		this.sellCountProduct = sellCountProduct;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public MemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MemberVO resultClass) {
		this.resultClass = resultClass;
	}

	public MemberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(MemberVO paramClass) {
		this.paramClass = paramClass;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCountTal() {
		return countTal;
	}

	public void setCountTal(int countTal) {
		this.countTal = countTal;
	}

	public int getCountPro() {
		return countPro;
	}

	public void setCountPro(int countPro) {
		this.countPro = countPro;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}
	
	

}
