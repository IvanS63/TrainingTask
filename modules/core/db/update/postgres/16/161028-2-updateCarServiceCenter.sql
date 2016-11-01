-- update TRAININGTASK_CAR_SERVICE_CENTER set CREATED_BY_USER_ID = <default_value> where CREATED_BY_USER_ID is null ;
alter table TRAININGTASK_CAR_SERVICE_CENTER alter column CREATED_BY_USER_ID set not null ;
