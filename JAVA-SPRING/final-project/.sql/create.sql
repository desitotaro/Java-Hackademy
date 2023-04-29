create TABLE courses(
id BIGINT auto_increment primary key,
name varchar(100) not null,
description varchar(1000),
teacher_firstname varchar(100) not null,
teacher_lastname varchar(100) not null,
date DATE
);

create TABLE lessons(
id BIGINT auto_increment primary key,
description varchar(1000),
date DATE default (current_date),
course_id BIGINT,
foreign key (course_id) references courses(id)
);

create TABLE students(
id BIGINT auto_increment primary key,
firstname varchar(100) not null,
lastname varchar(100) not null,
email varchar(100) unique not null
);

create TABLE courses_students(
course_id BIGINT not NULL,
student_id BIGINT not NULL,
foreign key (course_id) references courses(id),
foreign key (student_id) references students(id)
);