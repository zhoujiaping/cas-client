package cn.howso.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.subject.Subject;

public class MyCasFilter extends CasFilter {

    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        return super.createToken(request, response);
    }

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL()+" casFilter onAccessDenied");
        return super.onAccessDenied(request, response);
        /* HttpServletRequest req = (HttpServletRequest) request;
         HttpServletResponse res = (HttpServletResponse) response;
         res.sendRedirect("");*/
         
    }

    /**
     * 父类该方法直接返回false，所以需要重写
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL()+" casFilter isAccessAllowed");
        Object principal = SecurityUtils.getSubject().getPrincipal();
        Object id = SecurityUtils.getSubject().getSession().getId();
        Object host = SecurityUtils.getSubject().getSession().getHost();
        
        System.out.println("principal="+principal+" id="+id+" host="+host);
        String method = req.getMethod();
        System.out.println(method);
       /* if(method.equals("POST")){//登录时回调用的GET请求，注销时回调用的POST请求。
            SecurityUtils.getSubject().logout();
        }*/
        //return isAuthenticated || isLoginRequest;
        return super.isAccessAllowed(request, response, mappedValue);
    }

    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
            ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL()+" casFilter onLoginSuccess");
        return super.onLoginSuccess(token, subject, request, response);
    }

    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae, ServletRequest request,
            ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL()+" casFilter onLoginFailure");
        return super.onLoginFailure(token, ae, request, response);
    }
}
