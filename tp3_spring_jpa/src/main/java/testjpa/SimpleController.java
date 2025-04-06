package testjpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;


@RestController
public class SimpleController {

    @Autowired
    private EmpRepository empRepository;

    @GetMapping("/emps")
    public List<Emp> getAllEmps() {
        return empRepository.findAll();
    }

    @PostMapping("/emps")
    public Emp createEmp(@RequestBody Emp emp) {
        return empRepository.save(emp);
    }
    @PutMapping("/emps/{id}")
    public Emp updateEmp(@PathVariable("id") Long id, @RequestBody Emp newEmp) {
        return empRepository.findById(id)
                .map(emp -> {
                    emp.setEname(newEmp.getEname());
                    emp.setJob(newEmp.getJob());
                    emp.setMgr(newEmp.getMgr());
                    emp.setHiredate(newEmp.getHiredate());
                    emp.setSal(newEmp.getSal());
                    emp.setComm(newEmp.getComm());
                    emp.setDeptno(newEmp.getDeptno());
                    return empRepository.save(emp);
                })
                .orElse(null);
    }
    @DeleteMapping("/emps/{id}")
    public void deleteEmp(@PathVariable("id") Long id) {
        empRepository.deleteById(id);
    }
}

