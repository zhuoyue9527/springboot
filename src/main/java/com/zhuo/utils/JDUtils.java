package com.zhuo.utils;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class JDUtils {

	private static String jdurl = "http://msg.plus.jdcloud.com/api/sms/multiSend" ;
	static String password = "A9t53fq3" ;
	static String ukey = "" ;
	static String account ="jcloud_AAenZet" ;
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient();
	
	public static void main(String[] args) {
		 Message message = new Message();
		 message.setContent("你好，这里是智商城市，此条短信是测试连接短信，谢谢您的使用");
		 message.setPhones("15773151015");
		 message.setSign("【智商城市】");
		 
		 
		 RequestMessage req = new RequestMessage();
		 req.setAccount(account);
		 req.setPassword(fun(password));
		 req.setUkey(ukey);
		 req.setData(message);
		
		 String postBody = JSON.toJSONString(req);
		 
		 System.out.println(postBody);
		 Request request = new Request.Builder().url(jdurl).post(RequestBody.create(MEDIA_TYPE_JSON, postBody)).build();
		 
		 try {
			Response response = client.newCall(request).execute(); 
			String result = response.body().string();
			System.out.println( result);
		 } catch (IOException e) {
			e.printStackTrace();
		 }
	}
	
	public static String fun(String password) {
		 // 生成一个MD5加密计算摘要
        MessageDigest md = null ;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // 计算md5函数
        md.update(password.getBytes());
        // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
        return new BigInteger(1, md.digest()).toString(16);
	}
}
