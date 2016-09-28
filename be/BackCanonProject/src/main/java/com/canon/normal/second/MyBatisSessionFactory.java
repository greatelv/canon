package com.canon.normal.second;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.canon.normal.util.ResourceBundleUtil;

public class MyBatisSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(ResourceBundleUtil.getInstance().get("second.config.file"));
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e.getCause());
			}
		}
		return sqlSessionFactory;
	}

	private MyBatisSessionFactory() {
	}
	
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}