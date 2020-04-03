package service.invitation;

import java.util.List;

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
}
