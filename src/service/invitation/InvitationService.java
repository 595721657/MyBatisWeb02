package service.invitation;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	//通过title模糊查询数据条数的方法
	int countInvitationBytitle(String title);
	//直接分页的分页的方法
	List<Invitation> getPageLists(@Param("currPage") int currPage,@Param("pageSize") int pageSize);
	//通过title查询分页的方法
	List<Invitation> getPageListsByTitle(@Param("currPage") int currPage,@Param("pageSize") int pageSize,@Param("title") String title);
}
