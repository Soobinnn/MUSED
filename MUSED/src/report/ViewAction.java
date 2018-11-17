package report;

import com.opensymphony.xwork2.ActionSupport;

import report.reportVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.net.URLEncoder;

public class ViewAction extends ActionSupport
{
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private reportVO paramClass = new reportVO();
	private reportVO resultClass = new reportVO();

	private int currentPage;
	
	private String report_state;
	private int report_no;
	private String fileUploadPath = "C:\\Users\\user\\Desktop\\Java\\upload";
	
	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;
	
	public ViewAction() throws IOException 
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	public String execute() throws Exception 
	{
		// 해당 번호의 글을 가져온다.
		resultClass = (reportVO) sqlMapper.queryForObject("report.selectOne", getReport_no());

		return SUCCESS;
	}
	public String process() throws Exception
	{
		resultClass = (reportVO) sqlMapper.queryForObject("report.selectOne", getReport_no());
		
		paramClass.setReport_no(getReport_no());
		paramClass.setReport_state(getReport_state());
		sqlMapper.update("report.checkprocess",paramClass);
		
		return SUCCESS;
	}
	public String download() throws Exception 
	{

		// 해당 번호의 파일 정보를 가져온다.
		resultClass = (reportVO) sqlMapper.queryForObject("report.selectOne", getReport_no());

	
		// 파일 경로와 파일명을 file 객체에 넣는다.
		File fileInfo = new File(fileUploadPath + resultClass.getFile_savname());

		// 다운로드 파일 정보 설정.
		setContentLength(fileInfo.length());
		setContentDisposition("attachment;filename="+ URLEncoder.encode(resultClass.getFile_orgname(), "UTF-8"));
		setInputStream(new FileInputStream(fileUploadPath+ resultClass.getFile_savname()));

		return SUCCESS;
	}

	public reportVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(reportVO paramClass) {
		this.paramClass = paramClass;
	}

	public reportVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(reportVO resultClass) {
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public int getReport_no() {
		return report_no;
	}

	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}

	public String getReport_state() {
		return report_state;
	}

	public void setReport_state(String report_state) {
		this.report_state = report_state;
	}
	
	
}
