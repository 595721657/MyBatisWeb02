package controller.reply;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reply;
import service.reply.ReplyService;
import service.reply.impl.ReplyServiceImpl;
@WebServlet("/Reply")
public class ReplyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6677395249838463501L;
    private ReplyService rs=new ReplyServiceImpl();
    List<Reply> list;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收页面数据
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
		if("find".equals(op)) {
			//调用显示通过invid查询数据
			findReply(req,resp);
		}else if("add".equals(op)) {
			//添加评论
		    addReply(req,resp);
		}
	}
   //添加评论
	private void addReply(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 设置编码格式
			req.setCharacterEncoding("UTF-8");
			int invid=(int) req.getSession().getAttribute("invid");
			System.out.println(""+invid);
			String author=req.getParameter("author");
			String content=req.getParameter("content");
			//创建一个reply对象
			Reply reply=new Reply();
			reply.setAuthor(author);
			reply.setContent(content);
			reply.setCreatedate(new Date());
			reply.setInvid(invid);
			boolean isOK=rs.addReply(reply);
			if(isOK) {
				resp.sendRedirect("Reply?op=find&invid="+invid);
			}else {
				resp.sendRedirect("add_reply.jsp");
			}			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
   //通过invid查询数据
	private void findReply(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 设置编码格式
			req.setCharacterEncoding("UTF-8");
			int invid=Integer.parseInt(req.getParameter("invid"));
			list=rs.getAllByInvid(invid);
			req.getSession().setAttribute("invid", invid);
			req.getSession().setAttribute("reply", list);
			req.getRequestDispatcher("demo.jsp").forward(req, resp);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
