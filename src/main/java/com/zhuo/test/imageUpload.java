package com.zhuo.test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
public class imageUpload {
	
   private static final Logger logger = LoggerFactory.getLogger(imageUpload.class);
	  
   // 正式
   private static String baseUrl = ServiceConfig.getUploadBasePath();
   private static String urlPath = ServiceConfig.getUploadBaseUrl();
   
   @ApiOperation(value="单张图片上传接口",notes="单张图片上传接口,文件流形式上传,文件参数名file")
   @ApiImplicitParams({
       @ApiImplicitParam(name="oid",value="用户微信登录凭证",dataType="String",paramType="header",required=false),
       @ApiImplicitParam(name="code",value="上传类型：user、用户图片上传，company、公司图片上传，position、岗位图片上传，banner、轮播图片上传",dataType="String",paramType="query",required=true),
       @ApiImplicitParam(name="file",value="图片文件流",dataType="form提交",paramType="query",required=true),
   })
   @PostMapping(value = "/wxAppletsLogin/imgUpOne/test")
   public UpImgMsg mallImgUpOne(HttpServletRequest request) {
       UpImgMsg msg=new UpImgMsg();
       String oid = request.getHeader("oid");
       String code = request.getParameter("code");
       logger.info("OrderPayController.WxMallPrePay params==oid={},",oid);
       
       MultipartHttpServletRequest multiRequest = getMultiReq(request);
       if(multiRequest == null) {
           msg.setErrorCode(1);
           msg.setMessage("上传文件为空");
           return msg;
       }
       MultipartFile file_member = multiRequest.getFile("file");
       String leftPath  = null;
       String fileRegex = null;
       long maxSize = 0;
       if("user".equals(code)) {
           leftPath = Const.HP_UP_IMG_USER_PATH;
           fileRegex = Const.HP_UP_IMG_FORMAT;
       }else if("company".equals(code)) {
           leftPath = Const.HP_UP_IMG_COM_PATH;
           fileRegex = Const.HP_UP_IMG_FORMAT;
       }else if("position".equals(code)) {
           leftPath = Const.HP_UP_IMG_POS_PATH;
           fileRegex = Const.HP_UP_IMG_FORMAT;
       }else if("banner".equals(code)) {
           leftPath = Const.HP_UP_IMG_BANNER_PATH;
           fileRegex = Const.HP_UP_IMG_FORMAT;
       }else {
           msg.setErrorCode(1);
           msg.setMessage("上传类型不符");
           return msg;
       }
       JSONObject json = UploadFiles(file_member, leftPath, fileRegex, maxSize, 0);
       msg.setErrorCode(json.getIntValue(Const.RESUTL_MESSAGE_ERRORCODE));
       msg.setMessage(json.getString(Const.RESUTL_MESSAGE_MESSAGE));
       UpImgData data = new UpImgData();
       data.setImgUrl(json.getString(Const.RESUTL_MESSAGE_UP_IMG_URL));
       msg.setData(data);
       return msg;
   }
   /**
   *
   * @TODO:     文件上传
   * @param file_member MultipartFile
   * @param leftPath 存储文件夹
   * @param fileRegex 文件格式要求，小写正则
   * @param minSize 文件最小字节数，值大于零则存在最小值限制
   * @param maxSize 文件最大字节数，值大于零则存在最大值限制
   */
      public static JSONObject UploadFiles(MultipartFile file_member, String leftPath, String fileRegex,long minSize,
              long maxSize) {
          JSONObject json = new JSONObject();
          json.put(Const.RESUTL_MESSAGE_ERRORCODE, 3);
          json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件上传失败");
          if (file_member == null || file_member.getSize() <= 0) {
              json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
              json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件为空");
              return json;
          }
          if(maxSize >0 && file_member.getSize()>maxSize) {
              json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
              json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件大小超过最大限制");
              return json;
          }
          if(minSize >0 && file_member.getSize()<minSize) {
              json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
              json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件大小超过最小限制");
              return json;
          }
          String fileName = file_member.getOriginalFilename();
          if(fileName == null) {
              json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
              json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件格式不符");
              return json;
          }
          
          // 采用UUID生成随机文件名
          fileName = UUID.randomUUID().toString().replace("-", "")
                  + fileName.substring(fileName.lastIndexOf("."));

          // 找到对应相册文件夹
          String realPath = urlPath + leftPath + "/" + fileName;
          leftPath = baseUrl + leftPath;

          String lowFileName = fileName.toLowerCase();
          if(!Util.isEmpty(fileRegex) && !lowFileName.matches(fileRegex) ) {
              json.put(Const.RESUTL_MESSAGE_ERRORCODE, 2);
              json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件格式不符合");
              return json;
          }
          

          File file = new File(leftPath, fileName);
          try {
              file_member.transferTo(file);
              
              json.put(Const.RESUTL_MESSAGE_UP_IMG_URL, realPath);
              json.put(Const.RESUTL_MESSAGE_ERRORCODE, 0);
              json.put(Const.RESUTL_MESSAGE_MESSAGE, "success");
              return json;
          } catch (IllegalStateException e) {
              logger.error("文件上传异常===",e);
          } catch (IOException e) {
              logger.error("文件上传异常===",e);
          }
          
          return json;
      }
      
   
   /**
    * 获取MultipartRequest：文件流
    */
   public static MultipartHttpServletRequest getMultiReq(
           HttpServletRequest request) {
       String contentType = request.getContentType();
       MultipartHttpServletRequest multipartRequest = null; // 获取图片
       if (contentType != null
               && contentType.toLowerCase().startsWith("multipart/")) {
           multipartRequest = WebUtils.getNativeRequest(request,
                   MultipartHttpServletRequest.class);
       }
       return multipartRequest;
   }
}
