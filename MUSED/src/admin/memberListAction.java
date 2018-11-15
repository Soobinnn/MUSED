package admin;


import com.opensymphony.xwork2.ActionSupport;

import report.pagingAction;
import member.MemberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient; 
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

public class memberListAction extends ActionSupport
{
	public static Reader reader; //파일 스트림을 위한 reader
	public static SqlMapClient sqlMapper; ////SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	private List<MemberVO> list =  new ArrayList<MemberVO>();
	
	private int currentPage = 1;	//현재 페이지
	private int totalCount;			//총 게시물의 수
	private int blockCount = 10;	//한 페이지의 게시물의 수
	private int blockPage = 5;		//한 화면에 보여줄 페이지 수
	private String pagingHtml;		//페이징을 구현한 HTML
	private pagingAction page;		//페이징 클래스
	
	public memberListAction() throws IOException
	{
		// sqlMapConfig.xml파일의 설정내용을 가져옴
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
						
		// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
						
		reader.close();	
	}
	
}
