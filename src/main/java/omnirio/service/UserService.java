package omnirio.service;

import com.omnirio.dao.DaoInterface;
import com.omnirio.model.Account;
import com.omnirio.model.CustomResponse;
import com.omnirio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    @Qualifier("InMemory")
    private DaoInterface dao;

    public CustomResponse getAllUsers(){

        return dao.getAllUsers();

    }

    CustomResponse getUser(String userID){

        return dao.getUser(userID);

    }

    CustomResponse createUser(User user){

        return dao.createUser(user);

    }

    CustomResponse getAllAccounts(){

        return dao.getAllAccounts();
    }

    CustomResponse getAccount(String accountID){

        return dao.getAccount(accountID);
    }

    CustomResponse createAccount(Account account){

        return dao.createAccount(account);
    }

    CustomResponse userUpdateUser(String userID, User user){

        return dao.userUpdateUser(userID, user);
    }

    CustomResponse userDeleteUser(String userID){

        return dao.userDeleteUser(userID);
    }

    CustomResponse userUpdateAccount(String accountID, Account account){

        return dao.userUpdateAccount(accountID, account);
    }


    CustomResponse userDeleteAccount(String accountID){

        return dao.userDeleteAccount(accountID);
    }

    CustomResponse getUserAllAccounts(String userID){

        return dao.getUserAllAccounts(userID);
    }



}
