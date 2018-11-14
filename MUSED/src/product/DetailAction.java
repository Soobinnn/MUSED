package product;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class DetailAction extends ActionSupport{
	//ibatis����ϱ� ����
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	//��ü ������ ����
	private productVO paramClass=new productVO();
	//ó���� ��� ������ ����
	private productVO resultClass=new productVO();
	
	
	private List<productVO> Mainlist = new ArrayList<productVO>();
	private List<product_cVO> commentList = new ArrayList<product_cVO>();
	
	private product_cVO cClass = new product_cVO();
	private product_cVO cResult = new product_cVO();
	
		//���� ������ ��ȣ
	private int currentPage;
	private int c_contnum;
	//�� ��ȣ
	private int product_no;
	private List<String> image = new ArrayList();
	private String[] a;
	//��й�ȣ üũ
	private int c_no;
	private String c_id;
		
	private List<String> type = new ArrayList();

	//������ -> ibatis�� ������ ������ ������ ����� �� ����
	public DetailAction() throws IOException{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");	
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	//�󼼺���
	public String execute() throws Exception{
		paramClass.setProduct_no(getProduct_no());
 		// paramClass�� �۹�ȣ �־��ֱ�
		sqlMapper.update("product.updateReadHit", paramClass);

		resultClass=(productVO) sqlMapper.queryForObject("product.selectOne",getProduct_no());	//�ش� �� ��ȣ�� ���� ���� ��������
		
		commentList=sqlMapper.queryForList("product.commentSelectAll", getProduct_no());
		
		//main_img ��� �߰�
		resultClass.setMain_img("/MUSED/product/img/"+resultClass.getMain_img());
	
		Mainlist=sqlMapper.queryForList("product.selectMainImg", getProduct_no());	
		
		
		//image - split���� ������
		a=resultClass.getProduct_image().split(",");		
		for(int i= 0 ; i < a.length;i++) {
			image.add("/MUSED/product/img/"+a[i]);
			System.out.println(a[i]);
		}
		
		System.out.println("--------------------");
		
		//type - split���� ������
		String[] t = resultClass.getProduct_type().split(", ");
		
		for(int i= 0 ; i < t.length;i++) {
			System.out.println(t[i]);
		if(t[i].indexOf("��")==0)	//�̹��� �߰�!
		{		
			type.add("���ŷ�");
		}
		else if(t[i].indexOf("��")==0)
		{	
			type.add("��ۺ� ���� �ù�");
		}
		else if(t[i].indexOf("��")==0)
		{		
			type.add("��ۺ� ������ �ù�");
		}
		}
		
		System.out.println(type);
		
		return SUCCESS;
	}

	public String commentDelete() throws Exception{
		cClass = new product_cVO();
		cResult = new product_cVO();

		cClass.setC_no(getC_no());
		cClass.setC_id(getC_id());
		sqlMapper.update("product.deletePComment",cClass);

		return SUCCESS;
	}
	
	

	public List<productVO> getMainlist() {
		return Mainlist;
	}

	public void setMainlist(List<productVO> mainlist) {
		Mainlist = mainlist;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public List<product_cVO> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<product_cVO> commentList) {
		this.commentList = commentList;
	}

	public product_cVO getcClass() {
		return cClass;
	}

	public void setcClass(product_cVO cClass) {
		this.cClass = cClass;
	}

	public product_cVO getcResult() {
		return cResult;
	}

	public void setcResult(product_cVO cResult) {
		this.cResult = cResult;
	}



	public int getC_contnum() {
		return c_contnum;
	}

	public void setC_contnum(int c_contnum) {
		this.c_contnum = c_contnum;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
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

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		sqlMapper = sqlMapper;
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


}
