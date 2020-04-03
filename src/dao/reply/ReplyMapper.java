package dao.reply;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Reply;

public interface ReplyMapper {
    //通过invid的查询
	List<Reply> getAllByInvid(@Param("invid") int invid);
	//添加评论
	int addReply(Reply re);
	int delReply(@Param("invid") int invid);
}
