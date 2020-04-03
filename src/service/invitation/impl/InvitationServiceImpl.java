package service.invitation.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import commons.MyBatisUtils;
import dao.invitation.InvitationMapper;
import entity.Invitation;
import entity.Reply;
import service.invitation.InvitationService;
import service.reply.ReplyService;
import service.reply.impl.ReplyServiceImpl;

public class InvitationServiceImpl implements InvitationService {
	 //创建一个InvitationMapper对象
	 private InvitationMapper mapper;
	 //创建一个reply对象
	 private ReplyService rs=new ReplyServiceImpl();
	 //创建一个SqlSession
	 private SqlSession sqlsession;
	 //创建一个集合
	 private List<Invitation> list;
	 //创建一个result
	 private int result; 
	@Override
	public List<Invitation> getAll() {
		sqlsession=MyBatisUtils.createSqlSession();
		//获得mapper对象
		mapper=sqlsession.getMapper(InvitationMapper.class);
		list=mapper.getAll();
		MyBatisUtils.closeSqlSession(sqlsession);
		return list;
	}

	@Override
	public List<Invitation> getByTitle(String title) {
		sqlsession=MyBatisUtils.createSqlSession();
		mapper=sqlsession.getMapper(InvitationMapper.class);
		list=mapper.getByTitle(title);
		sqlsession.close();
		return list;
	}
    //先查询回复表是否有数据
	//有就先删评论表在删除帖子表
	//反正直接删除帖子表
	@Override
	public boolean delInvitation(int id) {
		//先查子表是否有数据
		List<Reply> lists=rs.getAllByInvid(id);
		sqlsession=MyBatisUtils.createSqlSession();
		mapper=sqlsession.getMapper(InvitationMapper.class);
		//没有数据
		if(lists.isEmpty()) {
			result=mapper.delInvitation(id);
			if(result>0) {
				sqlsession.commit();
				return true;
			}else {
			    return false;
			}
		}else {
			//有数据
			//先删子表
			boolean isOK=rs.delReply(id);
			result=mapper.delInvitation(id);
			if(isOK && result>0) {
				sqlsession.commit();
				return true;
			}else {
			    return false;
			}
		}
	}
    //查询数据库的条数
	@Override
	public int countInvitation() {
		sqlsession=MyBatisUtils.createSqlSession();
		//获得mapper对象
		mapper=sqlsession.getMapper(InvitationMapper.class);
		result=mapper.countInvitation();
		MyBatisUtils.closeSqlSession(sqlsession);
		return result;
	}

}
