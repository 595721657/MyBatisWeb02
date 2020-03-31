package service.invitation.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import commons.MyBatisUtils;
import dao.invitation.InvitationMapper;
import entity.Invitation;
import service.invitation.InvitationService;

public class InvitationServiceImpl implements InvitationService {
	 //����һ��InvitationMapper����
	 private InvitationMapper mapper;
	 //����һ��SqlSession
	 private SqlSession sqlsession;
	 //����һ������
	 private List<Invitation> list;
	 //����һ��result
	 private int result; 
	@Override
	public List<Invitation> getAll() {
		sqlsession=MyBatisUtils.createSqlSession();
		//���mapper����
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
