package nanifarfalla.app.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "CookieLocaleFilter", urlPatterns = { "/*" })
public class CookieLocaleFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getParameter("cookieLocale") != null) {
            Cookie cookie = new Cookie("lang", req.getParameter("cookieLocale"));
            res.addCookie(cookie);
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}