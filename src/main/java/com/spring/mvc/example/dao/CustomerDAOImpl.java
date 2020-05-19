package com.spring.mvc.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.mvc.example.model.Customers;
import com.spring.mvc.example.utils.HibernateUtil;

@Repository
public class CustomerDAOImpl implements CustomerDAO 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String ADD_CUSTOMER = "insert into customers values (?,?,?)";
	private static final String UPDATE_CUSTOMER = "update customers set custname = ?,custadd = ? where custid = ?";
	private static final String DELETE_CUSTOMER = "delete from customers where custid = ?";
	private static final String VIEW_CUSTOMER = "select custid,custname,custadd from customers";
	
	public int addCustomer(Customers c) 
	{
		int i = jdbcTemplate.update(ADD_CUSTOMER, c.getCustId(),c.getCustName(),c.getCustAdd());
		return i;
	}
	
	
	public int deleteCustomer(Customers c) 
	{
		int i = jdbcTemplate.update(DELETE_CUSTOMER, c.getCustId());
		return i;
	}
	
	
	public int updateCustomer(Customers c) 
	{
		int i = jdbcTemplate.update(UPDATE_CUSTOMER, c.getCustName(),c.getCustAdd(),c.getCustId());
		return i;
	}
	
	public List<Customers> viewCustomer() 
	{
		List<Customers> custList =  jdbcTemplate.query(VIEW_CUSTOMER, new CustomerMapper());
		return custList;
	}
	
	/*private static SessionFactory factory = HibernateUtil.getSessionfactory();
	
	
	@Override
	public int addCustomer(Customers c) 
	{
		Session s= factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(c);
		tx.commit();
		s.close();
		return 1;
	}
	
	@Override
	public int updateCustomer(Customers c) 
	{
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("update Customers c set c.custName = ?,c.custAdd =? where c.custId=?");
		q.setParameter(0, c.getCustName());
		q.setParameter(1, c.getCustAdd());
		q.setParameter(2, c.getCustId());
		int i = q.executeUpdate();
		tx.commit();
		s.close();
		if(i == 1)
			return 1;
		else
			return 0;
	}
	
	@Override
	public int deleteCustomer(Customers c) 
	{
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("delete from Customers c where c.custId = ?");
		q.setParameter(0, c.getCustId());
		int i = q.executeUpdate();
		tx.commit();
		s.close();
		if(i == 1)
			return 1;
		else
			return 0;
	}
	
	@Override
	public List<Customers> viewCustomer() 
	{
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria crit = s.createCriteria(Customers.class);
		Projection p1 = Projections.property("custId");
		Projection p2 = Projections.property("custName");
		Projection p3 = Projections.property("custAdd");
		ProjectionList plist = Projections.projectionList();
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		crit.setProjection(plist);
		List<Customers> list = crit.list();
		
		Object o = (Object)list.get(0);  
		if(list !=null)
			return list;
		else
			return null;
	}*/
}

class CustomerMapper implements RowMapper<Customers>
{
	
	public Customers mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Customers cust = new Customers();
		cust.setCustId(rs.getString("custid"));
		cust.setCustName(rs.getString("custname"));
		cust.setCustAdd(rs.getString("custadd"));
		return cust;
	}
}
