package com.mapper;

import com.model.DormRoom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DormRoomMapper {
    //统计没有住满的宿舍数量
    public int notFullRoom();

    //新增房间
    int addNewRoom(DormRoom dormRoom);

    //更新房间信息
    int updateNewRoom(DormRoom dormRoom);

    //删除房间信息
    int deleteRoom(Integer dormRoomId);

    //主页 住宿人数
    Long selectHaveRoomStuNum();

    //获取每栋宿舍学生总人数
    Long getEachBuildingStuNum(int dormBuildId);

}