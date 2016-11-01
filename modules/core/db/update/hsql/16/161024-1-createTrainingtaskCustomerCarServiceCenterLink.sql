create table TRAININGTASK_CUSTOMER_CAR_SERVICE_CENTER_LINK (
    CAR_SERVICE_CENTER_ID varchar(36) not null,
    CUSTOMER_ID varchar(36) not null,
    primary key (CAR_SERVICE_CENTER_ID, CUSTOMER_ID)
);
