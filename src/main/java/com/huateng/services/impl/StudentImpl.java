package com.huateng.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.dao.mapper.StudentMapper;
import com.huateng.model.Student;
import com.huateng.services.IStudent;
import com.huateng.utils.MD5Utils;

@Component
public class StudentImpl implements IStudent{

	@Autowired
	private StudentMapper studentMapper;
	
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void saveStudnet(Student student) {
		
		int num = studentMapper.insert(student);
		System.out.println(num);
	}

	@Override
	public Student login(String name, String password) {
		String md5Password = MD5Utils.getEncryption(password);
		Student student = studentMapper.isExsit(name,md5Password);
		return student;
	}

}
