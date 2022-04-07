package inClass.ArrayList;

public class TeacherEntity {
    private int id;
    private String classes;
    private String name;

    public TeacherEntity() {
    }

    public TeacherEntity(int id, String classes, String name) {
        this.id = id;
        this.classes = classes;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
