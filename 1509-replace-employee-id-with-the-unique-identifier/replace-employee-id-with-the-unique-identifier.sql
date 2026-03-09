
SELECT -- step1 select the column
EmployeeUNI.unique_id, Employees.name

FROM Employees LEFT JOIN EmployeeUNI -- step2 select the both Table

ON Employees.id = EmployeeUNI.id; -- step3 on which key