alter table TRAININGTASK_CAR_SERVICE_CENTER add constraint FK_TRAININGTASK_CAR_SERVICE_CENTER_CITY foreign key (CITY_ID) references TRAININGTASK_CITY(ID);
create index IDX_TRAININGTASK_CAR_SERVICE_CENTER_CITY on TRAININGTASK_CAR_SERVICE_CENTER (CITY_ID);