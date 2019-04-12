CREATE TABLE `park_spot` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `lot_id` varchar(64) NOT NULL DEFAULT '',
  `name` varchar(30) NOT NULL DEFAULT '',
  `car` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `park_spot` (`id`, `lot_id`, `name`, `car`)
VALUES
	(1,'001','南区01','川A001'),
	(2,'001','南区02',''),
	(3,'001','南区03',''),
	(4,'001','东区05','');