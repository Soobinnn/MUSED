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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.CookieBox;

import org.apache.struts2.ServletActionContext;

public class DetailAction extends ActionSupport {
	// ibatis사용하기 위해
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private HttpServletRequest request;
	private HttpServletResponse response;
	

	private static int num = 0;

	private Cookie[] c = new Cookie[5];
	

	// 객체 전달을 위해
	private productVO paramClass = new productVO();
	// 처리된 결과 전달을 위해
	private productVO resultClass = new productVO();

	private List<productVO> Mainlist = new ArrayList<productVO>();
	private List<product_cVO> commentList = new ArrayList<product_cVO>();

	private product_cVO cClass = new product_cVO();
	private product_cVO cResult = new product_cVO();

	// 현재 페이지 번호
	private int currentPage;
	private int c_contnum;
	// 글 번호
	private int product_no;
	private List<String> image = new ArrayList();
	private String[] a;
	// 비밀번호 체크
	private int c_no;
	private String c_id;

	private List<String> type = new ArrayList();

	// 생성자 -> ibatis에 정의한 내용을 가져다 사용할 수 있음
	public DetailAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	// 상세보기
	public String execute() throws Exception {

		paramClass.setProduct_no(getProduct_no());
		// paramClass의 글번호 넣어주기
		sqlMapper.update("product.updateReadHit", paramClass);

		resultClass = (productVO) sqlMapper.queryForObject("product.selectOne", getProduct_no()); // 해당 글 번호의 정보 한줄 가져오기

		commentList = sqlMapper.queryForList("product.commentSelectAll", getProduct_no());

		// main_img 경로 추가
		resultClass.setMain_img("/MUSED/product/img/" + resultClass.getMain_img());

		Mainlist = sqlMapper.queryForList("product.selectMainImg", getProduct_no());

		// image - split으로 나누기
		a = resultClass.getProduct_image().split(",");
		for (int i = 0; i < a.length; i++) {
			image.add("/MUSED/product/img/" + a[i]);
			System.out.println(a[i]);
		}

		System.out.println("--------------------");

		// type - split으로 나누기
		String[] t = resultClass.getProduct_type().split(", ");

		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
			if (t[i].indexOf("직") == 0) // 이미지 추가!
			{
				type.add("/MUSED/product/ui_img/직.png");
			} else if (t[i].indexOf("포") == 0) {
				type.add("/MUSED/product/ui_img/택배_포.png");
			} else if (t[i].indexOf("미") == 0) {
				type.add("/MUSED/product/ui_img/택배_미.png");
			}
		}

		System.out.println(type);
		
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		
		request.setCharacterEncoding("UTF-8");
	
		response.addCookie(CookieBox.createCookie("CID" + num,resultClass.getProduct_name() , "/", -1));
		response.addCookie(CookieBox.createCookie("IMAGE" + num, resultClass.getMain_img(), "/", -1));
		response.addCookie(CookieBox.createCookie("PNO" + num, Integer.toString(resultClass.getProduct_no()), "/",-1));
		response.addCookie(CookieBox.createCookie("PAGE" + num, Integer.toString(getCurrentPage()),"/",-1));
		
		System.out.println(num);
		num++;
		if(num > 4) {
			num = 0;
		}
		
		//최근 본 상품 테스트
		/*c = request.getCookies();
			
		for (int i = 0; i < c.length; i++) {
			System.out.println("게시물이름 : " + c[i].getValue());
		}*/
		

		return SUCCESS;
	}
	
	

	public String commentDelete() throws Exception {
		cClass = new product_cVO();
		cResult = new product_cVO();

		cClass.setC_no(getC_no());
		cClass.setC_id(getC_id());
		sqlMapper.update("product.deletePComment", cClass);

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
