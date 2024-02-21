-- -----------------------------------
-- root 계정만들기
-- -----------------------------------
-- 계정이 있다면 삭제
 drop user if exists 'phone'@'%';

-- 데이타 베이스가 있다면 삭제
 drop database if exists phone_db;

create user 'phone'@'%'identified by 'phone';

-- phone 권한부여
grant all privileges on phone_db.* to 'phone'@'%' ;

-- 즉시 변경 내용 반영
flush privileges;

-- 데이타베이스 생성
create database phone_db
    default character set utf8mb4
    collate utf8mb4_general_ci
    default encryption='n';
    
-- -----------------------------------    
-- phone 계정만들기
-- -----------------------------------

-- 테이블 만들기
create table person (
    person_id int auto_increment primary key,
    name varchar(30) not null,
    hp varchar(20),
    company varchar(20)
);

insert into person
values(null,'오지원','010-4765-0429','02-1111-1111');

select person_id,
       name,
       hp,
       company
from person;

delete from person
where person_id=10;

-- 수정
update person
set name = '이예슬',
	hp = '032-4518-9632',
	company = '02-566-5254'
where person_id = 6;

select *
from person;