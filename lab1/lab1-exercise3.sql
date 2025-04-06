--3.1
-- CREATE TABLE project (
--     projno INT PRIMARY KEY,
--     pname VARCHAR(50),
--     startdate DATE,
--     budget DECIMAL(10, 2)
-- );

-- INSERT INTO project VALUES
-- (1, 'Blockchain Explorer', '2025-01-10', 20000),
-- (2, 'AI Chatbot', '2025-02-01', 30000),
-- (3, 'Mobile App', '2025-03-15', 15000),
-- (4, 'Data Analytics', '2025-04-01', 25000);
--3.2
-- CREATE TABLE project_emp (
--     empno INT,
--     projno INT,
--     PRIMARY KEY (empno, projno),
--     FOREIGN KEY (empno) REFERENCES emp(empno),
--     FOREIGN KEY (projno) REFERENCES project(projno)
-- );


-- INSERT INTO project_emp VALUES
-- (7369, 1), (7369, 2), (7369, 3), (7369, 4), 
-- (7499, 1), (7499, 2),
-- (7521, 2), (7521, 3),
-- (7566, 1), (7566, 4),
-- (7698, 3),
-- (7782, 1), (7782, 4),
-- (7839, 2), (7839, 3),
-- (7844, 1), (7844, 4),
-- (7900, 2), (7900, 4);
--3.3
-- SELECT empno
-- FROM project_emp
-- GROUP BY empno
-- HAVING COUNT(DISTINCT projno) = (SELECT COUNT(*) FROM project);
--3.4
-- CREATE VIEW sales_staff AS
-- SELECT empno, ename, deptno
-- FROM emp
-- WHERE deptno = 10
-- WITH CHECK OPTION;
--3.5
-- INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
-- VALUES (8001, 'OSTER', 'SALESMAN', 7839, CURRENT_DATE, 1600, NULL, 10);
--3.6
-- SELECT empno, COUNT(*) AS project_count
-- FROM project_emp
-- GROUP BY empno
-- HAVING COUNT(*) >= 2;

--3.7.1

-- SELECT empno
-- FROM project_emp
-- WHERE projno = 1
-- INTERSECT
-- SELECT empno
-- FROM project_emp
-- WHERE projno = 2;
--3.7.2
-- SELECT empno
-- FROM project_emp
-- WHERE projno = 3
-- EXCEPT
-- SELECT empno
-- FROM project_emp
-- WHERE projno = 4;
--3.8
-- SELECT projno, empno, sal
-- FROM (
--     SELECT pe.projno, e.empno, e.sal,
--            RANK() OVER (PARTITION BY pe.projno ORDER BY e.sal DESC) AS rk
--     FROM project_emp pe
--     JOIN emp e ON pe.empno = e.empno
-- ) sub
-- WHERE rk <= 3;
--3.9.1
-- SELECT empno,
--        ROUND(COUNT(*) * 100.0 / (SELECT COUNT(*) FROM project), 2) AS percent_projects
-- FROM project_emp
-- GROUP BY empno;

--3.9.2
-- SELECT empno,
--        ROUND(COUNT(*) * 100.0 / (SELECT COUNT(*) FROM project), 2) AS percent_projects,
--        CASE
--            WHEN COUNT(*) = 0 THEN 'Empty'
--            WHEN COUNT(*) * 100.0 / (SELECT COUNT(*) FROM project) <= 50 THEN 'Small'
--            WHEN COUNT(*) * 100.0 / (SELECT COUNT(*) FROM project) <= 80 THEN 'Medium'
--            WHEN COUNT(*) * 100.0 / (SELECT COUNT(*) FROM project) < 100 THEN 'Large'
--            ELSE 'Total'
--        END AS scope_size
-- FROM project_emp
-- GROUP BY empno;







