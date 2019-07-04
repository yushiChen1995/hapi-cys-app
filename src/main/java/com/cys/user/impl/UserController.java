package com.cys.user.impl;

import com.cys.user.api.IUserService;
import com.cys.user.contract.req.CreateUserInfoRequest;
import com.cys.user.contract.resp.QueryUserInfoResult;
import com.cys.user.controller.IUserController;
import com.cys.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author cys
 * @date 2019/6/28
 */
@RestController
public class UserController implements IUserController {

    @Autowired
    private IUserService userService;

    @Override
    @PostMapping("registerUser")
    public ResponseEntity<QueryUserInfoResult> registerUser(@RequestBody @Valid CreateUserInfoRequest request) {
        QueryUserInfoResult result = userService.registerUserByMobile(request);
        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping("/user/{id}")
    public ResponseEntity<User> queryUser(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
