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
	//查询数据库条数
	int countInvitation();
	//通过title查询数据库的条数
	int countInvitationBytitle(@Param("title") String title);
    //直接分页的分页的方法
	List<Invitation> getPageLists(@Param("form") int currPage,@Param("pageSize") int pageSize);
	//通过title查询分页的方法
	List<Invitation> getPageListsByTitle(@Param("form") int currPage,@Param("pageSize") int pageSize,@Param("title") String title);
} 
