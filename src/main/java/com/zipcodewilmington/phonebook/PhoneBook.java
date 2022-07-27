package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        //this(null);
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNum = new ArrayList<>();
        phoneNum.add(phoneNumber);
        phonebook.put(name, phoneNum);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> phoneNum = new ArrayList<>(Arrays.asList(phoneNumbers));
        phonebook.put(name, phoneNum);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>>entry : phonebook.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (Objects.equals(entry.getValue().get(i), phoneNumber)){
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        Set<String> keysSet = phonebook.keySet();
        List<String> keysList = new ArrayList<>(keysSet);
        return keysList;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
