DROP TABLE IF EXISTS `play`;

CREATE TABLE play
(
  id     BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  play_characters VARCHAR(255),
  dialogue VARCHAR(255),
  play_setting VARCHAR(255),
  stage_direction VARCHAR(255),
  theme VARCHAR(255),
  rating INT(11)                NOT NULL,
  title  VARCHAR(255),
  year   INT(11)                NOT NULL
);
