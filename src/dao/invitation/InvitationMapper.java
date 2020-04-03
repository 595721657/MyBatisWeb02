package dao.invitation;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Invitation;

public interface InvitationMapper {
    //查询帖子表的数据
	List<Invitation> getAll();
	//通过title模糊查询
	List<Invitation> getByTitle(@Param("title") String title);
	//删除帖子
	int delInvitation(@Param("id") int id);
	int countInvitation();
} 
