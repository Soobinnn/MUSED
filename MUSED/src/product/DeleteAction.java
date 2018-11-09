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

	private productVO paramClass; //�Ķ���͸� ������ ��ü
	private productVO resultClass; //���� ��� ���� ������ ��ü

	private int currentPage;	//���� ������
	
	private String fileUploadPath = "C:\\Users\\bogiy\\OneDrive\\���� ȭ��\\�ڹ�\\MUSED\\MUSED\\WebContent\\product\\img\\";
	
	private int product_no;		
	private List<String> image = new ArrayList();
	private String[] a;

	
	// ������
	public DeleteAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}

	// �Խñ� �� ����
	public String execute() throws Exception {
		
		//�Ķ���Ϳ� ����Ʈ ��ü ����.
		paramClass = new productVO();
		resultClass = new productVO();
		
		// �ش� ��ȣ�� ���� �����´�.
		resultClass = (productVO) sqlMapper.queryForObject("product.selectOne", getProduct_no());

		//���� ���� ����
		File deleteFile = new File(fileUploadPath + resultClass.getMain_img());
		deleteFile.delete();
		
		
		a=resultClass.getProduct_image().split(",");		
		for(int i= 0 ; i < a.length;i++) {
			File deleteFile1 = new File(fileUploadPath+a[i]);
			deleteFile1.delete();
		}
				
		// ������ �׸� ����.
		paramClass.setProduct_no(getProduct_no());
				
		// ���� ���� ����.
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
