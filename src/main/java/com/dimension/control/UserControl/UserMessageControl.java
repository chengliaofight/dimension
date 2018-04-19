package com.dimension.control.UserControl;

import com.dimension.dao.MessageMapper;
import com.dimension.pojo.Message;
import com.dimension.pojo.MessageConditon;
import com.dimension.pojo.User;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserMessageControl {
    @Resource
    private MessageMapper messageMapper;
    private static final int count = 10;
    //查看信息，并且回复信息，并设置信息为无效
    @RequestMapping("/message")
    public String message(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        MessageConditon messageConditon = new MessageConditon();
        messageConditon.setCount(count);
        messageConditon.setStart(0);
        messageConditon.setState("1");
        messageConditon.setUserId(user.getId());
        List<Message> messages = messageMapper.selectMessage(messageConditon);
        int totalCount = messageMapper.count(messageConditon);
        int totalPage = (totalCount + count - 1) / count;
        JSONArray messagesJson = new JSONArray(messages);
        model.addAttribute("messages", messages);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("messagesJson", messagesJson);
        model.addAttribute("currentPage", 1);
        return "/user/message";
    }
    @RequestMapping("/message/{start}")
    @ResponseBody
    public Map<String, Object> messageAjax(@PathVariable Integer start, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        start--;
        User user = (User) session.getAttribute("user");
        MessageConditon messageConditon = new MessageConditon();
        messageConditon.setCount(count);
        messageConditon.setStart(0);
        messageConditon.setState("1");
        messageConditon.setUserId(user.getId());
        List<Message> messages = messageMapper.selectMessage(messageConditon);
        if (messages.size() == 0&& start!=0) {
            start--;
            messageConditon.setStart(start);
            messages = messageMapper.selectMessage(messageConditon);
        }

        int totalCount = messageMapper.count(messageConditon);
        int totalPage = (totalCount + count - 1) / count;
        map.put("messages", messages);
        map.put("totalPage", totalPage);
        map.put("currentPage", start+1);
        return map;

    }
    @RequestMapping("message/addMessage")
    @ResponseBody
    public Map<String, Object> addMessage(Message message,HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        User user= (User) session.getAttribute("user");
        if(user.getRoleid()==2){
            message.setDepartionid(user.getDepartmentid());
        }
        message.setSubmittime(new Date());
        message.setUserid(user.getId());
        messageMapper.insertSelective(message);
        return map;
    }
    @RequestMapping("message/deleteMessage")
    @ResponseBody
    public Map<String, Object> deleteMessage(Integer Id) {
        messageMapper.deleteByPrimaryKey(Id);
        return new HashMap<>();
    }
}
