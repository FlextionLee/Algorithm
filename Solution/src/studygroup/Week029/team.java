package studygroup.Week029;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import jdk.nashorn.internal.codegen.types.ArrayType;
import jdk.nashorn.internal.runtime.arrays.ArrayData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class team {
    public static class n{
        int num;
        public n(int num){
            this.num = num;
        }
    }
    public static void main(String[] args) {
        n[] arr = new n[5];
        for(int i=0; i<5; i++){
            arr[i] = new n(i);
        }

        n[] arr2 = arr.clone();

        arr[0].num = 10;

        for(int i=0; i<5; i++){
            System.out.print(arr2[i].num+" ");
        }

    }
}
