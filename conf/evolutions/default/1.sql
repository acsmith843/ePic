# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ALBUM (
  id                        varchar(255) not null,
  title                     varchar(255),
  owner_id                  varchar(255),
  created                   timestamp not null,
  modified                  timestamp not null,
  constraint pk_ALBUM primary key (id))
;

create table THUMB (
  id                        varchar(255) not null,
  url                       varchar(255),
  created                   timestamp not null,
  modified                  timestamp not null,
  constraint pk_THUMB primary key (id))
;

create table USERS (
  id                        varchar(255) not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  e_mail                    varchar(255),
  facebook_id               varchar(255),
  created                   timestamp not null,
  modified                  timestamp not null,
  constraint pk_USERS primary key (id))
;


create table USERS_ALBUM (
  USERS_id                       varchar(255) not null,
  ALBUM_id                       varchar(255) not null,
  constraint pk_USERS_ALBUM primary key (USERS_id, ALBUM_id))
;
create sequence ALBUM_seq;

create sequence THUMB_seq;

create sequence USERS_seq;




alter table USERS_ALBUM add constraint fk_USERS_ALBUM_USERS_01 foreign key (USERS_id) references USERS (id);

alter table USERS_ALBUM add constraint fk_USERS_ALBUM_ALBUM_02 foreign key (ALBUM_id) references ALBUM (id);

# --- !Downs

drop table if exists ALBUM cascade;

drop table if exists THUMB cascade;

drop table if exists USERS cascade;

drop table if exists USERS_ALBUM cascade;

drop sequence if exists ALBUM_seq;

drop sequence if exists THUMB_seq;

drop sequence if exists USERS_seq;

