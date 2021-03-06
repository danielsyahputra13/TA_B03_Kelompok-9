package apap.tugas.siretail.service;

import apap.tugas.siretail.model.UserModel;
import apap.tugas.siretail.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        System.out.println(pass + " " + user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public UserModel changeUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public void deleteUser(UserModel user) {
        userDb.delete(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordHash = passwordEncoder.encode(password);
        return passwordHash;
    }


    @Override
    public UserModel findUserbyUsername(String username){
        return userDb.findByUsername(username);
    }

    @Override
    public boolean userExists(String email, String username) {
        UserModel user = userDb.findByEmailOrUsername(email, username);
        if (user != null) return true;
        return false;
    }

    @Override
    public List<UserModel> getListUser() {
        return userDb.findAll();
    }
}
