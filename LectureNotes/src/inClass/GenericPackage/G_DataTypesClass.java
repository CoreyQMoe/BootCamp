package inClass.GenericPackage;

public class G_DataTypesClass<DataType> {
    private DataType varName;

    public G_DataTypesClass() {
    }

    public G_DataTypesClass(DataType varName) {
        this.varName = varName;
    }

    public DataType getVarName() {
        return varName;
    }

    public void setVarName(DataType varName) {
        this.varName = varName;
    }
}
