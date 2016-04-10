
USE db_mygym;

CREATE TABLE `training` (
  `training_id` bigint(20) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  `training_date` datetime DEFAULT NULL,
  `training_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`training_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `training_workout` (
  `training_id` bigint(20) NOT NULL,
  `workout_id` bigint(20) NOT NULL,
  PRIMARY KEY (`training_id`,`workout_id`),
  KEY `FK_training_workout_workout_id` (`workout_id`),
  CONSTRAINT `FK_training_workout_training_id` FOREIGN KEY (`training_id`) REFERENCES `training` (`training_id`),
  CONSTRAINT `FK_training_workout_workout_id` FOREIGN KEY (`workout_id`) REFERENCES `workout` (`workout_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `workout` (
  `workout_id` bigint(20) NOT NULL,
  `value` double DEFAULT NULL,
  `workout_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`workout_id`),
  KEY `FK_workout_workout_type_id` (`workout_type_id`),
  CONSTRAINT `FK_workout_workout_type_id` FOREIGN KEY (`workout_type_id`) REFERENCES `workout_type` (`workout_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `workout_type` (
  `workout_type_id` bigint(20) NOT NULL,
  `icon_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`workout_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
