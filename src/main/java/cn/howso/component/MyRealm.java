package cn.howso.component;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.jasig.cas.client.validation.TicketValidator;

public class MyRealm extends CasRealm{

    protected void onInit() {
        super.onInit();
    }

    protected TicketValidator ensureTicketValidator() {
        return super.ensureTicketValidator();
    }

    protected TicketValidator createTicketValidator() {
        return super.createTicketValidator();
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return super.doGetAuthenticationInfo(token);
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return super.doGetAuthorizationInfo(principals);
    }
}
