CREATE TABLE `movies` (
  `id`       int(11)      NOT NULL AUTO_INCREMENT,
  `version`  int(11)      NOT NULL DEFAULT '0',
  `title`    varchar(255) NOT NULL,
  `watched`  tinyint(4)   DEFAULT '0',
  `rating`   varchar(5)   DEFAULT NULL,
  `released` date         DEFAULT NULL,
  `created`  timestamp    NULL DEFAULT CURRENT_TIMESTAMP,
  `updated`  timestamp    NULL DEFAULT CURRENT_TIMESTAMP,
  `length`   int(11)      DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
