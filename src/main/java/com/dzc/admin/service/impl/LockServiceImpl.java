package com.dzc.admin.service.impl;

import com.dzc.admin.common.Result;
import com.dzc.admin.dao.DeviceMapper;
import com.dzc.admin.model.Device;
import com.dzc.admin.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author: 董政辰
 * @date: 2021/3/16 18:03
 * @description:
 * @email：532587041@qq.com
 */
@Service
public class LockServiceImpl implements LockService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    @Transactional
    public Result opsForlock(Device device, String ops) throws IOException {
        String message = "";
        int status;
        if ("lock".equals(ops)) {
            status = 0;
            message = "上锁";
        } else {
            message = "解锁";
            status = 1;
        }
        String ip = device.getIp();

        device.setStatus(status);

        Socket socket = null;
        PrintWriter out = null;
        try {
            socket = new Socket(ip, 9998);
            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.write(ops + "|" + ip);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(message + "失败");
        } finally {
            if (out != null && socket != null) {
                out.close();
                socket.close();
            }else
                return Result.fail("网络连接失败");
            String opsInRedis = (String) redisTemplate.opsForValue().get(ip);
            if (ops.equals(opsInRedis)) {
                // 数据库中设备状态更新
                int res = deviceMapper.updateByPrimaryKeySelective(device);
                if (res != 1) {
                    return Result.fail(message + "失败");
                } else {
                    return Result.success(message + "成功");
                }
            } else
                return Result.fail(message + "失败");
        }
    }

}
