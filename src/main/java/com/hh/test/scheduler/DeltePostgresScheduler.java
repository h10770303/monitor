package com.hh.test.scheduler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.postgrestest.JDBCOperate;

@Service("deletePosgresScheduler")
public class DeltePostgresScheduler {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


	/**
	 * 定时删除postgres 数据
	 */
	public void delete() {
		JDBCOperate jdbcOperate=new JDBCOperate();
//		jdbcOperate.insert(stu);
		try {
			jdbcOperate.delete();
		} catch (RuntimeException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
	}
	
	

}
