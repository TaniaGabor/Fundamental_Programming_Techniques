import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Main {

    public static void main(String arg[]) throws FileNotFoundException {
       Task task=new Task();

        try {
            PrintWriter writer1 = new PrintWriter("task_1.txt", "UTF-8");
            task.monitoredDataList= task.task1();
            writer1.println("The list of objects of type MonitoredData is :"+"\n");
            writer1.println(task.monitoredDataList.toString());
            writer1.close();

            PrintWriter writer2= new PrintWriter("task_2.txt", "UTF-8");
            writer2.println( "The number of  distinct days that appear in the monitoring data   "+task.task2());
            writer2.close();

            PrintWriter writer3= new PrintWriter("task_3.txt", "UTF-8");
            writer3.println(" How many times each activity has appeared over the entire monitoring period"+"\n");
            writer3.println(task.task3());
            writer3.close();

            PrintWriter writer4= new PrintWriter("task_4.txt", "UTF-8");
            writer4.println("  How many times each activity has appeared for each day over the monitoring period.\n");
            writer4.println(task.task4().toString());
            writer4.close();

            PrintWriter writer5= new PrintWriter("task_5.txt", "UTF-8");
            writer5.println("Time in minutes for every activity:\n");
            writer5.println(task.task5().toString());
            writer5.close();

            PrintWriter writer6= new PrintWriter("task_6.txt", "UTF-8");
            writer6.println("The activities that have more than 90% of the monitoring records with duration less than 5 minutes\n");
            writer6.println(task.task6().toString());
            writer6.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



    }
}
