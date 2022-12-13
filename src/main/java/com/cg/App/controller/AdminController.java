package com.cg.App.controller;
 
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.App.exception.AdminNotFoundException;
import com.cg.App.model.Admin;
import com.cg.App.service.IAdminService;
 

@CrossOrigin(origins = "http://localhost:4200")
@RestController//combinatin of @Controller and @ResponseBody
//contoller return  view and restcontroller return response body
@RequestMapping(value="/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private IAdminService adminService;
    /*
     * http://localhost:8080/admin/add
     * This particular url is response for adding ward 
     * HTTP Method post is required
     */
    //ResponseEntity represent the whole http responce:status code,header,body=>this is generic Type

    @PostMapping(value = "/add")
    public ResponseEntity<Admin> addAdmin( @RequestBody Admin admin) throws AdminNotFoundException {
        try {
            logger.info("Trying to add Record  : " + admin);
            Admin addedAdmin = adminService.addAdmin(admin);
            return new ResponseEntity<>(admin, HttpStatus.CREATED);//201
        } catch (Exception e) {
            logger.error("Record NOT Added  : " +admin);
            return new ResponseEntity<>(admin, HttpStatus.EXPECTATION_FAILED);    //417
        }
    }
    /*
     * http://localhost:8080/admin/getAll
     * This particular url is response for getting all ward 
     * HTTP Method get is required
     */

        @GetMapping(path = "/getAll", produces = "application/json")
        public ResponseEntity<List<Admin>> getAllAdmin() throws AdminNotFoundException {
            logger.info("Trying to fetch Ward Report list ");
            try {
                List<Admin> admin = adminService.getAdminList();
                if (admin.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
                }
                return new ResponseEntity<>(admin, HttpStatus.OK);//200
            } catch (Exception e) {
                logger.error("Record NOT found : ");
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);//500,server encountered an unexpected condition
 
            }
        }
        /*
         * http://localhost:8080/admin/
         * This particular url is response for getting single ward
         * HTTP Method get is required
         */
        @GetMapping(path = "/singleRecord{adminId}", produces = "application/json")
        public ResponseEntity<Admin> getAdminById(@PathVariable Integer adminId) throws AdminNotFoundException {
            Optional<Admin> admin = null;
            logger.info("Trying to search Record with Id : " + adminId);
            try {
                admin= adminService.getAdminById(adminId);
 
                if (admin.isPresent()) {
                    return new ResponseEntity<>(admin.get(), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                logger.error("Record NOT Found with Id : " + adminId);
                return new ResponseEntity<Admin>(new Admin(), HttpStatus.EXPECTATION_FAILED);
                //Expectation given in te request 's expect header field could not met

            }
        }
 
        /*
         * http://localhost:8080/ward/getAll
         * This particular url is response for deleting ward
         * HTTP Method get is required
         */
        @DeleteMapping(path="/delete/{adminId}")
        public ResponseEntity<String> deleteAdmin(@PathVariable Integer adminId) throws AdminNotFoundException {

            try {
                adminService.deleteAdmin(adminId);
                Optional<Admin> delAdmin = adminService.getAdminById(adminId);
                logger.info("Record Deleted with Id : " +adminId);
                return new ResponseEntity<>("Record Deleted...with id : "+adminId,HttpStatus.OK);
            } catch (Exception e) {
                logger.error("Record NOT Deleted with Id : " + adminId);
                return new ResponseEntity<>("Record not found with id : "+adminId,HttpStatus.EXPECTATION_FAILED);
            }
        }
 
        
}