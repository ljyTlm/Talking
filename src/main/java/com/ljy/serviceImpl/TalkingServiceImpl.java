package com.ljy.serviceImpl;

import com.ljy.dao.ChatRecordDao;
import com.ljy.dao.UserDao;
import com.ljy.entities.ChatRecordEntity;
import com.ljy.entities.UserEntity;
import com.ljy.service.TalkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "TalkingService")
public class TalkingServiceImpl implements TalkingService {

    @Autowired
    UserDao userDao;

    @Autowired
    ChatRecordDao chatRecordDao;

    @Override
    public UserEntity getUserInfo(String username) {
        UserEntity user = userDao.getUserByName(username);
        user.setPassword("");
        return user;
    }

    @Override
    public void removeTalking(Integer id, String username) {
        ChatRecordEntity chat = chatRecordDao.getChatRecordById(id);
        if (chat.getUsername().equals(username)){
            chatRecordDao.removeChatRecordById(id);
        }
    }

    @Override
    public ChatRecordEntity insertChatRecord(ChatRecordEntity chatRecordEntity) {
        chatRecordDao.insertChatRecord(chatRecordEntity);
        return chatRecordDao.getChatRecordById(chatRecordEntity.getId());
    }
}
