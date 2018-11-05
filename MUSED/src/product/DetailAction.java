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

public class DetailAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private productVO paramClass = new productVO(); //�Ķ���͸� ������ ��ü
	private productVO resultClass = new productVO(); //���� ��� ���� ������ ��ü

	private int currentPage;

	private int no;
	private String password;

	// ������
	public DetailAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}

	// �󼼺���
	public String execute() throws Exception {

		// �ش� ��ȣ�� ���� �����´�.
		resultClass = (productVO) sqlMapper.queryForObject("product.selectOne", getNo());

		return SUCCESS;
	}
/*
	// ��й�ȣ üũ ��
	public String checkForm() throws Exception {

		return SUCCESS;
	}

	// ��й�ȣ üũ �׼�
	public String checkAction() throws Exception {

		// ��й�ȣ �Է°� �Ķ���� ����.
		paramClass.setNo(getNo());
		paramClass.setPassword(getPassword());

		// ���� ���� ��й�ȣ ��������.
		resultClass = (productVO) sqlMapper.queryForObject("selectPassword",
				paramClass);

		// �Է��� ��й�ȣ�� Ʋ���� ERROR ����.
		if (resultClass == null)
			return ERROR;

		return SUCCESS;
	}
*/

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		DetailAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		DetailAction.sqlMapper = sqlMapper;
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
