package inClass.ArrayList;

import java.util.ArrayList;

public class TeacherController {
    private int[] id = {201, 202, 203, 204, 205};
    private String[] classes = {"Monkey", "Pig", "Horse", "Jerky", "Pirate"};
    private String[] name = {"Me", "You", "Ewe", "Eew", "Paul"};

    public TeacherController() {
    }

    public TeacherController(int[] id, String[] classes, String[] name) {
        this.id = id;
        this.classes = classes;
        this.name = name;
    }

    public ArrayList<TeacherEntity> pullTeacherInfo() {
        ArrayList<TeacherEntity> tlist = new ArrayList<>();
        for(int i = 0; i < id.length; i++) {
            TeacherEntity tobj = new TeacherEntity();
            tobj.setId(id[i]);
            tobj.setClasses(classes[i]);
            tobj.setName(name[i]);
            tlist.add(tobj);
        }
        return tlist;
    }

    public void displayTeacherInfo() {
        TeacherController con = new TeacherController();
        ArrayList<TeacherEntity> tData = con.pullTeacherInfo();

        for (TeacherEntity var: tData) {
            int id = var.getId();
            String classes = var.getClasses();
            String name = var.getName();
            System.out.println(id + " " + classes + " " + name);
        }
    }
}
