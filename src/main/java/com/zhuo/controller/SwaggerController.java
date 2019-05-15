package com.zhuo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhuo.entity.Area;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
 
/**
 * Hello world!
 *
 */
@Api(value="用户接口",tags="用户接口")
@RestController
@RequestMapping("/swaggerController")
public class SwaggerController {
 
    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @GetMapping(value="/createUser")
    public void createUser(Area user,String s){
        System.out.println("createUser:::"+user.toString());
    }
 
    @ApiOperation(value = "修改用户" ,  notes="修改用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name="name",value="姓名",dataType="String",paramType="query",required=true),
        @ApiImplicitParam(name="comName",value="公司名称，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="startTime",value="开始时间",dataType="long",paramType="query",required=false),
        @ApiImplicitParam(name="endTime",value="结束时间",dataType="long",paramType="query",required=false),
        @ApiImplicitParam(name="contactOn",value="是否联系",dataType="Integer",paramType="query",required=false),
        @ApiImplicitParam(name="currentPage",value="当前页",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="showCount",value="单页展示记录数",dataType="int",paramType="query",required=false),
    })
    @GetMapping(value="/updateUser")
    public void updateUser(String name,String comName){
        System.out.println("updateUser:::");
    }
 
    @ApiOperation(value = "删除用户" ,  notes="删除用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @DeleteMapping(value="/deleteUser")
    public void deleteUser(String userId){
        System.out.println("deleteUser:::"+userId);
    }
 
    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/queryUser",method=RequestMethod.GET)
    public void queryUser(@RequestParam("userId") String userId){
        System.out.println("queryUser:::"+userId);
    }
 
}
