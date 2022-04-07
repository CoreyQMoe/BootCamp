package inClass.GenericPackage;

//datatype1 and datatype2 are just variable names and can be anything
public class G_MultipleDataTypes <datatype1, datatype2> {
    private datatype1 v1;
    private datatype2 v2;

    public G_MultipleDataTypes() {
    }

    public G_MultipleDataTypes(datatype1 v1, datatype2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public datatype1 getV1() {
        return v1;
    }

    public void setV1(datatype1 v1) {
        this.v1 = v1;
    }

    public datatype2 getV2() {
        return v2;
    }

    public void setV2(datatype2 v2) {
        this.v2 = v2;
    }
}
