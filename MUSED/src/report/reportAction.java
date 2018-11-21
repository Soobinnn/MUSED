package report;

import com.opensymphony.xwork2.ActionSupport;

import report.reportVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class reportAction extends ActionSupport
{
	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private reportVO paramClass; //파라미터를 저장할 객체
	private reportVO resultClass; //쿼리 결과 값을 저장할 객체
	
	private int report_no;
	private String report_category;
	private String report_memid;
	private String report_subject;
	private String report_contno;
	private String report_content;
	private String report_reportid;
	private String report_state;
	
	private String file_orgName; //업로드 파일의 원래 이름
	private String file_savName; //서버에 저장할 업로드 파일의 이름. 고유 번호로 구분한다.
	
	Calendar today = Calendar.getInstance(); //오늘 날짜 구하기.

	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath = "C:\\Java\\upload\\"; //업로드 경로.
	
	public reportAction() throws IOException
	{
		// sqlMapConfig.xml 파일의 설정내용을 가져온다.
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
				
		// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 		
		reader.close();
	}
	
	public String form() throws Exception 
	{
		//등록 폼.
		return SUCCESS;
	}
	public String execute() throws Exception
	{
		//파라미터와 리절트 객체 생성.
		paramClass = new reportVO();
		resultClass = new reportVO();

		// 등록할 항목 설정.
		paramClass.setReport_category(getReport_category());	//report_category
		paramClass.setReport_memid(getReport_memid());			//report_memid
		paramClass.setReport_subject(getReport_subject());	//report_subject
		paramClass.setReport_contno(getReport_contno());	//report_contno
		paramClass.setReport_content(getReport_content());	//report_content
		paramClass.setReport_regdate(today.getTime());	//report_regdate
		paramClass.setReport_reportid(getReport_reportid());
		paramClass.setReport_state(getReport_state());
		// 등록 쿼리 수행.
		sqlMapper.insert("report.insertReport", paramClass);

		
		// 첨부파일을 선택했다면 파일을 업로드한다.
		if (getUpload() != null) 
		{

			//등록한 글 번호 가져오기.
			resultClass = (reportVO) sqlMapper.queryForObject("report.selectLastNo");

			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + resultClass.getReport_no();
			String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.') + 1, getUploadFileName().length());

			//서버에 파일 저장.
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);

			//파일 정보 파라미터 설정.
			paramClass.setReport_no(resultClass.getReport_no());
			paramClass.setFile_orgname(getUploadFileName());		//원래 파일 이름
			paramClass.setFile_savname(file_name + "." + file_ext);	//서버에 저장한 파일 이름
			
			//파일 정보 업데이트.
			sqlMapper.update("report.updateFile", paramClass);
		}
		
		return SUCCESS;
	}

	public reportVO getParamClass() 
	{
		return paramClass;
	}

	public void setParamClass(reportVO paramClass) 
	{
		this.paramClass = paramClass;
	}

	public reportVO getResultClass() 
	{
		return resultClass;
	}

	public void setResultClass(reportVO resultClass) 
	{
		this.resultClass = resultClass;
	}

	public int getReport_no() 
	{
		return report_no;
	}

	public void setReport_no(int report_no) 
	{
		this.report_no = report_no;
	}

	public String getReport_category() 
	{
		return report_category;
	}

	public void setReport_category(String report_category) 
	{
		this.report_category = report_category;
	}

	public String getReport_memid() 
	{
		return report_memid;
	}

	public void setReport_memid(String report_memid) 
	{
		this.report_memid = report_memid;
	}

	public String getReport_subject() 
	{
		return report_subject;
	}

	public void setReport_subject(String report_subject) 
	{
		this.report_subject = report_subject;
	}

	public String getReport_contno() 
	{
		return report_contno;
	}

	public void setReport_contno(String report_contno) 
	{
		this.report_contno = report_contno;
	}

	public String getReport_content() 
	{
		return report_content;
	}

	public void setReport_content(String report_content) 
	{
		this.report_content = report_content;
	}

	public String getFile_orgName() 
	{
		return file_orgName;
	}

	public void setFile_orgName(String file_orgName) 
	{
		this.file_orgName = file_orgName;
	}

	public String getFile_savName() 
	{
		return file_savName;
	}

	public void setFile_savName(String file_savName) 
	{
		this.file_savName = file_savName;
	}

	public Calendar getToday() 
	{
		return today;
	}

	public void setToday(Calendar today) 
	{
		this.today = today;
	}

	public File getUpload() 
	{
		return upload;
	}

	public void setUpload(File upload) 
	{
		this.upload = upload;
	}

	public String getUploadContentType() 
	{
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) 
	{
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() 
	{
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) 
	{
		this.uploadFileName = uploadFileName;
	}

	public String getFileUploadPath() 
	{
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) 
	{
		this.fileUploadPath = fileUploadPath;
	}

	public String getReport_reportid() {
		return report_reportid;
	}

	public void setReport_reportid(String report_reportid) {
		this.report_reportid = report_reportid;
	}

	public String getReport_state() {
		return report_state;
	}

	public void setReport_state(String report_state) {
		this.report_state = report_state;
	}
	
}
