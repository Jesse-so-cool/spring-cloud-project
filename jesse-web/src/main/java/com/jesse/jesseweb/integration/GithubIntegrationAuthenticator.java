package com.jesse.jesseweb.integration;

import com.jesse.jesseweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 小程序集成认证
 *
 * @author LIQIU
 * @date 2018-3-31
 **/
@Service
public class GithubIntegrationAuthenticator implements IntegrationAuthenticator {


    @Override
    public User authenticate(IntegrationAuthentication integrationAuthentication) {
        /*WxMaJscode2SessionResult session = null;
        String password = integrationAuthentication.getAuthParameter("password");
        try {
            session = this.wxMaService.getUserService().getSessionInfo(password);
            WechatMiniAppToken wechatToken = new WechatMiniAppToken(session.getOpenid(), session.getUnionid(), session.getSessionKey());
            // 加密算法的初始向量
            wechatToken.setIv(integrationAuthentication.getAuthParameter("iv"));
            // 用户的加密数据
            wechatToken.setEncryptedData(integrationAuthentication.getAuthParameter("encryptedData"));
        } catch (WxErrorException e) {
            throw new InternalAuthenticationServiceException("获取微信小程序用户信息失败",e);
        }
        String openId = session.getOpenid();
        SysUserAuthentication sysUserAuthentication = sysUserClient.findUserBySocial(UcClientConstant.SOCIAL_TYPE_WECHAT_MINIAP, openId);
        if(sysUserAuthentication != null){
            sysUserAuthentication.setPassword(passwordEncoder.encode(password));
        }
        return sysUserAuthentication;*/
        return new User();
    }

    @Override
    public void prepare(IntegrationAuthentication integrationAuthentication) {

    }

    private final static String GITHUB_AUTH_TYPE = "sms";

    @Override
    public boolean support(IntegrationAuthentication integrationAuthentication) {
        return GITHUB_AUTH_TYPE.equals(integrationAuthentication.getAuthType());
    }

    @Override
    public void complete(IntegrationAuthentication integrationAuthentication) {

    }
}
