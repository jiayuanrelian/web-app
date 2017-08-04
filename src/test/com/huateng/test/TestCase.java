package com.huateng.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huateng.model.Student;
import com.huateng.services.IStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class TestCase {
	
	@Autowired
	private IStudent iStudent;
	
	@Test
	public void testCase(){
		Student student = new Student();
		student.setName("Jim");
		student.setAge(10);
		student.setDescrition("介绍自己....啦lala");
		iStudent.saveStudnet(student );
	}
}
