CREATE TABLE play
(
  id     BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  playCharacters VARCHAR(255),
  dialogue VARCHAR(255),
  playSetting VARCHAR(255),
  stageDirection VARCHAR(255),
  theme VARCHAR(255),
  rating INT(11)                NOT NULL,
  title  VARCHAR(255),
  year   INT(11)                NOT NULL
);
