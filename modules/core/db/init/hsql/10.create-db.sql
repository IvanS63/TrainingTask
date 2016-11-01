-- begin TRAININGTASK_CITY
create table TRAININGTASK_CITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100) not null,
    CODE integer not null,
    --
    primary key (ID)
)^
-- end TRAININGTASK_CITY
-- begin TRAININGTASK_EMPLOYEE
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
)^
-- end TRAININGTASK_EMPLOYEE
-- begin TRAININGTASK_CUSTOMER
create table TRAININGTASK_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    NAME varchar(100) not null,
    PHONE varchar(100) not null,
    EMAIL varchar(100) not null,
    --
    primary key (ID)
)^
update TRAININGTASK_CUSTOMER set DTYPE = 'trainingtask$Customer' where DTYPE is null ^
-- end TRAININGTASK_CUSTOMER
-- begin TRAININGTASK_REPAIR
create table TRAININGTASK_REPAIR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255),
    EMPLOYEE_ID varchar(36) not null,
    CENTER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end TRAININGTASK_REPAIR
-- begin TRAININGTASK_CAR_SERVICE_CENTER
create table TRAININGTASK_CAR_SERVICE_CENTER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100) not null,
    PHONE varchar(100) not null,
    ADDRESS varchar(100) not null,
    CITY_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end TRAININGTASK_CAR_SERVICE_CENTER
-- begin TRAININGTASK_CUSTOMER_CAR_SERVICE_CENTER_LINK
create table TRAININGTASK_CUSTOMER_CAR_SERVICE_CENTER_LINK (
    CAR_SERVICE_CENTER_ID varchar(36) not null,
    CUSTOMER_ID varchar(36) not null,
    primary key (CAR_SERVICE_CENTER_ID, CUSTOMER_ID)
)^
-- end TRAININGTASK_CUSTOMER_CAR_SERVICE_CENTER_LINK
-- begin TRAININGTASK_INDIVIDUAL
create table TRAININGTASK_INDIVIDUAL (
    ID varchar(36) not null,
    --
    PASSPORT_NO integer not null,
    --
    primary key (ID)
)^
-- end TRAININGTASK_INDIVIDUAL
-- begin TRAININGTASK_COMPANY
create table TRAININGTASK_COMPANY (
    ID varchar(36) not null,
    --
    INN integer not null,
    --
    primary key (ID)
)^
-- end TRAININGTASK_COMPANY
