package dao.reply;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Reply;

public interface ReplyMapper {
    //ͨ��invid�Ĳ�ѯ
	List<Reply> getAllByInvid(@Param("invid") int invid);
	//�������
	int addReply(Reply re);
	int delReply(@Param("invid") int invid);
}
