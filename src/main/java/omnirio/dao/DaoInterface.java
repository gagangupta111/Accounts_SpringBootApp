package omnirio.dao;

import com.omnirio.model.Account;
import com.omnirio.model.CustomResponse;
import com.omnirio.model.User;

public interface DaoInterface {

    CustomResponse getAllUsers();
    CustomResponse getUser(String userID);
    CustomResponse createUser(User user);

    CustomResponse getAllAccounts();
    CustomResponse getAccount(String accountID);
    CustomResponse createAccount(Account account);

    CustomResponse userUpdateUser(String userID, User user);
    CustomResponse userDeleteUser(String userID);

    CustomResponse userUpdateAccount(String accountID, Account account);
    CustomResponse userDeleteAccount(String accountID);

    CustomResponse getUserAllAccounts(String userID);

}
