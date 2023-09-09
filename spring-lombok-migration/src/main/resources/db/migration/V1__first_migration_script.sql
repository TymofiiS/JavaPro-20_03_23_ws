CREATE TABLE IF NOT EXISTS `orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `products` (
  ` id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `cost` FLOAT NOT NULL,
  PRIMARY KEY (` id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `order_has_products` (
  `orders_id` INT NOT NULL,
  `products_ id` INT NOT NULL,
  PRIMARY KEY (`orders_id`, `products_ id`),
  INDEX `fk_orders_has_products_products1_idx` (`products_ id` ASC) VISIBLE,
  INDEX `fk_orders_has_products_orders_idx` (`orders_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_has_products_orders`
    FOREIGN KEY (`orders_id`)
    REFERENCES `orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_products_products1`
    FOREIGN KEY (`products_ id`)
    REFERENCES `products` (` id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
