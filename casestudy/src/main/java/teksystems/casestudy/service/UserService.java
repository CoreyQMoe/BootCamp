package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.UserDAO;

@Service
public class UserService {
    //can be used for complex business logic
    //run it from the controller
    //Would use the DAO here instead of controller
    @Autowired
    private UserDAO userDAO;
}
