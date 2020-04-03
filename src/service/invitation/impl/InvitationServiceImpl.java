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
	 //����һ��InvitationMapper����
	 private InvitationMapper mapper;
	 //����һ��reply����
	 private ReplyService rs=new ReplyServiceImpl();
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
		sqlsession.close();
		return list;
	}
    //�Ȳ�ѯ�ظ����Ƿ�������
	//�о���ɾ���۱���ɾ�����ӱ�
	//����ֱ��ɾ�����ӱ�
	@Override
	public boolean delInvitation(int id) {
		//�Ȳ��ӱ��Ƿ�������
		List<Reply> lists=rs.getAllByInvid(id);
		sqlsession=MyBatisUtils.createSqlSession();
		mapper=sqlsession.getMapper(InvitationMapper.class);
		//û������
		if(lists.isEmpty()) {
			result=mapper.delInvitation(id);
			if(result>0) {
				sqlsession.commit();
				return true;
			}else {
			    return false;
			}
		}else {
			//������
			//��ɾ�ӱ�
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
    //��ѯ���ݿ������
	@Override
	public int countInvitation() {
		sqlsession=MyBatisUtils.createSqlSession();
		//���mapper����
		mapper=sqlsession.getMapper(InvitationMapper.class);
		result=mapper.countInvitation();
		MyBatisUtils.closeSqlSession(sqlsession);
		return result;
	}

}
