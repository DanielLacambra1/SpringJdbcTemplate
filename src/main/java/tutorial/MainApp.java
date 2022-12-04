package tutorial;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tutorial.StudentJDBCTemplate;

public class MainApp {
   public static void main(String[] args) {
	   
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      StudentJDBCTemplate studentJDBCTemplate = 
         (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
      
      System.out.println("Creación de registros" );
      studentJDBCTemplate.create("Pepe", 11);
      studentJDBCTemplate.create("María", 2);
      studentJDBCTemplate.create("Pepita", 15);

      System.out.println("Enumerar varios registros" );
      List<Student> students = studentJDBCTemplate.listStudents();
      
      for (Student record : students) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Nombre : " + record.getName() );
         System.out.println(", Edad : " + record.getAge());
      }

      System.out.println("Actualizar registro con ID = 2 " );
      studentJDBCTemplate.update(2, 20);

      System.out.println("Registro con ID = 2 " );
      Student student = studentJDBCTemplate.getStudent(2);
      System.out.print("ID : " + student.getId() );
      System.out.print(", Nombre : " + student.getName() );
      System.out.println(", Edad : " + student.getAge());
   }
   
}