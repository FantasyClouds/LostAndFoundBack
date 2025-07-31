CREATE TABLE IF NOT EXISTS student (
    student_internal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    Sno BIGINT,
    Sname VARCHAR(50),
    Sage INT,
    Ssex VARCHAR(10),
    Grade VARCHAR(20),
    Classs VARCHAR(20),
    enrollment_time VARCHAR(50)
);