package service.invitation;

import java.util.List;

import entity.Invitation;

public interface InvitationService {
	//查询帖子表的数据
	List<Invitation> getAll();
	//通过title模糊查询
	List<Invitation> getByTitle(String title);
	//删除帖子
	boolean delInvitation(int id);
	//查询数据库的条数
	int countInvitation();
}
