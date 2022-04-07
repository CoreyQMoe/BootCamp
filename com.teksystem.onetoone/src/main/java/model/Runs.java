package model;

import controller.AddressController;
import controller.PersonController;

public class Runs {
    public static void main(String[] args) {
        AddressController ac = new AddressController();
        PersonController pc = new PersonController();
//        ac.createTables();
//        ac.insertData();
//        pc.insertData();
        pc.getPersonInfo();
    }

}
