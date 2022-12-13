
package com.cg.App.service;
import java.util.Optional;

import com.cg.App.exception.MyAdminException;
import com.cg.App.model.Admin;

import java.util.List;


public interface IAdminService{
public Admin addAdmin(Admin admin) throws MyAdminException;

public List<Admin> getAdminList()throws MyAdminException;

public Optional<Admin> getAdminById(Integer adminId) throws MyAdminException;

public void deleteAdmin(Integer adminId)throws MyAdminException;
}

