package service.reply.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import commons.MyBatisUtils;
import dao.reply.ReplyMapper;
import entity.Reply;
import service.reply.ReplyService;

public class ReplyServiceImpl implements ReplyService {
	 //����һ��ReplyMapper����
	 private ReplyMapper mapper;
	 //����һ��SqlSession
	 private SqlSession sqlsession;
	 //����һ������
	 private List<Reply> list;
	 //����һ��result
	 private int result; 
	 //ͨ��invid��ѯ����
	@Override
	public List<Reply> getAllByInvid(int invid) {
		sqlsession=MyBatisUtils.createSqlSession();
		mapper=sqlsession.getMapper(ReplyMapper.class);
		list=mapper.getAllByInvid(invid);
		sqlsession.close();
		return list;
	}
    //�������
	@Override
	public boolean addReply(Reply re) {
		sqlsession=MyBatisUtils.createSqlSession();
		mapper=sqlsession.getMapper(ReplyMapper.class);
		result=mapper.addReply(re);
		if(result>0) {
			sqlsession.commit();
			return true;
		}else {
		    return false;
		}
	}
	@Override
	public boolean delReply(int invid) {
		sqlsession=MyBatisUtils.createSqlSession();
		mapper=sqlsession.getMapper(ReplyMapper.class);
		result=mapper.delReply(invid);
		if(result>0) {
			sqlsession.commit();
			return true;
		}else {
		    return false;
		}
	}

}
