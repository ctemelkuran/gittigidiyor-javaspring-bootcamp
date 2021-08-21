package dev.patika.patika0201;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


@RestController
@RequestMapping("/api")
public class HelloController {

    List<Student> students = new ArrayList<>();

    // End-point
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHello(@RequestParam String name){
        return "Hello "+name;
    } // query parametreleri için @Requestparam daha iyi


    //@ResponseStatus ile kodu değiştirilebiliriz, yoksa Spring otomatik yapıyor
    @GetMapping("/hello/{name}/{age}")
    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "Teapot error")
    public String sayMyName(@PathVariable String name, @PathVariable int age){
        return "Hello " + name + ", age: " + age;
    }

    @GetMapping("greeting/{id}")
    public ResponseEntity<String> greeting(@RequestHeader("Cookie") String cookie, @PathVariable int id){
        if (id >= 100){
            //return ResponseEntity.badRequest().body("ID cannot be greater then 99");
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Id must be smaller then 99");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("my-custom-header", "Test header");
        // return new ResponseEntity<>("ID: " + id, headers, HttpStatus.CREATED);

        return ResponseEntity.ok().headers(headers).body("ID: "+ id + ", cookie : " + cookie);

    }
    // requestparam ve pathvariable kullanılabilir, pathvariable daha iyi


    @GetMapping("/custom")
    public void customHeader(HttpServletRequest request, HttpServletResponse response) {
        String cookie = request.getHeader("Cookie");
        response.setHeader("Custom-header", "Çığır");
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){


        students.add(new Student(1,"Koray Güney", "Istanbul"));
        students.add(new Student(2,"Cigir", "Izmir"));

        return  ResponseEntity.ok().body(students);
    }

    // Post INSERT INTO gibi çalışır
    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> studentList){
        studentList.stream().forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                students.add(student);
            }
        });

        return ResponseEntity.ok().body(students);
    }

    // ..8080/sum?num1=10&num2=20
    // output --> 10 + 20 = 30
    @GetMapping("/calculate/{operation}")
    public String calculate(@PathVariable String operation, @RequestParam("num1") int num1, @RequestParam("num2") int num2){
        if(operation.equals("sum")){
            int sum = num1 + num2;
            return "output -->"  + num1 + " + " +num2 + " =" + sum;
        }
        else if(operation.equals("sub")){

            int sub = num1 - num2;
            return "output -->"  + num1 + " - " +num2 + " =" + sub;
        }
        else if(operation.equals("div")){

            int div = num1 / num2;
            return "output -->"  + num1 + " / " +num2 + " =" + div;
        }
        else if(operation.equals("mul")){

            int mul = num1 * num2;
            return "output -->"  + num1 + " * " +num2 + " =" + mul;
        }
        else
            return "Error";

    }


}
