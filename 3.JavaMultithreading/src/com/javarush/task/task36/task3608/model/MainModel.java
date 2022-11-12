package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model{
        private ModelData modelData = new ModelData() ;
        private UserService userService = new UserServiceImpl();

        @Override
        public ModelData getModelData() {
            return this.modelData;
        }

        @Override
        public void loadUsers() {
            modelData.setDisplayDeletedUserList(false);
            modelData.setUsers(getAllUsers());
        }

        public void loadDeletedUsers() {
            modelData.setDisplayDeletedUserList(true);
            List<User> users = userService.getAllDeletedUsers();
            modelData.setUsers(users);
        }

        public void loadUserById(long userId) {
            modelData.setDisplayDeletedUserList(false);
            User user = userService.getUsersById(userId);
            modelData.setActiveUser(user);
        }

        public void deleteUserById(long id){
            modelData.setDisplayDeletedUserList(true);
            userService.deleteUser(id);
            modelData.setUsers(getAllUsers());
        }

        @Override
        public void changeUserData(String name, long id, int level) {
            User user = userService.createOrUpdateUser(name, id, level);
            modelData.setUsers(getAllUsers());
        }

        private List<User> getAllUsers(){
            modelData.setDisplayDeletedUserList(false);
            List<User> users = userService.getUsersBetweenLevels(1,100);
            return userService.filterOnlyActiveUsers(users);
        }
}