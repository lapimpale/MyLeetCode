/* Write your T-SQL query statement below */
select Email
from Person
group by Email
having count(*) > 1