# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ALBUMS (
  id                        varchar(255) not null,
  title                     varchar(255),
  owner_id                  varchar(255),
  created                   timestamp not null,
  modified                  timestamp not null,
  constraint pk_ALBUMS primary key (id))
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


create table USERS_ALBUMS (
  USERS_id                       varchar(255) not null,
  ALBUMS_id                      varchar(255) not null,
  constraint pk_USERS_ALBUMS primary key (USERS_id, ALBUMS_id))
;
create sequence ALBUMS_seq;

create sequence THUMB_seq;

create sequence USERS_seq;




alter table USERS_ALBUMS add constraint fk_USERS_ALBUMS_USERS_01 foreign key (USERS_id) references USERS (id);

alter table USERS_ALBUMS add constraint fk_USERS_ALBUMS_ALBUMS_02 foreign key (ALBUMS_id) references ALBUMS (id);

# --- !Downs

drop table if exists ALBUMS cascade;

drop table if exists THUMB cascade;

drop table if exists USERS cascade;

drop table if exists USERS_ALBUMS cascade;

drop sequence if exists ALBUMS_seq;

drop sequence if exists THUMB_seq;

drop sequence if exists USERS_seq;

