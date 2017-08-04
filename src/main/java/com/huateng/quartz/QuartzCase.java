package com.huateng.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huateng.model.Student;
import com.huateng.services.IStudent;

@Component(value="quartzCase")
public class QuartzCase {

	private static Logger logger = LoggerFactory.getLogger(QuartzCase.class);
	@Autowired
	private IStudent iStudent;
	
	public void doJob(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String data = dateFormat.format(new Date());
//		logger.info(data+"我开始工作啦==============");
	}
}
