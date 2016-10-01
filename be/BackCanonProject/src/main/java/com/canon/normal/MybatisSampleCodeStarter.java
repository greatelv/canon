package com.canon.normal;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisSampleCodeStarter {
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisSampleCodeStarter.class);
	private SqlSessionFactory sqlSessionFactory;
	
	public MybatisSampleCodeStarter() {
		logger.info("[Test Mybatis Progream has just been started]");
	}
	
	public void start() {
		String resource = "org/com/normal/config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				if(inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		makeSession();
	}

	private void makeSession() {
		SqlSession session = sqlSessionFactory.openSession();
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		SuperMan man = new SuperMan();
		man.setId(43);
		man.setName("Blue man");
		
		try {
			session.insert("org.com.normal.SuperMan.insertSuperMan", man);
			session.insert("org.com.normal.SuperMan.insertSuperMan", new Object[]{32, "RED MAN"});
			session.commit();
		} finally {
			session.close();
		}
		
		System.out.println("done");
	}

}
