use bollywoodtest;

TRUNCATE TABLE movies;

INSERT INTO movies (title,rating,released,length,watched)
  values('The Avengers', 'PG', '2015-03-15 00:00:00.000', 165, 1);
