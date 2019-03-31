public class Student {
    private String name;
    private int score;

    public  Student(String studentName, int studentScore){
        name = studentName;
        score = studentScore;
    }

    @Override
    public String toString() {
        return String.format("Sturent name is %s score is %s",name,score);
    }

    public static void main(String[] args ) throws IllegalAccessException {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("小米",33));
        arr.addLast(new Student("小红",66));
        arr.addLast(new Student("小马",99));
        System.out.println(arr);
    }
}
