alter table TRAININGTASK_EMPLOYEE drop column SALARY cascade ;
alter table TRAININGTASK_EMPLOYEE add column SALARY decimal(19, 2) not null default 0 ;
