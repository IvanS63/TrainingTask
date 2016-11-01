create table TRAININGTASK_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(100),
    --
    NAME varchar(100) not null,
    PHONE varchar(100) not null,
    EMAIL varchar(100) not null,
    --
    -- from trainingtask$Company
    INN integer not null,
    --
    -- from trainingtask$Individual
    PASSPORT_NO integer not null,
    --
    primary key (ID)
);
update TRAININGTASK_CUSTOMER set DTYPE = 'trainingtask$Customer' where DTYPE is null ;
