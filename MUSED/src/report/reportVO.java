package report;

import java.util.*;

public class reportVO 
{
	private int report_no;
	private String report_memid;
	private String report_category;
	private int report_indexno;
	private String report_subject;
	private String report_content;
	private String report_contno;
	private Date report_regdate;
	private String report_reportid;
	private String file_orgname;
	private String file_savname;
	
	public int getReport_no() {
		return report_no;
	}
	public void setReport_no(int report_no) 
	{
		this.report_no = report_no;
	}
	public String getReport_memid() 
	{
		return report_memid;
	}
	public void setReport_memid(String report_memid) 
	{
		this.report_memid = report_memid;
	}
	public String getReport_category() 
	{
		return report_category;
	}
	public void setReport_category(String report_category) 
	{
		this.report_category = report_category;
	}
	public int getReport_indexno() 
	{
		return report_indexno;
	}
	public void setReport_indexno(int report_indexno) 
	{
		this.report_indexno = report_indexno;
	}
	public String getReport_subject() 
	{
		return report_subject;
	}
	public void setReport_subject(String report_subject) 
	{
		this.report_subject = report_subject;
	}
	public String getReport_content() 
	{
		return report_content;
	}
	public void setReport_content(String report_content) 
	{
		this.report_content = report_content;
	}
	public String getReport_contno() 
	{
		return report_contno;
	}
	public void setReport_contno(String report_contno) 
	{
		this.report_contno = report_contno;
	}
	public Date getReport_regdate() 
	{
		return report_regdate;
	}
	public void setReport_regdate(Date report_regdate) 
	{
		this.report_regdate = report_regdate;
	}
	public String getFile_orgname() {
		return file_orgname;
	}
	public void setFile_orgname(String file_orgname) {
		this.file_orgname = file_orgname;
	}
	public String getFile_savname() {
		return file_savname;
	}
	public void setFile_savname(String file_savname) {
		this.file_savname = file_savname;
	}
	public String getReport_reportid() {
		return report_reportid;
	}
	public void setReport_reportid(String report_reportid) {
		this.report_reportid = report_reportid;
	}

	
}
