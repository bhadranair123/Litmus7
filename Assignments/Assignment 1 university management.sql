CREATE TABLE student(
    student_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    dob DATE,
    advisor_id INT 
    CONSTRAINT CHK_student CHECK(dob<'2021-12-31')
);

CREATE TABLE advisor(
    advisor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    specialization VARCHAR(60) DEFAULT "Computer science"
);

ALTER TABLE student
ADD FOREIGN KEY (advisor_id) 
REFERENCES advisor(advisor_id)
ON DELETE SET NULL;

CREATE TABLE course(
    course_code VARCHAR(40) PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description TEXT ,
    instructor VARCHAR(100)
);

CREATE TABLE enrollment(
    student_id VARCHAR(10),
    course_code VARCHAR(40),
    status VARCHAR(20) DEFAULT "ENROLLED",
    enrollment_date DATE,
    PRIMARY KEY(student_id,course_code) ,
    CONSTRAINT FK_studentenrollemt
    FOREIGN KEY (student_id) REFERENCES student(student_id) ON DELETE CASCADE,
    CONSTRAINT FK_courseenrollment
    FOREIGN KEY (course_code) REFERENCES course(course_code) ON DELETE CASCADE
);


drop table course;
