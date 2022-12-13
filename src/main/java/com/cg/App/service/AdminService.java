package com.cg.App.service;
import java.util.List;
import java.util.Optional;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.App.exception.MyAdminException;
import com.cg.App.model.Admin;
import com.cg.App.repository.AdminRepository;
 

 

@Service//it specify that class is service provider
public class AdminService implements IAdminService {
 
    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);


    @Autowired
    private AdminRepository adminRepository;
 
    //add ward data to service layer
    
	@Override
    public Admin addAdmin(Admin admin) throws MyAdminException {
        logger.info("Add admin in service layer "+ admin);
        return adminRepository.save(admin);
    }
 
    //get all ward data from service layer
    @Override
    public List<Admin> getAdminList() throws MyAdminException {
        logger.info("Fetch all admin in service layer ");
        return adminRepository.findAll();
    }
 
    //get single ward object from service layer
    @Override
    public Optional<Admin> getAdminById(Integer adminId) throws MyAdminException {
        logger.info("Trying to fetch admin in service layer ");
        return adminRepository.findById(adminId);
    }
 
    //delete ward object from service layer
    @Override
    public void deleteAdmin(Integer adminId) throws MyAdminException {
        logger.info("Delete admin in service layer ");
        adminRepository.deleteById(adminId);
    }
 
    

}
