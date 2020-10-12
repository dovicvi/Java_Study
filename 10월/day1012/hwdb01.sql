use ssafyweb;

-- 1) 입사일이 2014 년도인 사람의 모든 정보를 검색하세요
select *
from emp
where hiredate between '2014/1/1' and '2014/12/31';
-- 2) 이름 중 S 자가 들어가 있는 사람만 모든 정보를 검색하세요
select *
from emp
where ename like '%S%';
-- 3) 커미션이 NULL 인 사람의 정보를 검색하세요
select *
from emp
where comm is null;
-- 4) 30번 부서의 연봉을 계산하여 이름 , 부서번호 , 급여 , 연봉(12개월 월급여 연말보너스)을 검색하세요.
--  단 , 연말에 급여의 150% 를 보너스로 지급한다
select ename,deptno,sal, round(sal*13.5) as yearsal
from emp
where deptno=30;
-- 5)급여가 $2,000 이상인 모든 사람은 급여의 15% 를 경조비로 내기로하였다.
--  이름 , 급여 , 경조비를 검색하세요
select ename,sal, (sal*0.15) as '경조비'
from emp
where sal>=2000;