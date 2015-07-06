Duplicate Emails 
Total Accepted: 26 Total Submissions: 83 My Submissions Question Solution 
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.

MySQL:1024ms
# Write your MySQL query statement below
select Email from (select Email, count(*) num from Person group by Email) foo where num >= 2; 
