
DROP TABLE IF EXISTS play;
DROP TABLE IF EXISTS characters_in_play;


create table play
(
  id bigint not null auto_increment
    primary key,
  dialogue varchar(255) null,
  play_setting varchar(255) null,
  rating int not null,
  stage_direction varchar(255) null,
  theme varchar(255) null,
  title varchar(255) null,
  year int not null
)
;

create table characters_in_play
(
  id bigint not null auto_increment
    primary key,
  name varchar(255) null,
  play_id bigint null,
 # constraint FKh5q2gvdgtoymwv3os7dlk3usx
 # foreign key (play_id) references play (id)
  # PRIMARY KEY (`id`),
  KEY `characters_in_play's play` (`play_id`),
  CONSTRAINT `characters_in_play's play` FOREIGN KEY (`play_id`) REFERENCES `play` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
;

/**
DROP TABLE IF EXISTS characters_in_play;
DROP TABLE IF EXISTS play;

create table play
(
  id bigint not null auto_increment
    primary key,
  dialogue varchar(255) null,
  play_setting varchar(255) null,
  rating int not null,
  stage_direction varchar(255) null,
  theme varchar(255) null,
  title varchar(255) null,
  year int not null
)
;

create table characters_in_play
(
  id   BIGINT       NOT NULL AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(255) NULL,
  CONSTRAINT FK5gu02ck9ym1ay89xhhd1g9x67
  FOREIGN KEY (id) REFERENCES play (id)
);
**/

