use ssafydb;

select  employee_id, first_name, job_id, e.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id
where job_id = (select job_id from employees where first_name = 'Diana');

select  e.employee_id, e.first_name, j.job_title, d.department_name
from (select manager_id
		from employees
        where first_name='Bruce') t, employees e join jobs j
on e.job_id = j.job_id
	join departments d
	on e.department_id = d.department_id
where t.manager_id = e.manager_id;

select employee_id, first_name, hire_date
from employees e
order by hire_date
limit 5,5;