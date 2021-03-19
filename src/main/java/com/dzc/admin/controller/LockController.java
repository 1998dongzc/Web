package com.dzc.admin.controller;

import com.dzc.admin.annotation.ValidToken;
import com.dzc.admin.common.Result;
import com.dzc.admin.common.constant.Info;
import com.dzc.admin.model.Device;
import com.dzc.admin.service.LockService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;

/**
 * @author: 董政辰
 * @date: 2021/3/12 12:01
 * @description:
 * @email：532587041@qq.com
 */
@RestController
@RequestMapping("/ops")
public class LockController {

    @Autowired
    private LockService lockService;

    @ValidToken
    @RequestMapping("/lock")
    public Result lockDevice(@RequestBody Device device) throws IOException {
        return lockService.opsForlock(device, Info.LOCK_TEXT);
    }

    @ValidToken
    @RequestMapping("/unlock")
    public Result unlockDevice(@RequestBody Device device) throws IOException {
        return lockService.opsForlock(device, Info.UNLOCK_TEXT);
    }

}
