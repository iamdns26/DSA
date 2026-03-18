SELECT m.name 
FROM Employee AS e
INNER JOIN Employee AS m
on e.managerId = m.id
GROUP BY e.managerId having count(e.id) >= 5;
