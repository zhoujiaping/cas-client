package cn.howso.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.LogoutFilter;

public class MyLogoutFilter extends LogoutFilter{
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL()+" MyLogoutFilter preHandle");
        Object principal = SecurityUtils.getSubject().getPrincipal();
        Object id = SecurityUtils.getSubject().getSession().getId();
        Object host = SecurityUtils.getSubject().getSession().getHost();
        
        System.out.println("principal="+principal+" id="+id+" host="+host);
        return super.preHandle(request, response);
    }
    @Override
    protected void issueRedirect(ServletRequest request, ServletResponse response, String redirectUrl)
            throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL()+" MyLogoutFilter issueRedirect");
        super.issueRedirect(request, response, redirectUrl);
    }
}
