create table TRAININGTASK_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(100) not null,
    LAST_NAME varchar(100) not null,
    BIRTH_DATE date not null,
    EMAIL varchar(100) not null,
    SALARY integer not null,
    CENTER_ID varchar(36) not null,
    --
    primary key (ID)
);
