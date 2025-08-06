
CREATE Database IF NOT EXISTS lost_and_found;
CREATE TABLE IF NOT EXISTS student (
    student_internal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    Sno BIGINT NOT NULL UNIQUE,
    Sname VARCHAR(50),
    Sage INT,
    Ssex VARCHAR(10),
    Grade VARCHAR(20),
    Classs VARCHAR(20),
    enrollment_time VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS app_user(
    user_internal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL UNIQUE,
    user_name VARCHAR(50) NOT NULL,
    user_password VARCHAR(50) NOT NULL,
    user_real_name VARCHAR(50) NOT NULL,
    user_phone VARCHAR(20) NOT NULL,
    user_college VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS item_admin(
    lost_admin_internal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    lost_admin_id BIGINT NOT NULL UNIQUE,
    lost_admin_name VARCHAR(50) NOT NULL,
    lost_admin_password VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS auditor(
    auditor_internal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    auditor_id BIGINT NOT NULL UNIQUE,
    auditor_name VARCHAR(50) NOT NULL,
    auditor_password VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS found_unfinished(
    found_unfinished_internal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    found_unfinished_id BIGINT NOT NULL UNIQUE,
    found_unfinished_name VARCHAR(50) NOT NULL,
    found_unfinished_category INT NOT NULL,
    found_unfinished_desc VARCHAR(1000),
    found_unfinished_location VARCHAR(50),
    found_color INT NOT NULL,
    found_unfinished_img_url VARCHAR(200),
    found_unfinished_found_time DATETIME,
    found_unfinished_public_time DATETIME
);
CREATE TABLE IF NOT EXISTS found_finished(
    found_finished_internal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    found_finished_id BIGINT NOT NULL UNIQUE,
    found_finished_name VARCHAR(50) NOT NULL,
    found_finished_category INT NOT NULL,
    found_finished_desc VARCHAR(1000),
    found_finished_location VARCHAR(50),
    item_color INT NOT NULL,
    found_finished_img_url VARCHAR(200),
    found_finished_found_time DATETIME,
    found_finished_public_time DATETIME,
    found_finished_finish_time DATETIME
);
CREATE TABLE IF NOT EXISTS lost_unfinished(
    lost_unfinished_internal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    lost_unfinished_id BIGINT NOT NULL UNIQUE,
    lost_unfinished_name VARCHAR(50) NOT NULL,
    lost_unfinished_category INT NOT NULL,
    lost_unfinished_desc VARCHAR(1000),
    lost_unfinished_location VARCHAR(50),
    lost_color INT NOT NULL,
    lost_unfinished_img_url VARCHAR(200),
    lost_unfinished_lost_time DATETIME,
    lost_unfinished_public_time DATETIME,
    lost_unfinished_comment JSON,
    lost_unfinished_auditor_id BIGINT NOT NULL REFERENCES auditor(auditor_id)
);
CREATE TABLE IF NOT EXISTS lost_finished(
    lost_finished_internal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    lost_finished_id BIGINT NOT NULL UNIQUE,
    lost_finished_name VARCHAR(50) NOT NULL,
    lost_finished_category INT NOT NULL,
    lost_finished_desc VARCHAR(1000),
    lost_finished_location VARCHAR(50),
    lost_color INT NOT NULL,
    lost_finished_img_url VARCHAR(200),
    lost_finished_lost_time DATETIME,
    lost_finished_public_time DATETIME,
    lost_finished_finish_time DATETIME,
    lost_finished_comment JSON,
    lost_unfinished_auditor_id BIGINT NOT NULL REFERENCES auditor(auditor_id)
);
CREATE TABLE IF NOT EXISTS lost_unchecked(
    lost_finished_internal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    lost_finished_id BIGINT NOT NULL UNIQUE,
    lost_finished_name VARCHAR(50) NOT NULL,
    lost_finished_category INT NOT NULL,
    lost_finished_desc VARCHAR(1000),
    lost_finished_location VARCHAR(50),
    lost_color INT NOT NULL,
    lost_finished_img_url VARCHAR(200),
    lost_finished_lost_time DATETIME,
    lost_finished_public_time DATETIME,
    lost_finished_finish_time DATETIME,
    lost_finished_comment JSON,
    lost_unfinished_auditor_id BIGINT NOT NULL REFERENCES auditor(auditor_id)
    );

CREATE TABLE IF NOT EXISTS colors (
    id INT PRIMARY KEY,
    name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS item_colors (
     item_id INT,
     color_id INT FOREIGN KEY REFERENCES colors(id),
     PRIMARY KEY(item_id, color_id)
);