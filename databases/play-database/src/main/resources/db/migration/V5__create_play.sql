DROP TABLE IF EXISTS `characters`;
DROP TABLE IF EXISTS `play`;
DROP TABLE IF EXISTS `characters_in_play`;

CREATE TABLE characters_in_play (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50),
 title  VARCHAR(255),
 PRIMARY KEY (`id`,`name`)
);

CREATE TABLE play
(
  id     BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  dialogue VARCHAR(255),
  play_setting VARCHAR(255),
  stage_direction VARCHAR(255),
  theme VARCHAR(255),
  rating INT(11)                NOT NULL,
  title  VARCHAR(255),
  year   INT(11)                NOT NULL
);
