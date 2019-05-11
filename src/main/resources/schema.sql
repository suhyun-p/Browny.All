CREATE TABLE IF NOT EXISTS user (
  user_no BIGINT NOT NULL AUTO_INCREMENT,
  nickname VARCHAR(255) NOT NULL,
  sex CHAR(1) NOT NULL,
  instructor TINYINT NOT NULL DEFAULT 0,
  account VARCHAR(45) NULL,
  create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_id VARCHAR(255) NOT NULL DEFAULT 'ADMIN',
  update_date DATETIME NULL,
  update_id VARCHAR(255) NULL,
  PRIMARY KEY (user_no)
);

CREATE TABLE IF NOT EXISTS instructor_contact (
  seq BIGINT NOT NULL AUTO_INCREMENT,
  instructor_no BIGINT NOT NULL,
  type VARCHAR(2) NULL,
  contact VARCHAR(255) NULL,
  create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_id VARCHAR(25) NOT NULL DEFAULT 'ADMIN',
  update_date DATETIME NULL,
  update_id VARCHAR(255) NULL,
  PRIMARY KEY (seq)
);

CREATE TABLE IF NOT EXISTS instructor_career (
  seq BIGINT NOT NULL AUTO_INCREMENT,
  instructor_no BIGINT NOT NULL,
  career VARCHAR(255) NULL,
  create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_id VARCHAR(255) NOT NULL DEFAULT 'ADMIN',
  update_date DATETIME NULL,
  update_id VARCHAR(255) NULL,
  PRIMARY KEY (seq)
);

CREATE TABLE IF NOT EXISTS class (
    class_no BIGINT NOT NULL AUTO_INCREMENT,
    genre char(1) not null,
    region char(2) not null,
    type char(1) not null,
    only char(1),
    instructor_no_1 BIGINT NOT NULL,
    instructor_no_2 BIGINT,
    title varchar(255) NOT NULL,
    start_date DATETIME not null,
    end_date DATETIME not null,
    start_time varchar(255) not null,
    end_time varchar(255) not null,
    location varchar(255) not null,
    male_price int not null,
    female_price int not null,
    payment_type varchar(255),
    payment varchar(255),
    level int,
    recruitment_type char(1),
    recruitment_number int,
    contents varchar(255),
    class_image varchar(255),
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_id VARCHAR(255) NOT NULL DEFAULT 'ADMIN',
    update_date DATETIME NULL,
    update_id VARCHAR(255) NULL,
    primary key (class_no)
);

CREATE TABLE IF NOT EXISTS class_price_option (
    seq BIGINT NOT NULL AUTO_INCREMENT,
    class_no BIGINT NOT NULL,
    opt varchar(255) NOT NULL,
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_id VARCHAR(255) NOT NULL DEFAULT 'ADMIN',
    primary key (seq)
);

CREATE TABLE IF NOT EXISTS class_date_option (
    seq BIGINT NOT NULL AUTO_INCREMENT,
    class_no BIGINT NOT NULL,
    opt varchar(255) NOT NULL,
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_id VARCHAR(255) NOT NULL DEFAULT 'ADMIN',
    primary key (seq)
);

CREATE TABLE IF NOT EXISTS class_earlybird (
    seq BIGINT NOT NULL AUTO_INCREMENT,
    class_no BIGINT NOT NULL,
    deadline DATETIME NOT NULL,
    amount int NOT NULL,
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_id VARCHAR(255) NOT NULL DEFAULT 'ADMIN',
    primary key (seq)
);

CREATE TABLE IF NOT EXISTS class_contact (
    seq BIGINT NOT NULL AUTO_INCREMENT,
    class_no BIGINT NOT NULL,
    instructor_no BIGINT,
    type VARCHAR(255),
    contact VARCHAR(255),
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_id VARCHAR(255) NOT NULL DEFAULT 'ADMIN',
    primary key (seq)
);