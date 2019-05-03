package com.biz.bbs.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.mapper.BBsDao;
import com.biz.bbs.model.BBsVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BBsService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	ServletContext context;
	
	public List<BBsVO> selecAll() {
		
		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		List<BBsVO> bbsList = bDao.selectAll();
		return bbsList;
		
	}
	
	public List<BBsVO> pageList(long page_no) {
		
		long start = (page_no-1) * 10;
		long end = start + 10;
		
		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		List<BBsVO> bbsList = bDao.pageSelect(start, end);
		
		return bbsList;
		
	}

	public int insert(BBsVO bbsVO) {

		String s_content = 
				bbsVO.getB_content()
				.replaceAll("\r\n|\r|\n|\n\r", "<br />");

		bbsVO.setB_content(s_content);
		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		int ret = bDao.insert(bbsVO);
		
		return ret;
	}

	public BBsVO findById(long id) {

		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		BBsVO bbsVO = bDao.findById(id);
		return bbsVO;
	
	}

	public int delete(long id) {

		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		int ret = bDao.delete(id);
		return 0;
	}

	public int update(BBsVO bbsVO) {
		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		int ret = bDao.update(bbsVO);
		return ret;
	}
	
	
	public String upload(MultipartFile file) {
		String realPath=context.getRealPath("/files/");
		File dir=new File(realPath);
		
		
//		log.debug("1" + file.getOriginalFilename());
		if(!dir.exists())
			dir.mkdir();
		if(file.isEmpty()) return null;
		
		String realFile=file.getOriginalFilename();
		String saveFile=UUID.randomUUID().toString();
		saveFile+=realFile;
		
		File upFile=new File(realPath, saveFile);
		
		try {
			file.transferTo(upFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		return saveFile;
	}
}