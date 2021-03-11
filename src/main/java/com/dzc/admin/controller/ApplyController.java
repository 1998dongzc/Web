package com.dzc.admin.controller;

import com.dzc.admin.common.Result;
import com.dzc.admin.model.Apply;
import com.dzc.admin.model.Device;
import com.dzc.admin.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private ApplyService applyDevice;

    @PostMapping("/add")
    public Result apply(@RequestBody Apply apply){
        return applyDevice.addApply(apply);
    }

    @GetMapping("/get")
    public Result getApplys(){
        return applyDevice.getAllApplys();
    }

    @PostMapping("/agree/{num}/{uid}")
    public Result agreeApply(@RequestBody Device device, @PathVariable("num") Integer num,@PathVariable("uid") Integer uid){
        return applyDevice.agree(device,num,uid);
    }

}
