package com.ljy.dao;

import com.ljy.entities.ChatRecordEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatRecordDao {

    ChatRecordEntity getChatRecordById(@Param("id") Integer id);

    ChatRecordEntity getChatRecordByUserId(@Param("userid") Integer userid);

    void removeChatRecordById(@Param("id") Integer id);

    int insertChatRecord(ChatRecordEntity chatRecordEntity);
}
