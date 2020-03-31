package controller.invitation;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Invitation;
import service.invitation.InvitationService;
import service.invitation.impl.InvitationServiceImpl;
@WebServlet("/Invitation")
public class InvitationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5181297810642333186L;
    private InvitationService iis=new InvitationServiceImpl();
    private List<Invitation> list;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����ҳ������
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
		if("show".equals(op)) {
			//������ʾȫ������
			showInvitation(req,resp);
		}else if("find".equals(op)) {
			//����ģ����ѯ
		    findInvitation(req,resp);
		}else if("del".equals(op)) {
			delInvitation(req,resp);
		}
	}
	//ɾ������
	private void delInvitation(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			int id= Integer.parseInt(req.getParameter("id"));
			boolean isOK=iis.delInvitation(id);
			PrintWriter out = resp.getWriter();
			if(isOK) {
				//ɾ���ɹ�
				out.write("true");
			}else {
				//ɾ��ʧ��
				out.write("false");
			}
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//ͨ��titleģ����ѯ
    private void findInvitation(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			String title= req.getParameter("title");
			if("".equals(title)) {
				list=iis.getAll();
			}else {
				list=iis.getByTitle(title);
			}
			req.getSession().setAttribute("invitation", list);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//��ѯ���е�����
	private void showInvitation(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//��ѯȫ�����ݵķ���
			list=iis.getAll();
			req.getSession().setAttribute("invitation", list);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
