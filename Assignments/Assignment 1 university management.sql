CREATE TABLE student(
    stu_id INT PRIMARY KEY,
    stu_name VARCHAR(40) NOT NULL,
    stu_email VARCHAR(40) UNIQUE,
    stu_dob DATE,
    adv_id INT 
);

CREATE TABLE advisor(
    adv_id INT PRIMARY KEY,
    adv_name VARCHAR(40) NOT NULL,
    adv_email VARCHAR(40) UNIQUE,
    specialization VARCHAR(40)
);

ALTER TABLE student
ADD FOREIGN KEY (adv_id) 
REFERENCES advisor(adv_id)
ON DELETE SET NULL;

CREATE TABLE course(
    course_code INT PRIMARY KEY,
    title VARCHAR(40) NOT NULL,
    description TEXT,
    instructor VARCHAR(100)
);

CREATE TABLE studies(
    stu_id INT,
    course_code INT,
    PRIMARY KEY(stu_id,course_code) ,
    FOREIGN KEY (stu_id) REFERENCES student(stu_id) ON DELETE CASCADE,
    FOREIGN KEY (course_code) REFERENCES course(course_code) ON DELETE CASCADE
);
