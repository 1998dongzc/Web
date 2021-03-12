package com.dzc.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * @author: 董政辰
 * @date: 2021/3/12 12:01
 * @description:
 * @email：532587041@qq.com
 */
@Controller
public class TestController {

    @RequestMapping("/lock")
    public void lock() throws IOException, AWTException {
        Runtime.getRuntime().exec("RunDll32.exe user32.dll,LockWorkStation");
    }

    @RequestMapping("/unlock")
    public void unlock() throws AWTException, InterruptedException {
        Long keyTime=200L;
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_0 );
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_5);
        robot.keyRelease(KeyEvent.VK_5);
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_8);
        robot.keyRelease(KeyEvent.VK_8);
    }

    public static void main(String[] args) throws InterruptedException, AWTException {
        Long keyTime=200L;
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_0 );
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_5);
        robot.keyRelease(KeyEvent.VK_5);
        Thread.sleep(keyTime);
        robot.keyPress(KeyEvent.VK_8);
        robot.keyRelease(KeyEvent.VK_8);
    }

    public static void main1(String[] args) throws InterruptedException {
        for (int i=0;i<1000;i++){
            Thread.sleep(1000);
            System.out.println(i+"==="+i);
        }
    }

}
