DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `email` varchar(255) UNIQUE,
  `password` varchar(255) NOT NULL
);

DROP TABLE IF EXISTS `otp`;
CREATE TABLE `otp` (
  `email` varchar(255) PRIMARY KEY,
  `otp` varchar(255) UNIQUE
);
