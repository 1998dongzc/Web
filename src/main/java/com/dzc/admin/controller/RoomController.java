package com.dzc.admin.controller;

import com.dzc.admin.annotation.ValidToken;
import com.dzc.admin.common.Result;
import com.dzc.admin.dao.BuildingMapper;
import com.dzc.admin.dao.RoomMapper;
import com.dzc.admin.model.Building;
import com.dzc.admin.model.Room;
import com.dzc.admin.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 董政辰
 * @date: 2021/3/10 11:09
 * @description:
 * @email：532587041@qq.com
 */
@RestController
@RequestMapping("build")
public class RoomController {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private RoomService roomService;

    @GetMapping("/getRoom")
    public Result getRoom(){
        List<Room> rooms = roomMapper.selectRooms();
        return Result.success(rooms);
    }

    @GetMapping("/getRoomByBid/{bid}")
    public Result getRoomByBid(@PathVariable int bid){
        List<Room> rooms = roomMapper.selectRoomsByBuildingId(bid);
        return Result.success(rooms);
    }

    @GetMapping("/getBuilding")
    public Result getBuilding(){
        List<Building> buildings = buildingMapper.selectBuidings();
        return Result.success(buildings);
    }

    @GetMapping("/getBuilding/{id}")
    public Result getBuildingById(@PathVariable("id") int id){
        Building building = buildingMapper.selectByPrimaryKey(id);
        return Result.success(building);
    }

    @ValidToken
    @PostMapping("/addBuild")
    public Result addBuild(@RequestBody Building building){
        return roomService.addBuild(building);
    }

    @ValidToken
    @PostMapping("/delBuild")
    public Result delBuild(@RequestBody Building building){
        return roomService.delBuild(building);
    }

    @ValidToken
    @PostMapping("/addRoom")
    public Result addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @ValidToken
    @PostMapping("/delRoom")
    public Result delRoom(@RequestBody Room room){
        return roomService.delRoom(room);
    }
}
