package com.ljy.dao;

import com.ljy.entities.ChatRecordEntity;
import org.apache.ibatis.annotations.Param;

public interface ChatRecordDao {

    ChatRecordEntity getChatRecordById(@Param("id") Integer id);

    ChatRecordEntity getChatRecordByUserId(@Param("userid") Integer userid);

}
