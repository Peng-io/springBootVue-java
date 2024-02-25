package com;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mapper.DormRoomMapper;
import com.mapper.RepairMapper;
import com.mapper.StudentMapper;
import com.mapper.WorkerMapper;
import com.service.AdminService;
import com.service.NoticeService;
import com.service.RepairService;
import com.service.StudentService;
import com.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBootVueApplicationTests {

    @Resource
    StudentService studentService;

    @Resource
    StudentMapper studentMapper;
    @Resource
    NoticeService noticeService;

    @Resource
    AdminService adminService;

    @Resource
    WorkerMapper workerMapper;

    @Resource
    DormRoomMapper dormRoomMapper;

    @Resource
    RepairMapper repairMapper;
    @Resource
    RepairService repairService;

    @Test
    public void contextLoads() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "digua");
        String token = JwtUtils.createToken(map);
        DecodedJWT decodedJWT = JwtUtils.verifyToken(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("name"));
    }

    @Test
    public void test1() {
        System.out.println(repairService.individualFind(1, 10, "", "0912200201"));
    }

}
