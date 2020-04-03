package service.reply.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import commons.MyBatisUtils;
import dao.reply.ReplyMapper;
import entity.Reply;
import service.reply.ReplyService;

public class ReplyServiceImpl implements ReplyService {
	 //创建一个ReplyMapper对象
	 private ReplyMapper mapper;
	 //创建一个SqlSession
	 private SqlSession sqlsession;
	 //创建一个集合
	 private List<Reply> list;
	 //创建一个result
	 private int result; 
	 //通过invid查询数据
	@Override
	public List<Reply> getAllByInvid(int invid) {
		sqlsession=MyBatisUtils.createSqlSession();
		mapper=sqlsession.getMapper(ReplyMapper.class);
		list=mapper.getAllByInvid(invid);
		sqlsession.close();
		return list;
	}
    //添加数据
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
