CREATE TABLE user_tbl
(
    user_id       NUMBER PRIMARY KEY,
    user_username NVARCHAR2(50) UNIQUE,
    user_name     NVARCHAR2(50),
    user_family   NVARCHAR2(50),
    user_company  NVARCHAR2(50),
    user_location NVARCHAR2(100),
    user_email    NVARCHAR2(50),
    user_twitter  NVARCHAR2(50),
    user_deleted  CHAR(1) DEFAULT 'N'
);


CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE git_repo_tbl
(
    repo_id      NUMBER PRIMARY KEY,
    repo_uuid    NUMBER UNIQUE ,
    repo_name    NVARCHAR2(200),
    repo_about   NVARCHAR2(200),
    repo_owner   NVARCHAR2(50),
    repo_watch   NUMBER(4),
    repo_stars   NUMBER(4),
    repo_fork    NUMBER(4),
    repo_publish DATE,
    repo_deleted CHAR(1) DEFAULT 'N',
    CONSTRAINT fk_user FOREIGN KEY (repo_owner) REFERENCES user_tbl (user_username)
);


CREATE SEQUENCE repo_seq START WITH 1 INCREMENT BY 1;



