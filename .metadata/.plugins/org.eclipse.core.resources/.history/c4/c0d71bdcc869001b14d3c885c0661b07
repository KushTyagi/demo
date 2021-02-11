package com.example.demo.dao;


import java.lang.reflect.Method;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repo.GenericRepo;
import com.example.demo.util.FieldUtil;


@Transactional("userTransactionManager")
@Component
public class GenericDao<T> implements GenericRepo<T>{
    
	
	@PersistenceContext(unitName = "userEntityManagerFactory")
	EntityManager em;
    private Class<T> type;
	
	
      public T create(T t) {
    	  try {
    		  em.merge(t);
    	  }catch(Exception e) {
    		  e.printStackTrace();
    	  }  
    	  return t;
      }
      
      @Override
    public List<T> getUser() {
    	EntityManager em = null;
    	List<T> list = null;
    	try {
    		Query qury = em.createNativeQuery("select *from user");
    		list = qury.getResultList();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return list;
    }
      
      @Override
    public T update(T t, long id) {
    	Object obj = (Object)t;
    		try {
    			
    			Object singleResultObject = em.createQuery("from Userentity  u where u.id = :id").setParameter("id", id).getSingleResult();
    			String[] str = new String[] {"setName","setAddress"};
    			
    			for(int i=0; i<str.length; i++) {
    				Method method = singleResultObject.getClass().getDeclaredMethod(str[i], String.class); 
        				method.invoke(singleResultObject, FieldUtil.getFields(obj)); 
        				em.merge(singleResultObject);
    			}
    			
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	
    	return null;
    }
      
  
      
}
