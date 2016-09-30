package com.hsp.baseService;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseServiceImpl implements BaseServiceInter {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Object findById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().load(clazz, id);
	}
	
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(obj);
	}

	
	public List getResult(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		//×¢Èë?
		if(parameters!=null&&parameters.length>0){
			
			for(int i=0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
		}
		return query.list();
	}

	public void save(Object obj) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(obj);
	}

	public void update(Object obj) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(obj);
	}
	
	public Object uniqueQuery(String hql,Object []parameters){
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null&&parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setParameter(i,parameters[i]);
			}
		}
		return query.uniqueResult();
	}
	
	public List executeQueryByPage(String hql, Object[] parameters,
			int PageSize, int PageNow) {
		// TODO Auto-generated method stub
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null&&parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setParameter(i, parameters[i]);
			}
		}
		return query.setFirstResult((PageNow-1)*PageSize).setMaxResults(PageSize).list();
	}
	
	public int QueryPagecount(String hql,Object []parameters,int PageSize)
	{
		Object obj=this.uniqueQuery(hql, parameters);
		int Pagerow=Integer.parseInt(obj.toString());
		return (Pagerow-1)/PageSize+1;
	}
	
	public int getnum(String hql,Object []parameters){
		Object obj=this.uniqueQuery(hql, parameters);
		return Integer.parseInt(obj.toString());
	}

}

