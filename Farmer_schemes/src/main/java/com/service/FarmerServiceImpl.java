package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FarmerDao;
import com.model.Farmer;

@Service("farmerService")
public class FarmerServiceImpl implements FarmerService {
	@Autowired
	//@Qualifier("farmerDao")
	public FarmerDao farmerDao;
	public boolean register(Farmer farmer) {
			    return farmerDao.register(farmer);
	
	}

	public boolean validateFarmer(Farmer farmer) {
		boolean flag=farmerDao.validateFarmer(farmer);
		return flag;
	}

	/*public List<Farmer> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changepwd(String username, String opwd, String npwd) {
		// TODO Auto-generated method stub
		return false;
	}
*/
}
