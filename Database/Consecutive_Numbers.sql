Consecutive Numbers 
Total Accepted: 218 Total Submissions: 1191 My Submissions Question Solution 
Write a SQL query to find all numbers that appear at least three times consecutively.
+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

MySQL:1573ms
# Write your MySQL query statement below
select distinct Num ConsecutiveNums from (select Num, 
@count := if(@preNum = Num, @count + 1, 1) CNum,
@preNum := Num Pnum
from Logs s1, (select @count := 1) c, 
(select @preNum := NULL) p) foo where CNum >= 3;
