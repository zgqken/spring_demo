CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL,
  `user_name` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_age` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;