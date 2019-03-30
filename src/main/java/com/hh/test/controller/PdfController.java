package com.hh.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hh.test.manager.MonitorManager;
import com.hh.test.pojo.PdfBean;
import com.hh.test.pojo.PdfBeans;
/**
 * pdf 预览功能
 * 
 * @param response
 */
@Controller
public class PdfController {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Resource
	private MonitorManager monitorManager;

	
	@RequestMapping("/displayPDF{id}.do")
	public void displayPDF1(@PathVariable(value = "id") String id, HttpServletResponse response) {
		try {
			log.info("id==" + id);
			String xmlPath = "X:\\duoke2\\pdf\\pdf.xml";
			PdfBeans pdfBeans = new PdfBeans();
			try {
				pdfBeans = JAXB.unmarshal(new FileInputStream(xmlPath), PdfBeans.class);
				log.info("解析mxl后的monitorConf==" + pdfBeans);
			} catch (FileNotFoundException e) {
				log.error(e.getMessage());
			}
			System.out.println(pdfBeans);
			Map<String, String> map = new HashMap<String, String>();
			List<PdfBean> pdfbeanss = new ArrayList<PdfBean>();
			pdfbeanss = pdfBeans.getPdfBeans();
			for (PdfBean pdfBean : pdfbeanss) {
				map.put(pdfBean.getKey() + "", pdfBean.getValue());
			}
			String value = map.get(id);
			File file = new File("X:\\duoke2\\pdf\\" + value + ".pdf");
			FileInputStream fileInputStream = new FileInputStream(file);
			response.setHeader("Content-Disposition", "attachment;fileName=test.pdf");
			response.setContentType("multipart/form-data");
			OutputStream outputStream = response.getOutputStream();
			IOUtils.write(IOUtils.toByteArray(fileInputStream), outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
