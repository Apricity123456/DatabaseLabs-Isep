package testjpa;

//import jakarta.persistence.*;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Emp {
    @Id
    private Long empno;

    private String ename;
    private String job;
    private Long mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;

    public Long getEmpno() { return empno; }
    public void setEmpno(Long empno) { this.empno = empno; }

    public String getEname() { return ename; }
    public void setEname(String ename) { this.ename = ename; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }

    public Long getMgr() { return mgr; }
    public void setMgr(Long mgr) { this.mgr = mgr; }

    public Date getHiredate() { return hiredate; }
    public void setHiredate(Date hiredate) { this.hiredate = hiredate; }

    public Double getSal() { return sal; }
    public void setSal(Double sal) { this.sal = sal; }

    public Double getComm() { return comm; }
    public void setComm(Double comm) { this.comm = comm; }

    public Integer getDeptno() { return deptno; }
    public void setDeptno(Integer deptno) { this.deptno = deptno; }
}
