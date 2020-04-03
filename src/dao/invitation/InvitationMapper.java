package dao.invitation;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Invitation;

public interface InvitationMapper {
    //��ѯ���ӱ������
	List<Invitation> getAll();
	//ͨ��titleģ����ѯ
	List<Invitation> getByTitle(@Param("title") String title);
	//ɾ������
	int delInvitation(@Param("id") int id);
	int countInvitation();
} 
