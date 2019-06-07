package com.ljy.service;

import com.ljy.entities.ChatRecordEntity;
import com.ljy.entities.UserEntity;

public interface TalkingService {
    UserEntity getUserInfo(String username);

    void removeTalking(Integer id, String username);

    ChatRecordEntity insertChatRecord(ChatRecordEntity chatRecordEntity);
}
