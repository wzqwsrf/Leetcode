Second Highest Salary
Total Accepted: 1034 Total Submissions: 4330 My Submissions Question Solution 
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the second highest salary is 200. If there is no second highest salary, then the query should return null.

MySQL:1244ms
# Write your MySQL query statement below
select e2.Salary SecondHighestSalary from Employee e1 
left join Employee e2 on e1.Salary > e2.Salary 
order by e2.Salary desc limit 1;

MySQL:1136ms
# Write your MySQL query statement below
select max(Salary) from Employee
where Salary not in
(select max(Salary) from Employee);

MySQL:881ms
# Write your MySQL query statement below
select max(Salary) from Employee
where Salary <>
(select max(Salary) from Employee);
