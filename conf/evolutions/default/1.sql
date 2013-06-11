# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table USERS (
  id                        varchar(255) not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  e_mail                    varchar(255),
  created                   timestamp not null,
  modified                  timestamp not null,
  constraint pk_USERS primary key (id))
;

create sequence USERS_seq;




# --- !Downs

drop table if exists USERS cascade;

drop sequence if exists USERS_seq;

