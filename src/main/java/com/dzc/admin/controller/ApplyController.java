package com.dzc.admin.controller;

import com.dzc.admin.annotation.ValidToken;
import com.dzc.admin.common.Result;
import com.dzc.admin.common.jwt.JwtUtil;
import com.dzc.admin.model.Apply;
import com.dzc.admin.model.Device;
import com.dzc.admin.model.UserInfo;
import com.dzc.admin.service.ApplyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 董政辰
 * @date: 2021/3/10 19:28
 * @description:
 * @email：532587041@qq.com
 */
@RestController
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @ValidToken
    @PostMapping("/add")
    public Result apply(@RequestBody Apply apply){
        return applyService.addApply(apply);
    }

    @GetMapping("/get")
    public Result getApplys(){
        return applyService.getAllApplys();
    }
    
    @GetMapping("/log/{uid}")
    public Result applyLog(@PathVariable("uid") Integer uid){
        return applyService.getApplyLog(uid);
    }

    @ValidToken
    @PostMapping("/delLogs")
    public Result delAllLogs(@RequestBody UserInfo user){
        return applyService.delAllLogs(user.getId());
    }

    @ValidToken
    @PostMapping("/agree/{num}/{uid}/{aid}")
    public Result agreeApply(@RequestBody Device device, @PathVariable("num") Integer num,@PathVariable("uid") Integer uid,@PathVariable("aid") Integer applyId){
        return applyService.agree(device,num,uid,applyId);
    }

    @ValidToken
    @PostMapping("/disagree/{num}/{uid}/{aid}")
    public Result rejectApply(@RequestBody Device device, @PathVariable("num") Integer num,@PathVariable("uid") Integer uid,@PathVariable("aid") Integer applyId){
        return applyService.disagree(device,num,uid,applyId);
    }

}
