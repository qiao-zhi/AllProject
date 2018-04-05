
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoadResource
 */
@WebServlet("/DownLoadResource")
public class kdmt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kdmt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取资源真实路径
		String path=this.getServletContext().getRealPath("/download/kdmt.jpg");
		//读取资源名字,截取从最后一个反斜杠位置路径名字即为资源名字
	    String fileName=path.substring(path.lastIndexOf("\\")+1);
	    System.out.println(fileName);
	    System.out.println(request.getLocalAddr());
	    
	    //若名字为中文名字，需要用URL编码
	    response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));
	    InputStream in=null;
	    OutputStream  out=null;
	    System.out.println(path);
	    in=new FileInputStream(path);
	    int len=0;
	    byte buffer[]=new byte[1024];
	    out=response.getOutputStream();
	    while((len=in.read(buffer))>0){
	    	out.write(buffer, 0,len);
	    }
	    in.close();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
