package it.reply.sales.ws.dao;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO {
	@Autowired
	protected SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
