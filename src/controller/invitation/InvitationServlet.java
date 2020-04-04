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

import entity.Pager;
import service.invitation.InvitationService;
import service.invitation.impl.InvitationServiceImpl;
@WebServlet("/Invitation")
public class InvitationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5181297810642333186L;
    private InvitationService iis=new InvitationServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收页面数据
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
		if("show".equals(op)) {
			//调用显示全部数据
			showInvitation(req,resp);
		}else if("find".equals(op)) {
			//调用模糊查询
		    findInvitation(req,resp);
		}else if("del".equals(op)) {
			delInvitation(req,resp);
		}
	}
	//删除帖子
	private void delInvitation(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			int id= Integer.parseInt(req.getParameter("id"));
			boolean isOK=iis.delInvitation(id);
			PrintWriter out = resp.getWriter();
			if(isOK) {
				//删除成功
				out.write("true");
			}else {
				//删除失败
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

	//通过title模糊查询
    @SuppressWarnings("unchecked")
	private void findInvitation(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			String title= req.getParameter("title");
			if(title==null ||"".equals(title)) {
			    showInvitation(req, resp);
			}else {
				//获取页码
				String pageIndex=req.getParameter("pageIndex");
				int currpage=1; 
				//创建一个分页对象
				Pager pg=new Pager();
				//获取数据总条数
				int totalCount=iis.countInvitationBytitle(title);
				pg.setTotalCount(totalCount);
				if(pageIndex==null || "".equals(pageIndex)) {
					currpage=1;
				}else {
					int num=Integer.parseInt(pageIndex);
					if(num<=0) {
						currpage=1;
					}else if(num>=pg.getTotalPages()) {
						currpage=pg.getTotalPages();
					}else {
						currpage=num;
					}
				}
					pg.setCurrPage(currpage);
					int form=(currpage-1)*pg.getTotalPages();
					@SuppressWarnings("rawtypes")
					List lists=iis.getPageListsByTitle(form, pg.getPageSize(), title);
					pg.setPageLists(lists);
					req.getSession().setAttribute("pg", pg);
					req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//查询所有的帖子
	@SuppressWarnings("unchecked")
	private void showInvitation(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//获取页码
			String pageIndex=req.getParameter("pageIndex");
			int currpage=1; 
			//创建一个分页对象
			Pager pg=new Pager();
			//获取数据总条数
			int totalCount=iis.countInvitation();
			pg.setTotalCount(totalCount);
			if(pageIndex==null || "".equals(pageIndex)) {
				currpage=1;
			}else {
				int num=Integer.parseInt(pageIndex);
				if(num<=0) {
					currpage=1;
				}else if(num>=pg.getTotalPages()) {
					currpage=pg.getTotalPages();
				}else {
					currpage=num;
				}
			}
			pg.setCurrPage(currpage);
			int form=(currpage-1)*pg.getTotalPages();
			@SuppressWarnings("rawtypes")
			List lists=iis.getPageLists(form, pg.getPageSize());
			pg.setPageLists(lists);
			req.getSession().setAttribute("pg", pg);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
