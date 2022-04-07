package inClass.ArrayList;

import java.util.ArrayList;

public class StudentController {

    private int[] id = {101, 102, 103, 104, 105};
    private String[] program = {"Java", "Python", "C#", "JavaScript", "#inc Monkey"};
    private String[] name = {"Yo", "Mtv", "raps", "check", "it out"};

    public ArrayList<StudentEntity> pullStudentInfo() {
        ArrayList<StudentEntity> stlist = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            StudentEntity stobj = new StudentEntity();
            stobj.setRollNumber(id[i]);
            stobj.setProgram(program[i]);
            stobj.setStudName(name[i]);
            stlist.add(stobj);
        }
        return stlist;
    }

    public void displayStudentInfo() {
        StudentController con = new StudentController();
        ArrayList<StudentEntity> sData = con.pullStudentInfo();
        //System.out.println(sData);
        for (StudentEntity var: sData) {
            int roll = var.getRollNumber();
            String prog = var.getProgram();
            String name = var.getStudName();
            System.out.println(roll + " " + prog + " " + name);
        }
    }
}
