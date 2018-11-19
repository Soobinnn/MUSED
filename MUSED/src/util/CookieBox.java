package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import java.util.Map;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.io.IOException;

public class CookieBox {
	
	//��Ű�� ������ �����ϴ� ��
	private Map<String, Cookie> cookieMap = new java.util.HashMap<String, Cookie>();
	
	public CookieBox(HttpServletRequest request) {//������, ���ڷ� request�� �޴´�
		Cookie[] cookies = request.getCookies(); //���ڷ� ���� request�κ��� ��Ű�迭�� �о� �´�.
		if (cookies != null) {//�迭�� ���� �ִٸ�
			for (int i = 0; i < cookies.length; i++) {//�� ���̸�ŭ �ݺ��ϸ鼭
				cookieMap.put(cookies[i].getName(), cookies[i]);//��Ű�ʿ� ������ �����Ų��.
			}
		}
	}

	public static Cookie createCookie(String name, String value) throws IOException { //name �� value�� ���ڸ� �޴´�
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));//��Ű�� �����Ͽ� �����Ѵ�., ���� ��
	}

	//��Ű�� ���ڷ� �װ��� ���� �޴´� , ��ġ�� �ð��� �߰�
	public static Cookie createCookie(String name, String value, String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}

	//���ڷ� �ټ����� ���� �޴´�. �������� �߰�.
	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge)
			throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}

	//���޹��� ������ �̸��� ������ ��Ű�� ��ȯ
	public Cookie getCookie(String name) 
	{
		return cookieMap.get(name);
	}
	
	//���޹��� ������ �̸��� ������ ��Ű�� ������ �� ��Ű�� value�� ��ȯ
	public String getValue(String name) throws IOException 
	{
		Cookie cookie = cookieMap.get(name);
		if (cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), "utf-8");
	}
	
	//���޹��� ������ �̸��� ������ ��Ű�� ���������� ����
	public boolean exists(String name) 
	{
		return cookieMap.get(name) != null;
	}

}
