package service.reply;

import java.util.List;

import entity.Reply;

public interface ReplyService {
	//ͨ��invid��ѯ����
	List<Reply> getAllByInvid(int invid);
	//�������
	boolean addReply(Reply re);
}
