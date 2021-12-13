package service;

import model.Groups;

import java.util.List;

public interface GroupService {

    boolean addGroup(Groups groups);

    boolean editGroups(Groups groups);

    boolean deleteGroups(Long id);


    Groups findByName(String name);


}
