package inClass.GenericPackage;

public class Runnable {
    public static void main(String[] args) {
        G_DataTypesClass obj1 = new G_DataTypesClass();
        obj1.setVarName("Teksystem");
        System.out.println(obj1.getVarName());
        obj1.setVarName(5);
        System.out.println(obj1.getVarName());
        obj1.setVarName(true);
        System.out.println(obj1.getVarName());
        // Bound type or Type safety or constructor boundtype or class level boundtype
        //Can only specify Wrapper data type (Reference Classes)
        G_DataTypesClass<String> obj2 = new G_DataTypesClass<>();
        obj2.setVarName("Quinn");

        G_DataTypesClass<Integer> obj3 = new G_DataTypesClass<>();
        obj3.setVarName(54);

        G_MultipleDataTypes obj4 = new G_MultipleDataTypes<>();
        obj4.setV1("#inc");
        obj4.setV2("monkey");
        G_MultipleDataTypes obj5 = new G_MultipleDataTypes<>(69, "Mother Fucker");

    }
}
