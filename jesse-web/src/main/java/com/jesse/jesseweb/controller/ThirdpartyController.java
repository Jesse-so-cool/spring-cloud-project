package com.jesse.jesseweb.controller;

import com.jesse.jesseweb.entity.Article;
import com.jesse.jesseweb.entity.Message;
import com.jesse.jesseweb.entity.ThirdParty;
import com.jesse.jesseweb.mapper.ArticleMapper;
import com.jesse.jesseweb.mapper.MessageMapper;
import com.jesse.jesseweb.mapper.ThirdPartyMapper;
import com.sun.xml.internal.bind.v2.TODO;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Random;

@RequestMapping(value = "/thirdparty")
@RestController
public class ThirdpartyController {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private ThirdPartyMapper thirdPartyMapper;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public String sendMessage(String phone) throws Exception {
        if (phone.length() != 11) {
            return "error";
        }

        ThirdParty message = thirdPartyMapper.selectByTag("message");
        String url = message.getUrl();
        String json = message.getParameter();
        Random random = new Random();
        String validationCode = random.nextInt(10) + "" + random.nextInt(10) + "" + random.nextInt(10) + "" + random.nextInt(10);

        //TODO 加张message表;

        //String json = "{\"content\":\""+validationCode+"【月亮天使重置密码验证码】\",\"myAccount\":\"dspt\",\"mobileNo\":\""+phone+"\",\"myProjectName\":\"系1525统\",\"myRemark\":\"系4554统\"}";
        json = json.replaceFirst("validationCode", validationCode);
        json = json.replaceFirst("phone", phone);
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        //TODO 判断result是否成功
        messageMapper.insert(new Message(phone, validationCode, new Timestamp(System.currentTimeMillis())));
        return result;
    }
}
