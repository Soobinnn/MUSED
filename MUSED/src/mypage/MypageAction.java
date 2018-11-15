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
	
	private Map session;
	
	private List first = new ArrayList();
	private List<productVO> list = new ArrayList<productVO>();
	private productVO resultClass2 = new productVO(); //���� ��� ���� ������ ��ü
	
	private int currentPage=1;	//���� ������
	private int totalCount;		
	private int blockCount=5;   //5*5 �̹��� ����
	private int blockPage=5;
	private String pagingHtml;
	private pagingAction page;
	private String a[];
	
	
	
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
	
	/*���������� ��ϵ� ��ǰ ����Ʈ*/
	public String myProductList() throws Exception {
		common();
		list = sqlMapper.queryForList("product.selectMyProduct",(String)session.get("ID"));
		
		totalCount = list.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) {
			lastCount=page.getEndCount()+1;
		}
		list=list.subList(page.getStartCount(), lastCount);
		
		return SUCCESS;
	}
	
	/*���������� ��ϵ� ��� ����Ʈ*/
	public String myTalentList() throws Exception{
		common();
		list=sqlMapper.queryForList("talent.selectMyTalent",(String)session.get("ID"));
		
		totalCount = list.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) {
			lastCount=page.getEndCount()+1;
		}
		list=list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	/*���������� ��ǰ �Ǹ� ����*/
	public String mySellProductList() throws Exception{
		common();
		
		list=sqlMapper.queryForList("product.selectMySellProduct",(String)session.get("ID"));
		
		totalCount = list.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) {
			lastCount=page.getEndCount()+1;
		}
		list=list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	/*���������� ��� �Ǹ� ����*/
	public String mySellTalentList() throws Exception{
		common();
		
		list=sqlMapper.queryForList("talent.selectMySellTalent",(String)session.get("ID"));
		
		totalCount = list.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) {
			lastCount=page.getEndCount()+1;
		}
		list=list.subList(page.getStartCount(), lastCount);
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
		
		/*���������� �Ǹ� ����*/
		sellCountProduct = (Integer)sqlMapper.queryForObject("product.countSellProduct",(String)session.get("ID"));
		sellCountTalent = (Integer)sqlMapper.queryForObject("talent.countSellTalent",(String)session.get("ID"));
		sum = sellCountProduct + sellCountTalent;
	
	}
	
	public List getFirst() {
		return first;
	}

	public void setFirst(List first) {
		this.first = first;
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
	
	

}
