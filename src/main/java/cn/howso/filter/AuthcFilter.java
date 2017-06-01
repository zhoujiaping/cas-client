package cn.howso.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class AuthcFilter extends FormAuthenticationFilter{

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
            throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL()+" authc onAccessDenied");
        return super.onAccessDenied(request, response);
    }
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL()+" authc isAccessAllowed");
        Object principal = SecurityUtils.getSubject().getPrincipal();
        Object id = SecurityUtils.getSubject().getSession().getId();
        Object host = SecurityUtils.getSubject().getSession().getHost();
        
        System.out.println("principal="+principal+" id="+id+" host="+host);
        return super.isAccessAllowed(request, response, mappedValue);
    }

    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL()+" authc issueSuccessRedirect");
        super.issueSuccessRedirect(request, response);
    }

}
