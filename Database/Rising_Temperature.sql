Rising Temperature
Total Accepted: 2045 Total Submissions: 7221 My Submissions Question Solution
Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.

+---------+------------+------------------+
| Id(INT) | Date(DATE) | Temperature(INT) |
+---------+------------+------------------+
|       1 | 2015-01-01 |               10 |
|       2 | 2015-01-02 |               25 |
|       3 | 2015-01-03 |               20 |
|       4 | 2015-01-04 |               30 |
+---------+------------+------------------+
For example, return the following Ids for the above Weather table:
+----+
| Id |
+----+
|  2 |
|  4 |
+----+


MySQL:1399ms

# Write your MySQL query statement below
select w1.Id from Weather w1 join Weather w2 on
date_sub(w1.Date,interval 1 day) = w2.Date
and w1.Temperature > w2.Temperature;

MySQL:1615ms

# Write your MySQL query statement below
select Id from Weather w1 where Temperature > (select Temperature from Weather where Date = date_sub(w1.Date,interval 1 day));
