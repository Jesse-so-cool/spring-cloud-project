package com.jesse.jesseweb.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jesse.jesseweb.entity.Role;
import com.jesse.jesseweb.entity.User;
import com.jesse.jesseweb.entity.UserRole;
import com.jesse.jesseweb.mapper.UserMapper;
import com.jesse.jesseweb.mapper.UserRoleMapper;
import com.jesse.jesseweb.response.AppResponse;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.Constants.REDIRECT_URI;

@RequestMapping(value = "/oauth")
@Controller
public class AuthController {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    final private String CLIENT_ID = "51e1a48f18d8d9bda59c";
    final private String CLIENT_SECRET = "88cbbc1da290da92f40c9839ad95e6215d9fbdb4";
    final private String REDIRECT_URI = "http://localhost:8088/oauth/github";

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping(value = "/github")
    public String github(String code) {
        if (code == null) {
            return null;
        }
        try {
            String url = "https://github.com/login/oauth/access_token?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&code=" + code + "&redirect_uri=" + REDIRECT_URI;
            URL u = new URL(url);
            OutputStream os = new FileOutputStream("D://test.txt");
            InputStream is = u.openConnection().getInputStream();

            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            String str = new String(bytes);

            final String index = "access_token=";
            if (str.contains(index)) {
                str = str.substring(13, str.indexOf("&"));
            }
            is.close();
            String tokenUrl = "https://api.github.com/user?access_token=" + str;
            String userInfo = getUrl(tokenUrl);
            Map<String, String> userMap = (Map<String, String>) com.alibaba.fastjson.JSON.parse(userInfo);
            System.out.println(userMap.get("login"));
            //userDetailsService.loadUserByUsername(userMap.get("login"));

            authenticate(userMap);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        String tokenUrl = "https://api.github.com/user?access_token=xxx";

        return "redirect:/index";
    }


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    private void authenticate(Map<String, String> userMap) {
        User u = userMapper.selectByUsername(userMap.get("login"));

        if (u == null) {
            u = new User();
            u.setUsername(userMap.get("login"));
            u.setPassword("88888888");
            List<Role> lr = new ArrayList<>();
            lr.add(new Role(2, "ROLE_user"));
            userMapper.insert(u);
            User idUser = userMapper.selectByUsername(userMap.get("login"));
            for (Role role : lr) {
                userRoleMapper.insert(new UserRole(idUser, role));
            }
        }
        //根据用户名username加载userDetails
        UserDetails userDetails = userDetailsService.loadUserByUsername(userMap.get("login"));

        //根据userDetails构建新的Authentication,这里使用了
        //PreAuthenticatedAuthenticationToken当然可以用其他token,如UsernamePasswordAuthenticationToken               
        //PreAuthenticatedAuthenticationToken authentication  new PreAuthenticatedAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        //设置authentication中details
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attr.getRequest();
        authentication.setDetails(new WebAuthenticationDetails(request));

        //存放authentication到SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String postUrl(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return result;
    }

    private String getUrl(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return result;
    }
}
