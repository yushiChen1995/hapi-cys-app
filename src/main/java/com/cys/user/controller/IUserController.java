package com.cys.user.controller;

import com.cys.user.contract.req.CreateUserInfoRequest;
import com.cys.user.contract.resp.QueryUserInfoResult;
import com.cys.user.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author cys
 * @date 2019/6/28
 */
@Api(tags={"user"})
@RequestMapping(value="/user", method = RequestMethod.POST)
public interface IUserController {

    /**
     * 根据手机号注册用户
     * @param request CreateUserInfoRequest
     * @return QueryUserInfoResult
     */
    @PostMapping("registerUser")
    @ApiOperation(value="用户注册" , notes="根据手机号注册")
    ResponseEntity<QueryUserInfoResult> registerUser(@RequestBody @Valid CreateUserInfoRequest request);

    @GetMapping("/user/{id}")
    ResponseEntity<User> queryUser(@PathVariable("id") Long id);
}
