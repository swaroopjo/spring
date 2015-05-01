 DROP SCHEMA `loan_app`;
CREATE SCHEMA `loan_app`;

USE loan_app;

drop procedure if exists createUser;
delimiter $$
create procedure createUser(username varchar(50), pw varchar(50))
begin
IF (SELECT EXISTS(SELECT 1 FROM `mysql`.`user` WHERE `user` = username)) = 0 THEN
    begin
    set @sql = CONCAT('CREATE USER ', username, '@\'localhost\' IDENTIFIED BY \'', pw, '\'');
    prepare stmt from @sql;
    execute stmt;
    deallocate prepare stmt;
    end;
END IF;
end $$
delimiter ;

call createUser('loan_app_usr', 'loan_app_1!');

GRANT ALL PRIVILEGES 
ON spring_social_tutorial.* 
TO 'loan_app_usr'@'localhost'
IDENTIFIED BY 'social_1!' 
WITH GRANT OPTION;

CREATE TABLE IF NOT EXISTS `loan_app`.`loan_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  CONSTRAINT pk_id PRIMARY KEY(id),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;


CREATE TABLE IF NOT EXISTS `loan_app`.`loan_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  CONSTRAINT pk_role_id PRIMARY KEY(id),
  CONSTRAINT fk_role_user FOREIGN KEY(`user_id`) REFERENCES `loan_user`(`id`)
  ) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 
;

INSERT INTO `loan_user` (`id`, `firstName`, `lastName`, `password`, `username`) VALUES
(1, 'test', 'usr', '098f6bcd4621d373cade4e832627b4f6', 'john'); -- password: "test". This value stored in the table is md5 converted. since the app is configured to use MD5

INSERT INTO `loan_user_role` (`id`, `role`, `user_id`) VALUES
(1, 1, 1);


COMMIT;
