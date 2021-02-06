package nudt.demo.test;

import net.sf.json.JSONObject;
import nudt.demo.configuration.BeanConfig;
import nudt.demo.entity.Student;
import nudt.demo.service.StudentESService;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.ArrayList;
import java.util.List;

public class StudentESServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(nudt.demo.configuration.BeanConfig.class);

    StudentESService studentESService = (StudentESService) context.getBean("studentESService");
    ElasticsearchTemplate elasticsearchTemplate = (ElasticsearchTemplate) context.getBean("elasticsearchTemplate");

    @Test
    public void createIndex() throws Exception {
        System.out.println("TESTING createIndex()...");
        elasticsearchTemplate.createIndex(Student.class);
        elasticsearchTemplate.putMapping(Student.class);
    }

    @Test
    public void saveStudent() {
        System.out.println("TESTING save()...");
        Student student = null;
        student = new Student("1","man", 35,"Wang1","Fei1","1985-03-04",
                "China","Hunan","Changsha",90,102,"这是我的格言");
        studentESService.save(student);
    }

    @Test
    public void saveAllStudent(){
        System.out.println("TESTING saveAll()...");
        List<Student> studentList= new ArrayList<Student>();
        studentList.add(new Student("1","man", 35,"Wang1","Fei1","1985-03-04",
                "China","Hunan","Changsha",90,102,"这是我的格言"));
        studentList.add(new Student("2","female", 35,"Wang2","Fei2","1985-04-04",
                "China","Hunan","Changsha",90,102,"这是我的格言"));
        studentList.add(new Student("3","female", 35,"Wang3","Fei3","1985-05-04",
                "China","Hunan","Changsha",90,102,"这是我的格言"));
        studentESService.saveAll(studentList);

    }
    @Test
    public void findStudentById() {
        System.out.println("TESTING findById()...");
        Student student = studentESService.findById("2");
        System.out.println("The doc found:");
        System.out.println(JSONObject.fromObject(student).toString());
    }

    @Test
    public void findStudentBySex() {
        System.out.println("TESTING findBySex()...");
        Iterable<Student> studentList = studentESService.findBySex("female");
        System.out.println("All docs found:");
        studentList.forEach(student -> System.out.println(JSONObject.fromObject(student).toString()));
    }

    @Test
    public void findAllStudent(){
        System.out.println("TESTING findAll()...");
        Iterable<Student> studentList = studentESService.findAll();
        System.out.println("All docs found:");
        studentList.forEach(student -> System.out.println(JSONObject.fromObject(student).toString()));
    }

    @Test
    public void deleteStudentById(){
        System.out.println("TESTING deleteById()...");
        this.saveAllStudent();
        studentESService.deleteById("2");
        Iterable<Student> studentList = studentESService.findAll();
        System.out.println("All docs left:");
        studentList.forEach(student -> System.out.println(JSONObject.fromObject(student).toString()));
    }

    @Test
    public void deleteAllStudent(){
        System.out.println("TESTING deleteAll()...");
        studentESService.deleteAll();
        Iterable<Student> studentList = studentESService.findAll();
        System.out.println("All docs left:");
        studentList.forEach(student -> System.out.println(JSONObject.fromObject(student).toString()));
    }

    @Test
    public void deteleStudetnByEntity(){
        System.out.println("TESTING deleteByEntity()...");
        this.saveAllStudent();
        Student student = studentESService.findById("2");
        studentESService.deleteByEntity(student);
        Iterable<Student> studentList = studentESService.findAll();
        System.out.println("All docs left:");
        studentList.forEach(student1 -> System.out.println(JSONObject.fromObject(student1).toString()));
    }

    @Test
    public void deteleAllStudetnByEntity(){
        System.out.println("TESTING deleteAllEntities()...");
        System.out.println("TESTING findBySex()...");
        Iterable<Student> studentList = studentESService.findBySex("female");
        studentESService.deleteAllEntities((List<Student>) studentList);
        Iterable<Student> studentList1 = studentESService.findAll();
        System.out.println("All docs left:");
        studentList1.forEach(student -> System.out.println(JSONObject.fromObject(student).toString()));
    }
}
