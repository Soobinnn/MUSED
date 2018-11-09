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
	//ibatis사용하기 위해
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	//객체 전달을 위해
	private productVO paramClass=new productVO();
	//처리된 결과 전달을 위해
	private productVO resultClass=new productVO();
	private List<productVO> list = new ArrayList<productVO>();

		//현재 페이지 번호
	private int currentPage;
	
	//글 번호
	private int product_no;
	private List<String> image = new ArrayList();
	private String[] a;
	//비밀번호 체크
	private String password;
		
	private List<String> type = new ArrayList();

	//생성자 -> ibatis에 정의한 내용을 가져다 사용할 수 있음
	public DetailAction() throws IOException{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");	
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	//상세보기
	public String execute() throws Exception{
		paramClass.setProduct_no(getProduct_no());
 		// paramClass의 글번호 넣어주기
		
		resultClass=(productVO) sqlMapper.queryForObject("product.selectOne",getProduct_no());	//해당 글 번호의 정보 한줄 가져오기
		
		list=sqlMapper.queryForList("product.selectAll");
		
		//main_img 경로 추가
		resultClass.setMain_img("/MUSED/product/img/"+resultClass.getMain_img());
	
		//image - split으로 나누기
		a=resultClass.getProduct_image().split(",");		
		for(int i= 0 ; i < a.length;i++) {
			image.add("/MUSED/product/img/"+a[i]);
			System.out.println(a[i]);
		}
		
		System.out.println("--------------------");
		
		//type - split으로 나누기
		String[] t = resultClass.getProduct_type().split(", ");
		for(int i= 0 ; i < t.length;i++) {
			System.out.println(t[i]);
	
		if(t[i].indexOf("직")==0)	//이미지 추가!
		{		
			type.add("직거래");
		}
		else if(t[i].indexOf("포")==0)
		{	
			type.add("배송비 포함 택배");
		}
		else if(t[i].indexOf("미")==0)
		{		
			type.add("배송비 미포함 택배");
		}
		}
		
		System.out.println(type);
		
		return SUCCESS;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public List<productVO> getList() {
		return list;
	}

	public void setList(List<productVO> list) {
		this.list = list;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
