package com.huateng.services;

import com.huateng.model.Student;

public interface IStudent {

	/**
	 * 保存
	 * @param student
	 */
	public void saveStudnet(Student student);

	/*
	 * 登录
	 */
	public Student login(String name, String password);
}
