CREATE TABLE IF NOT EXISTS `wk_db`.`request` (
`id` VARCHAR(255) NOT NULL,
  `author_id` VARCHAR(255) NULL DEFAULT NULL,
  `contragent_id` VARCHAR(255) NULL DEFAULT NULL,
  `nomenclature_id` VARCHAR(255) NULL DEFAULT NULL,
  `num` BIGINT(20) NULL DEFAULT NULL,
  `req_number` VARCHAR(255) NULL DEFAULT NULL,
  `index_of_number` VARCHAR(255) NULL DEFAULT NULL,
  `isChecked` BOOLEAN NULL DEFAULT FALSE,
  `req_time` DATETIME,
  `weight` FLOAT(2) default 0,
  PRIMARY KEY (`id`),
  INDEX `user_req` (`author_id` ASC),
  INDEX `contragent_req` (`contragent_id` ASC),
  INDEX `nomenclature_req` (`nomenclature_id` ASC),
  CONSTRAINT `contragent_req`
    FOREIGN KEY (`contragent_id`)
    REFERENCES `wk_db`.`contragent` (`id`),
  CONSTRAINT `nomenclature_req`
    FOREIGN KEY (`nomenclature_id`)
    REFERENCES `wk_db`.`nomenclature` (`id`),
  CONSTRAINT `user_req`
    FOREIGN KEY (`author_id`)
    REFERENCES `wk_db`.`usr` (`id`))
;
