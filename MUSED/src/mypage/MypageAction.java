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
import product.productVO;
import talent.talentVO;

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
	
	/*����¡�������� �ӽù��� �����ؾ���-����*/
	private String searchKeyword;
	private int searchNum;
	private int num =0;
	
	/*���������� �� �̸�*/
	private String id;
	/*���������� �� ���*/
	private String grade;
	/*��ǰ �Ǹ� ����*/
	private int sellCountProduct;
	/*��� �Ǹ� ����*/
	private int sellCountTalent;
	/*���+��ǰ*/
	private int sum;
	
	/*���� ����� ��ǰ,��ɰ���*/
	private int countPro;
	private int countTal;
	
	private int zzimCount;
	
	private Map session;
	
	private List<productVO> list = new ArrayList<productVO>();
	private List<talentVO> list2 = new ArrayList<talentVO>();
	private productVO resultClass2 = new productVO(); //���� ��� ���� ������ ��ü
	
	private int currentPage=1;	//���� ������
	private int totalCount;		
	private int blockCount=15;   //5*3 �̹��� ����
	private int blockPage=5;
	private String pagingHtml;
	
	private pagingAction1 page1;//��ϵ� ��ǰ ����¡
	private pagingAction2 page2;//��ϵ� ��� ����¡
	private pagingAction3 page3;//�Ǹ��� ��ǰ ����¡
	private pagingAction4 page4;//�Ǹ��� ��� ����¡
	private pagingAction5 page5;//���� ��ǰ ����¡
	private pagingAction6 page6;//���� ��� ����¡
	private String a[];
	
	private String file_orgName; // ���ε� ������ ���� �̸�
	private String file_savName; // ������ ������ ���ε� ������ �̸�. ���� ��ȣ�� �����Ѵ�.

	private File[] upload; // ���� ��ü
	private String[] uploadContentType; // ������ Ÿ��
	private String[] uploadFileName; // ���� �̸�
	private String fileUploadPath = "C:\\Java\\MUSED\\MUSED\\MUSED\\WebContent\\mypage\\image\\"; // ���ε� ���
	
	String file_ext;
	String filePath = "C:\\Java\\MUSED\\MUSED\\MUSED\\WebContent\\mypage\\image\\";
	
	/*������*/
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

				// ���� ������ ����� ���� �̸��� Ȯ���� ����
				String file_name = "file_" + resultClass.getId();
				file_ext = getUploadFileName()[i].substring(getUploadFileName()[i].lastIndexOf('.') + 1,
						getUploadFileName()[i].length());

				// ������ ���� ����
				File destFile = new File(fileUploadPath + file_name + "." + file_ext);
				FileUtils.copyFile(getUpload()[i], destFile);

				// ���� ���� �Ķ���� ����
				paramClass.setId(resultClass.getId());
				paramClass.setFile_orgname(getUploadFileName()[i]);
				paramClass.setFile_savname(file_name + "." + file_ext);
			}
			// ���� ���� ������Ʈ
			sqlMapper.update("member.updateProfile", paramClass);
			
			//����� �����
			String orgImg = filePath + "file_" + resultClass.getId() + "." + file_ext;// ��������
			String thumbImg = filePath + "thum_" + resultClass.getId() + "." + file_ext;// ���������
			int thumbWidth = 160;// ����� ����
			int thumbHeight = 160;// ����� ����
			Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// ����� ����
			Jimi.putImage(thumbnail, thumbImg);// ����� ����
			
		}

		return SUCCESS;
	}
	
	/*���������� ��ϵ� ��ǰ ����Ʈ*/
	public String myProductList() throws Exception {
		common();
		list = sqlMapper.queryForList("product.selectMyProduct",(String)session.get("ID"));
		
		totalCount = list.size();
		
		page1=new pagingAction1(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page1.getPagingHtml().toString();

		
		int lastCount=totalCount;
		
		if(page1.getEndCount()<totalCount) {
			lastCount=page1.getEndCount()+1;
		}
		list=list.subList(page1.getStartCount(), lastCount);
		
		return SUCCESS;
	}
	
	/*���������� ��ϵ� ��� ����Ʈ*/
	public String myTalentList() throws Exception{
		common();
		list2=sqlMapper.queryForList("talent.selectMyTalent",(String)session.get("ID"));
		
		totalCount = list2.size();
		
		page2=new pagingAction2(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page2.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page2.getEndCount()<totalCount) {
			lastCount=page2.getEndCount()+1;
		}
		list2=list2.subList(page2.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	/*���������� ��ǰ �Ǹ� ����*/
	public String mySellProductList() throws Exception{
		common();
		
		list=sqlMapper.queryForList("product.selectMySellProduct",(String)session.get("ID"));
		
		totalCount = list.size();
		
		page3=new pagingAction3(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page3.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page3.getEndCount()<totalCount) {
			lastCount=page3.getEndCount()+1;
		}
		list=list.subList(page3.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	/*���������� ��� �Ǹ� ����*/
	public String mySellTalentList() throws Exception{
		common();
		
		list2=sqlMapper.queryForList("talent.selectMySellTalent",(String)session.get("ID"));
		
		totalCount = list2.size();
		
		page4=new pagingAction4(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page4.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page4.getEndCount()<totalCount) {
			lastCount=page4.getEndCount()+1;
		}
		list2=list2.subList(page4.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	/*���������� �� ��ǰ*/
	public String myZzimProductList() throws Exception{
		common();
		
		list=sqlMapper.queryForList("product.selectMyZzimProduct",(String)session.get("ID"));
		
		totalCount = list.size();
		
		page5=new pagingAction5(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page5.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page5.getEndCount()<totalCount) {
			lastCount=page5.getEndCount()+1;
		}
		list=list.subList(page5.getStartCount(), lastCount);
		return SUCCESS;
	}
	/*���������� �� ���*/
	public String myZzimTalentList() throws Exception{
		common();
		list2=sqlMapper.queryForList("talent.selectMyZzimTalent",(String)session.get("ID"));
		totalCount = list2.size();
		
		page6=new pagingAction6(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page6.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page6.getEndCount()<totalCount) {
			lastCount=page6.getEndCount()+1;
		}
		list2=list2.subList(page6.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	/*ȸ����������*/
	public String modifyForm() throws Exception{
		common();
		resultClass = (MemberVO)sqlMapper.queryForObject("member.selectOne",(String)session.get("ID"));
		return SUCCESS;
	}
	
	/*ȸ����������Ȯ��*/
	public String modifyAction() throws Exception{
		common();
		System.out.println(getAddress1());
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
	
	/*ȸ��Ż��*/
	public String deleteForm() throws Exception{
		common();
		resultClass = (MemberVO)sqlMapper.queryForObject("member.selectOne",(String)session.get("ID"));
		return SUCCESS;
	}
	/*ȸ��Ż��Ϸ�*/
	public String deleteAction() throws Exception{
		common();
		sqlMapper.delete("member.deleteMem",(String)session.get("ID"));
		
		ActionContext context = ActionContext.getContext();
		Map<String, String> session = (Map<String, String>) context.getSession();
		
		session.remove("ID");

		context.setSession(session); // �ٽ� session�� ���� ���Ѽ� �ʱ�ȭ
		return SUCCESS;
	}
	
	/*���������� ����*/
	public void common() throws Exception {
		paramClass = new MemberVO();
		paramClass = (MemberVO)sqlMapper.queryForObject("member.selectOne",(String)session.get("ID"));
		
		/*���������� ���̵�*/
		id = (String)session.get("ID");
		/*���������� ���*/
		if(paramClass.getScore()>500)
			grade = "VVIP";
		else if(paramClass.getScore()>=200)
			grade = "VIP";
		else if(paramClass.getScore()>=150)
			grade = "GOLD";
		else if(paramClass.getScore()>=100)
			grade = "SILVER";
		else if(paramClass.getScore()>=0)
			grade = "BRONZE";
		/*���������� ��ϵ� ��ǰ ��*/
		countPro = (Integer)sqlMapper.queryForObject("product.countProduct",(String)session.get("ID"));
		/*���������� ��ϵ� ��� ��*/
		countTal = (Integer)sqlMapper.queryForObject("talent.countTalent",(String)session.get("ID"));
		/*���������� �� �� ��*/
		zzimCount = (Integer)sqlMapper.queryForObject("zzim.zzimCount",(String)session.get("ID"));
		/*���������� �Ǹ� ����*/
		sellCountProduct = (Integer)sqlMapper.queryForObject("product.countSellProduct",(String)session.get("ID"));
		sellCountTalent = (Integer)sqlMapper.queryForObject("talent.countSellTalent",(String)session.get("ID"));
		sum = sellCountProduct + sellCountTalent;
	
	}
	
	
	

	public List<talentVO> getList2() {
		return list2;
	}

	public void setList2(List<talentVO> list2) {
		this.list2 = list2;
	}

	public int getZzimCount() {
		return zzimCount;
	}

	public void setZzimCount(int zzimCount) {
		this.zzimCount = zzimCount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public pagingAction1 getPage1() {
		return page1;
	}

	public void setPage1(pagingAction1 page1) {
		this.page1 = page1;
	}

	public pagingAction2 getPage2() {
		return page2;
	}

	public void setPage2(pagingAction2 page2) {
		this.page2 = page2;
	}

	public pagingAction3 getPage3() {
		return page3;
	}

	public void setPage3(pagingAction3 page3) {
		this.page3 = page3;
	}

	public pagingAction4 getPage4() {
		return page4;
	}

	public void setPage4(pagingAction4 page4) {
		this.page4 = page4;
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
