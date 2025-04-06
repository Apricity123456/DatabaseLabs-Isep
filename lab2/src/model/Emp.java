package model;

import java.sql.Date;

public class Emp {
    private int empno;
    private String ename;
    private String job;
    private Emp mgr;
    private Date hiredate;
    private double sal;
    private Double comm;
    private int deptno;

    public Emp() {}

    public Emp(int empno, String ename, String job, Emp mgr, Date hiredate, double sal, Double comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }
    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + (mgr != null ? mgr.getEmpno() : "null") +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
    }
}
