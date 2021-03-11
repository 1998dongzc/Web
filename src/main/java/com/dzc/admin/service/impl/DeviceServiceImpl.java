package com.dzc.admin.service.impl;

import com.dzc.admin.common.Result;
import com.dzc.admin.dao.ApplyMapper;
import com.dzc.admin.dao.DeviceMapper;
import com.dzc.admin.model.Device;
import com.dzc.admin.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: 董政辰
 * @date: 2021/3/10 10:31
 * @description:
 * @email：532587041@qq.com
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    @Transactional
    public Result addDeivce(Device device, int num) {
        for (int i = 0; i < num; i++) {
            int res = deviceMapper.insertSelective(device);
            if (res < 0)
                return Result.fail("增加设备失败!");
        }
        return Result.success("增加设备成功");
    }

    @Override
    public Result getAllDevices() {
        return Result.success(deviceMapper.selectAllDevices());
    }

    @Override
    @Transactional
    public Result delDevice(List<Integer> listId) {
        for (Integer id : listId) {
            int i = deviceMapper.deleteByPrimaryKey(id);
            if (i != 1)
                return Result.fail("删除设备失败");
        }
        return Result.success("删除成功");
    }

}
