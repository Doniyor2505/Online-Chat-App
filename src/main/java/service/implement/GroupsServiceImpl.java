package service.implement;

import main.MainApp;
import model.Groups;
import service.GroupService;

import java.util.List;

public class GroupsServiceImpl implements GroupService {
    @Override
    public boolean addGroup(Groups groups) {
        MainApp.groups.add(groups);
        return true;

    }

    @Override
    public boolean editGroups(Groups name) {


        return true;
    }

    @Override
    public boolean deleteGroups(Long id) {
        for (Groups group : MainApp.groups) {
            if(group.getId().equals(id)){
                MainApp.groups.remove(group);
                return true;
            }
        }
        return false;
    }

    @Override
    public Groups findByName(String name) {
        for (Groups group : MainApp.groups) {
            if(group.getName().equals(name)){
                return group;
            }
        }
        return null;
    }
}
