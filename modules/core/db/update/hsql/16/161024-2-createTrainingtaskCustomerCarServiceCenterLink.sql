alter table TRAININGTASK_CUSTOMER_CAR_SERVICE_CENTER_LINK add constraint FK_TCCSCL_CAR_SERVICE_CENTER foreign key (CAR_SERVICE_CENTER_ID) references TRAININGTASK_CAR_SERVICE_CENTER(ID);
alter table TRAININGTASK_CUSTOMER_CAR_SERVICE_CENTER_LINK add constraint FK_TCCSCL_CUSTOMER foreign key (CUSTOMER_ID) references TRAININGTASK_CUSTOMER(ID);