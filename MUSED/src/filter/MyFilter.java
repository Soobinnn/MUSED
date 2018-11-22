package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.RequestProcessor;



public class MyFilter extends RequestProcessor {

    protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

