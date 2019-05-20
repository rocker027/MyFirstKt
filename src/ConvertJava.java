import java.util.ArrayList;

public class ConvertJava {
    public ArrayList<String> getArray(String... strings) {
        ArrayList arrayList = new ArrayList<String>();
        for (String str : strings) {
            arrayList.add(str);

        }
        return arrayList;
    }
}
