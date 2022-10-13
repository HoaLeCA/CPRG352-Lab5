/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.User;

/**
 *
 * @author levan
 */
public class AccountServices {
    
    public User login(String username, String password){
        if((username.equals("adam")||username.equals("betty"))&& password.equals("password")){
            return new User(username,null);
        }
        return null;
    }
    
}
