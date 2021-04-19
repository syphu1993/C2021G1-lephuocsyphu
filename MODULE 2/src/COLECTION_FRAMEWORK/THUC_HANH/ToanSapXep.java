package COLECTION_FRAMEWORK.THUC_HANH;

import java.util.Comparator;

public class ToanSapXep implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getYear() > o2.getYear()){
            return 1;
        }else if(o1.getYear() == o2.getYear()){
            return 0;
        }else{
            return -1;
        }
    }
}
