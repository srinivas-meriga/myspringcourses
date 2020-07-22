package com.stanley.rest.ws.restfuldemo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDAOService {
    
    private static List<User> users = new ArrayList<User>();
    
    static {
        users.add(new User(1, "Joy", new Date()));
        users.add(new User(2, "Paul", new Date()));
        users.add(new User(3, "Sanju", new Date()));
    }

    private static int count = 3;
    
    public List<User> findAll(){
        return users;
    }
    
    public User saveUser(User user) {
        if(null == user.getId() ) {
            user.setId(++count);
        }
        users.add(user);
        return user;
    }
    
    public User findOne(int id) {
        for(User user: users) {
            if(id == user.getId()) {
                return user;
            }
        }
        return null;
    }
    
    public User deleteById(int id) {
     Iterator<User> itr = users.iterator();
     while(itr.hasNext()) {
        User user= itr.next();
            if(id == user.getId()) {
                itr.remove();
                return user;
            }
        }
        return null;
    }
}
