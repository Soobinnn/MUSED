package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import java.util.Map;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.io.IOException;

public class CookieBox {
	
	//쿠키를 쌍으로 저장하는 맵
	private Map<String, Cookie> cookieMap = new java.util.HashMap<String, Cookie>();
	
	public CookieBox(HttpServletRequest request) {//생성자, 인자로 request를 받는다
		Cookie[] cookies = request.getCookies(); //인자로 받은 request로부터 쿠키배열을 읽어 온다.
		if (cookies != null) {//배열에 값이 있다면
			for (int i = 0; i < cookies.length; i++) {//그 길이만큼 반복하면서
				cookieMap.put(cookies[i].getName(), cookies[i]);//쿠키맵에 쌍으로 저장시킨다.
			}
		}
	}

	public static Cookie createCookie(String name, String value) throws IOException { //name 와 value의 인자를 받는다
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));//쿠키를 생성하여 리턴한다., 인자 둘
	}

	//쿠키의 인자로 네개의 값을 받는다 , 패치와 시간이 추가
	public static Cookie createCookie(String name, String value, String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}

	//인자로 다섯개의 값을 받는다. 도메인이 추가.
	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge)
			throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}

	//전달받은 인자의 이름을 가지는 쿠키를 반환
	public Cookie getCookie(String name) 
	{
		return cookieMap.get(name);
	}
	
	//전달받은 인자의 이름을 가지는 쿠키를 구한후 그 쿠키의 value를 반환
	public String getValue(String name) throws IOException 
	{
		Cookie cookie = cookieMap.get(name);
		if (cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), "utf-8");
	}
	
	//전달받은 인자의 이름을 가지는 쿠키의 존재유무를 리턴
	public boolean exists(String name) 
	{
		return cookieMap.get(name) != null;
	}

}
