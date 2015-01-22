Department Highest Salary 
Total Accepted: 139 Total Submissions: 644 My Submissions Question Solution 
The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+

MySQL:

# Write your MySQL query statement below
select d.Name Department, f.Name, Salary from 
(select Name, e1.Salary, e1.DepartmentId from Employee e1 join 
(select max(Salary) Salary, DepartmentId from Employee group by DepartmentId) e2
on e1.Salary = e2.Salary and e1.DepartmentId = e2.DepartmentId) f,
Department d where f.DepartmentId = d.Id;
