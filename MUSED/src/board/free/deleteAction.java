package board.free;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class deleteAction extends ActionSupport {

	public static Reader reader; // �뙆�씪 �뒪�듃由쇱쓣 �쐞�븳 reader 媛앹껜 �깮�꽦
	public static SqlMapClient sqlMapper; // SqlMapClient API瑜� �궗�슜�븯湲� �쐞�븳 sqlMapper 媛앹껜 �깮�꽦

	private boardVO paramClass; // boardVO�뿉�꽌 �깮�꽦�븳 parameter�뱾�쓣 ���옣�븷 媛앹껜 paramClass
	private boardVO resultClass; // 泥섎━�맂 荑쇰━ 寃곌낵 媛믪쓣 ���옣�븯湲� �쐞�븳 媛앹껜 resultClass

	private cboardVO cClass = new cboardVO();
	private cboardVO cResult = new cboardVO();

	private int currentPage; // �쁽�옱 �럹�씠吏� 媛앹껜 currentPage

	private String fileUploadPath = "c:\\Java\\upload\\";

	private int no; // 湲� 踰덊샇 媛앹껜 no
	private int originno;

	private int name;

	// �깮�꽦�옄
	public deleteAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml�뙆�씪�쓽 �꽕�젙 �궡�슜�쓣 媛��졇���꽌
																	// reader 媛앹껜瑜� �깮�꽦�븳�떎.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml �궡�슜�쓣 �꽕�젙�븳 sqlMapper 媛앹껜 �깮�꽦

		reader.close(); // reader 媛앹껜瑜� �떕�뒗�떎.

	}

	// �떎�뻾 硫붿냼�뱶
	public String execute() throws Exception {

		// boardVO�뿉 �엳�뒗 媛앹껜媛믪쓣 媛�吏�怨� parameter�� result媛앹껜 �깮�꽦
		paramClass = new boardVO();
		resultClass = new boardVO();

		// �빐�떦 踰덊샇�쓽 湲��쓣 媛��졇�삩�떎.
		resultClass = (boardVO) sqlMapper.queryForObject("free.selectOne", getNo());

		// �꽌踰� �뙆�씪 �궘�젣
		File deleteFile = new File(fileUploadPath + resultClass.getFile_savname());
		deleteFile.delete();

		// �궘�젣�븷 �빆紐� �꽕�젙
		paramClass.setNo(getNo());

		// �궘�젣 荑쇰━ �닔�뻾
		sqlMapper.update("free.deleteBoard", paramClass);

		return SUCCESS;
	}

	public String execute2() throws Exception {
		cClass = new cboardVO();
		cResult = new cboardVO();

		cClass.setNo(getNo());
		
		sqlMapper.update("free.deleteCommentCount", getOriginno());
		sqlMapper.update("free.deleteComment", cClass);

		return SUCCESS;
	}

	
	public int getOriginno() {
		return originno;
	}

	public void setOriginno(int originno) {
		this.originno = originno;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public cboardVO getcClass() {
		return cClass;
	}

	public void setcClass(cboardVO cClass) {
		this.cClass = cClass;
	}

	public cboardVO getcResult() {
		return cResult;
	}

	public void setcResult(cboardVO cResult) {
		this.cResult = cResult;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		deleteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		deleteAction.sqlMapper = sqlMapper;
	}

	public boardVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(boardVO paramClass) {
		this.paramClass = paramClass;
	}

	public boardVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(boardVO resultClass) {
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
