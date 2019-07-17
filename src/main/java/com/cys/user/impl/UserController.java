package com.cys.user.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cys.pojo.Response;
import com.cys.user.api.IUserService;
import com.cys.user.contract.req.CreateUserInfoRequest;
import com.cys.user.contract.resp.QueryUserInfoResult;
import com.cys.user.controller.IUserController;
import com.cys.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author cys
 * @date 2019/6/28
 */
@RestController
public class UserController implements IUserController {

    @Autowired
    private IUserService userService;
    @Value("${name:default}")
    private String name;

    @Override
    @PostMapping("registerUser")
    public Response<QueryUserInfoResult> registerUser(@RequestBody @Valid CreateUserInfoRequest request) {
        QueryUserInfoResult result = userService.registerUserByMobile(request);
        return new Response<>(result);
    }


    @Override
    @GetMapping("/user/testApollo")
    public String testApollo() {
        return name;
    }

    @Override
    @GetMapping("/user/{id}")
    public ResponseEntity<User> queryUser(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


}
