package service.invitation.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import commons.MyBatisUtils;
import dao.invitation.InvitationMapper;
import entity.Invitation;
import service.invitation.InvitationService;

public class InvitationServiceImpl implements InvitationService {
	 //创建一个InvitationMapper对象
	 private InvitationMapper mapper;
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
		return list;
	}

	@Override
	public boolean delInvitation(int id) {
		sqlsession=MyBatisUtils.createSqlSession();
		mapper=sqlsession.getMapper(InvitationMapper.class);
		result=mapper.delInvitation(id);
		if(result>0) {
			sqlsession.commit();
			return true;
		}else {
		    return false;
		}
	}

}
