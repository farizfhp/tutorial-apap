package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);

    UserModel findUserbyUsername(String username);

    boolean isMatch(String newPassword, String oldPassword);

    void setPassword(UserModel myUser, String newPassword);

    List<UserModel> getListUser();

    void deleteUser(UserModel user);

}
