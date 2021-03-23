package com.democxy.modules.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSON;
import com.democxy.common.annotation.PassLogin;
import com.democxy.common.annotation.Permission;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.BasePageQuery;
import com.democxy.common.global.ResponeData;
import com.democxy.common.enums.ResultEnum;
import com.democxy.common.utils.*;
import com.democxy.common.utils.redis.RedisUtil;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.field.AccountField;
import com.democxy.modules.sys.service.AccountService;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiling_deng
 */
@CrossOrigin
@Controller
@RequestMapping("/admin/account")
public class AccountController extends BaseController<AccountService, Account,AccountField > {

    @Autowired
    RedisUtil redisUtil;

    @Override
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @Permission(value = "sys:account:add")
    public ResponeData<String> save(@Valid @RequestBody AccountField accountField){
        //调用业务逻辑，处理业务
        if (StringUtils.isEmpty(accountField.getAccountId())){
            accountField.setAccountId(IdGenUtil.getUUID());
            String md5Hex = DigestUtil.md5Hex(accountField.getAccountNo() + accountField.getPassword());
            accountField.setPassword(md5Hex);
            service.insert(accountField);
            return new ResponeData<>("添加成功");
        }else {
            service.update(accountField);
            return new ResponeData<>("更新成功成功");
        }


    }

    /**
     * 后台管理登录端-使用session
     * @param accountField
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @PassLogin
    public ResponeData<Map<String,Object>> login(@Valid @RequestBody AccountField accountField, HttpServletRequest request){
        Object loginCode = request.getSession().getAttribute("loginCode");
        if (loginCode != null) {
            if (loginCode.toString().equals(accountField.getCode())) {
                //调用业务逻辑，处理业务
                String md5Hex = DigestUtil.md5Hex(accountField.getAccountNo() + accountField.getPassword());
                accountField.setPassword(md5Hex);
                Account login= service.login(accountField);
                Map<String,Object> map = new HashMap<>();
                if (login!=null){
                    // 手机登录 返回token信息
                    String loginType = accountField.getLoginType();
                    if (StringUtils.isNotEmpty(loginType) && loginType.equals("mobile")) {
                        login.setPassword("");
                        String token = JwtUtil.signToken(login.getAccountId(), JSON.toJSONString(login), JwtUtil.EXPIRE_TIME);
                        map.put("token",token);
                        map.put("login",login);
                        redisUtil.set(JwtUtil.REDIS_KEY_PREFIX+token,JSON.toJSONString(login),JwtUtil.EXPIRE_TIME*2);
                    } else {
                        loginType = "admin";
                        ServletUtils.getSession().setAttribute("login",login);
                    }
                    map.put("loginType", loginType);
                    return new ResponeData<>(ResultEnum.SUCCESS,map);
                }else{
                    return new ResponeData(ResultEnum.ACCOUNT_ERROR,"");
                }
            }
            return new ResponeData(ResultEnum.CODE_CHECK_ERROR,"");
        }
        return new ResponeData(ResultEnum.CODE_CHECK_ERROR,"");


    }

    @ResponseBody
    @RequestMapping(value = "autoLogin",method = RequestMethod.POST)
    @PassLogin
    public ResponeData<Map> autoLogin(String token){
        if (StringUtils.isNotEmpty(token)){
            Object o = redisUtil.get(JwtUtil.REDIS_KEY_PREFIX + token);
            if (o!=null){
                Account account = JSON.parseObject(o.toString(), Account.class);
                String newToken = JwtUtil.reflashToken(account, JwtUtil.EXPIRE_TIME);
                redisUtil.del(JwtUtil.REDIS_KEY_PREFIX+token);
                redisUtil.set(JwtUtil.REDIS_KEY_PREFIX+newToken,o.toString(),JwtUtil.EXPIRE_TIME*2);
                Map<String,Object> map = new HashMap<>();
                map.put("token",newToken);
                map.put("login",account);
                return new ResponeData<>(map);
            }

        }
        return new ResponeData<>(ResultEnum.LOGIN_FAILED,null);
    }

    @ResponseBody
    @RequestMapping(value = "getAccount",method = RequestMethod.POST)
    public ResponeData<String> getAccountByToken(HttpServletRequest request) {
        Claims claims = JwtUtil.parseToken(request.getHeader("token"));
        String subject = claims.getSubject();
        return new ResponeData<>(ResultEnum.SUCCESS,subject);
    }


    /**
     * 添加用户
     * @param f
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @Permission(value = "sys:dict:add")
    public ResponeData<String> addUser(@Valid @RequestBody AccountField f ){
        return super.addUser(f);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    @Permission(value = "sys:dict:del")
    public ResponeData<String> delById(@PathVariable("id") String id){
        return super.delById(id);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @Permission(value = "sys:dict:edit")
    public ResponeData<String> update(@Valid @RequestBody AccountField f){
        return super.update(f);
    }


    @Override
    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ResponeData<List> findList(AccountField f){
        return super.findList(f);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public ResponeData<PageInfo> findPage(@RequestBody BasePageQuery<AccountField> basePageQuery){
        return super.findPage(basePageQuery);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    @Permission(value = "sys:dict:view")
    public ResponeData<Account> getById(@PathVariable("id") String id){
        return super.getById(id);
    }


    @GetMapping(value = "reCode")
    @PassLogin
    public void reCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //刷新验证码
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(100, 30);
        lineCaptcha.setGenerator(randomGenerator);
        // 重新生成code
        lineCaptcha.createCode();
        String code = lineCaptcha.getCode();
        //缓存验证码
        request.getSession().setAttribute("loginCode",code);
        lineCaptcha.write(response.getOutputStream());
    }

    @ResponseBody
    @RequestMapping(value = "fixPass",method = RequestMethod.POST)
    public ResponeData<String> checkPassword(@RequestBody AccountField accountField){
        Account account = AccountUtils.getAccount();
        accountField.setAccountId(account.getAccountId());
        accountField.setAccountNo(account.getAccountNo());
        accountField.setRole(account.getRole());
        String md5Hex = DigestUtil.md5Hex(account.getAccountNo() + accountField.getOldPassword());
        if (!md5Hex.equals(account.getPassword())) {
            return new ResponeData<>(ResultEnum.FIX_PASS_CHECK_PASS_FAILED,"");
        }
        if (!accountField.getPassword().equals(accountField.getRePassword())) {
            return new ResponeData<>(ResultEnum.PASSWORD_NO_EQU,"");
        }
        String newWord = DigestUtil.md5Hex(account.getAccountNo() + accountField.getPassword());
        accountField.setPassword(newWord);
        service.update(accountField);
        return new ResponeData<>("修改成功！");
    }
}
