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
	//��ѯ���ݿ�����
	int countInvitation();
	//ͨ��title��ѯ���ݿ������
	int countInvitationBytitle(@Param("title") String title);
    //ֱ�ӷ�ҳ�ķ�ҳ�ķ���
	List<Invitation> getPageLists(@Param("form") int currPage,@Param("pageSize") int pageSize);
	//ͨ��title��ѯ��ҳ�ķ���
	List<Invitation> getPageListsByTitle(@Param("form") int currPage,@Param("pageSize") int pageSize,@Param("title") String title);
} 
