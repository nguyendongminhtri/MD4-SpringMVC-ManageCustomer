package controllers;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HelloController {
    private CustomerServiceImpl customerService = new CustomerServiceImpl();

    @RequestMapping(value = {"/", "/list"})
    public String hello(HttpServletRequest request) {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        return "/list";
    }

    @GetMapping("/create")
    public String update() {
        return "/create";
    }

    @RequestMapping("/createCustomer")
    public String create(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String address = request.getParameter("address");

//        int id = (int)Math.random()*10000;
        int id_ = Integer.parseInt(id);
        Customer customer = new Customer(id_, name, email, address);
        this.customerService.save(customer);
        request.setAttribute("message", "New customer was created");
        return "/create";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request) {
        System.out.println("detail");
        System.out.println("id" + id);
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        return "/detail";
    }

    @RequestMapping("/edit/{id}")
    public String getFormEdit(@PathVariable int id, HttpServletRequest request) {
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        System.out.println("name --> " + request.getParameter("name"));
        if (name == null || email == null || address == null) {
            request.setAttribute("message", "Update Information");
            return "/edit";
        } else {
            if (name.isEmpty() || email.isEmpty() || address.isEmpty()) {
                System.out.println("name es" + name);
                request.setAttribute("message", "A field is required! Please fill in the form!");
                return "/edit";
            }
        }
        Customer customer1 = new Customer(id, name, email, address);
        this.customerService.save(customer1);
        request.setAttribute("message", "Update Success!");

        return "/edit";
    }
@RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
//        Customer customer = customerService.findById(id);
        customerService.delete(id);
        return "/delete";
}

}
