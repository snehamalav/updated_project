package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.model.Farmer;
@Repository("farmerDao")
public class FarmerDaoImpl implements FarmerDao {

	public boolean register(Farmer farmer) {
		    boolean flag=false;
		    try {
		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin( ); 
			em.persist(farmer);
			em.getTransaction().commit();
			em.close();
			System.out.println("end");
			flag=true;
		    }
		    catch(Exception e) { 
		    	System.out.println("Error:"+e);  
		    	}
		    return flag;
	}

	public boolean validateFarmer(Farmer farmer)
	{

		boolean result=false;
		try{
		
		//code for jpa
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
		EntityManager em=emf.createEntityManager();
		Farmer u=em.find(Farmer.class,farmer.getF_email());
		System.out.println(result+"1");
	
		
		if(u!=null)
		{
			if(u.getPassword().equals(farmer.getPassword()))
				{
				result=true;
			    System.out.println(result+"2");
				}
		}
		System.out.println(result+"3");
		em.close();
	}
		catch(Exception e)
		{
			System.out.println("error:"+e);
		}
		System.out.println(result+"4");
		return result;
		
	}

	/*public List<Farmer> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changepwd(String username, String opwd, String npwd) {
		// TODO Auto-generated method stub
		return false;
	}*/

}
