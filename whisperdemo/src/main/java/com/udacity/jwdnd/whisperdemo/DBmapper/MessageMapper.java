package com.udacity.jwdnd.whisperdemo.DBmapper;
import com.udacity.jwdnd.whisperdemo.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT messageid, username, 'dummy' type, messagetext FROM MESSAGES WHERE username = #{username}")
    List<ChatMessage> getChatMessage(String username);

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{message})")
    //@Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES()")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insert(ChatMessage chatmessage);

}