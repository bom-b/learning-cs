package process;

public class Step1 {
    public static void main(String[] args) {
        long pid = ProcessHandle.current().pid();
        System.out.println("hello os");
        System.out.println("Process ID: " + pid);
    }
}
