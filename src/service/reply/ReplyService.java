package service.reply;

import java.util.List;

import entity.Reply;

public interface ReplyService {
	//通过invid查询数据
	List<Reply> getAllByInvid(int invid);
	//添加评论
	boolean addReply(Reply re);
}
