package service.invitation;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Invitation;

public interface InvitationService {
	//��ѯ���ӱ������
	List<Invitation> getAll();
	//ͨ��titleģ����ѯ
	List<Invitation> getByTitle(String title);
	//ɾ������
	boolean delInvitation(int id);
	//��ѯ���ݿ������
	int countInvitation();
	//ͨ��titleģ����ѯ���������ķ���
	int countInvitationBytitle(String title);
	//ֱ�ӷ�ҳ�ķ�ҳ�ķ���
	List<Invitation> getPageLists(@Param("currPage") int currPage,@Param("pageSize") int pageSize);
	//ͨ��title��ѯ��ҳ�ķ���
	List<Invitation> getPageListsByTitle(@Param("currPage") int currPage,@Param("pageSize") int pageSize,@Param("title") String title);
}
