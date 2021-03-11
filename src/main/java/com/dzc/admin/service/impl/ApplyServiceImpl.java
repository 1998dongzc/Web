package com.dzc.admin.service.impl;

import com.dzc.admin.common.Result;
import com.dzc.admin.dao.ApplyMapper;
import com.dzc.admin.model.Apply;
import com.dzc.admin.model.Device;
import com.dzc.admin.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 董政辰
 * @date: 2021/3/10 19:27
 * @description:
 * @email：532587041@qq.com
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public Result addApply(Apply apply) {
        int res = applyMapper.insertSelective(apply);
        if (res!=1)
            return Result.fail("申请失败");
        return Result.success("申请成功");
    }

    @Override
    public Result getAllApplys() {
        return Result.success(applyMapper.selectAllApplys());
    }

    @Override
    public Result agree(Device device, Integer num, Integer uid) {
        System.out.println(device);
        System.out.println(num);
        System.out.println(uid);
        return null;
    }

}
