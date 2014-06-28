package com.njceb.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/uploadwordimg.action")
public class WordImageUploaderController {
	protected final Logger logger = Logger
			.getLogger(WordImageUploaderController.class);
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
	  {
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    String ext = ".png";
//	    String dir = getServletContext().getRealPath("/word_images");
	    String dir = request.getSession().getServletContext()
		.getRealPath("/word_images");
	    
	    File fft = new File(dir);
	    if (!fft.exists()) {
	      fft.mkdir();
	    }
	    String name = request.getParameter("unique_name");
	    Map map = request.getParameterMap();
	    Set<String> keys = map.keySet();
	    for (String s : keys) {
	      System.out.println(s + ":" + map.get(s));
	    }
	    if (name == null) {
	      name = UUID.randomUUID().toString();
	    }
	    String nfn = dir + "/" + name + ext;
	    System.out.println(nfn);
	    try
	    {
	      FileItemFactory factory = new DiskFileItemFactory();
	      ServletFileUpload fu = new ServletFileUpload(factory);
	      fu.setSizeMax(9223372036854775807L);
	      


	      List fileItems = fu.parseRequest(request);
	      Iterator iter = fileItems.iterator();
	      while (iter.hasNext())
	      {
	        FileItem item = (FileItem)iter.next();
	        if (!item.isFormField())
	        {
	          OutputStream fos = new FileOutputStream(nfn);
	          InputStream fis = item.getInputStream();
	          BufferedInputStream is = new BufferedInputStream(fis);
	          BufferedOutputStream os = new BufferedOutputStream(fos);
	          
	          IOUtils.copy(is, os);
	          
	          os.flush();
	          fos.flush();
	          
	          os.close();
	          is.close();
	          fis.close();
	          break;
	        }
	      }
	      String host = request.getServerName();
	      int port = request.getServerPort();
	      String path = request.getContextPath();
	      String data = "http://" + host + ":" + port + path + "/word_images/" + name + ext;
	      out.print(data);
	    }
	    catch (Exception eee)
	    {
	      String data = "error";
	      out.print(data);
	      eee.printStackTrace();
	    }
	    finally
	    {
	      out.close();
	    }
	  }
	  
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
	  {
	    processRequest(request, response);
	  }
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
	  {
	    processRequest(request, response);
	  }
	  
	  public String getServletInfo()
	  {
	    return "Short description";
	  }

}