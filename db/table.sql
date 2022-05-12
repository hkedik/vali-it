-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-04-27 06:50:17.107

-- tables
-- Table: contact
CREATE TABLE contact (
                         id serial  NOT NULL,
                         first_name varchar(50)  NOT NULL,
                         last_name varchar(50)  NOT NULL,
                         email varchar(50)  NOT NULL,
                         tel varchar(50)  NOT NULL,
                         account_number varchar(255)  NOT NULL,
                         CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: expense
CREATE TABLE expense (
                         id serial  NOT NULL,
                         group_balance_id int  NOT NULL,
                         name varchar(255)  NOT NULL,
                         description varchar(255)  NOT NULL,
                         amount int  NOT NULL,
                         date_time timestamp  NOT NULL,
                         CONSTRAINT expence_pk PRIMARY KEY (id)
);

-- Table: expence_picture
CREATE TABLE expence_picture (
                                 id serial  NOT NULL,
                                 expence_id int  NOT NULL,
                                 receipt_picture_id int  NOT NULL,
                                 CONSTRAINT expence_picture_pk PRIMARY KEY (id)
);

-- Table: group_balance
CREATE TABLE group_balance (
                               id serial  NOT NULL,
                               balance decimal(8,2)  NOT NULL,
                               group_info_id int  NOT NULL,
                               CONSTRAINT group_balance_pk PRIMARY KEY (id)
);

-- Table: group_info
CREATE TABLE group_info (
                            id serial  NOT NULL,
                            group_name varchar(255)  NOT NULL,
                            description varchar(255)  NOT NULL,
                            date_time timestamp  NOT NULL,
                            CONSTRAINT group_info_ak_1 UNIQUE (group_name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                            CONSTRAINT group_info_pk PRIMARY KEY (id)
);

-- Table: picture
CREATE TABLE picture (
                         id serial  NOT NULL,
                         data bytea  NOT NULL,
                         CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: receipt_picture
CREATE TABLE receipt_picture (
                                 id serial  NOT NULL,
                                 data bytea  NOT NULL,
                                 CONSTRAINT receipt_picture_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(50)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: student
CREATE TABLE student (
                         id serial  NOT NULL,
                         group_info_id int  NOT NULL,
                         first_name varchar(50)  NOT NULL,
                         last_name varchar(50)  NOT NULL,
                         date_of_birth date  NOT NULL,
                         active boolean  NOT NULL DEFAULT false,
                         CONSTRAINT student_pk PRIMARY KEY (id)
);

-- Table: student_balance
CREATE TABLE student_balance (
                                 id serial  NOT NULL,
                                 group_balance_id int  NOT NULL,
                                 student_id int  NOT NULL,
                                 balance decimal(8,2)  NOT NULL,
                                 CONSTRAINT student_balance_pk PRIMARY KEY (id)
);

-- Table: student_balance_log
CREATE TABLE student_balance_log (
                                     id serial  NOT NULL,
                                     expence_id int  NULL,
                                     student_balance_id int  NOT NULL,
                                     date_time timestamp  NOT NULL,
                                     amount decimal(8,2)  NOT NULL,
                                     type char(1)  NOT NULL,
                                     CONSTRAINT student_balance_log_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        contact_id int  NOT NULL,
                        user_name varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_in_group
CREATE TABLE user_in_group (
                               id serial  NOT NULL,
                               group_info_id int  NOT NULL,
                               user_id int  NOT NULL,
                               date_activated date  NOT NULL,
                               is_active boolean  NOT NULL DEFAULT false,
                               is_moderator boolean  NOT NULL DEFAULT false,
                               CONSTRAINT user_in_group_pk PRIMARY KEY (id,date_activated)
);

-- Table: user_picture
CREATE TABLE user_picture (
                              id serial  NOT NULL,
                              picture_id int  NOT NULL,
                              user_id int  NOT NULL,
                              CONSTRAINT user_picture_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role (
                           id serial  NOT NULL,
                           role_id int  NOT NULL,
                           user_id int  NOT NULL,
                           CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- Table: user_student
CREATE TABLE user_student (
                              id serial  NOT NULL,
                              user_id int  NOT NULL,
                              student_id int  NOT NULL,
                              CONSTRAINT user_student_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: expence_group_balance (table: expense)
ALTER TABLE expense ADD CONSTRAINT expence_group_balance
    FOREIGN KEY (group_balance_id)
        REFERENCES group_balance (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: expence_picture_expence (table: expence_picture)
ALTER TABLE expence_picture ADD CONSTRAINT expence_picture_expence
    FOREIGN KEY (expence_id)
        REFERENCES expense (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: expence_picture_receipt_picture (table: expence_picture)
ALTER TABLE expence_picture ADD CONSTRAINT expence_picture_receipt_picture
    FOREIGN KEY (receipt_picture_id)
        REFERENCES receipt_picture (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: school_class_balance_group_info (table: group_balance)
ALTER TABLE group_balance ADD CONSTRAINT group_info_balance_group_info
    FOREIGN KEY (group_info_id)
        REFERENCES group_info (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: student_balance_group_balance (table: student_balance)
ALTER TABLE student_balance ADD CONSTRAINT student_balance_group_balance
    FOREIGN KEY (group_balance_id)
        REFERENCES group_balance (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: student_balance_log_expence (table: student_balance_log)
ALTER TABLE student_balance_log ADD CONSTRAINT student_balance_log_expence
    FOREIGN KEY (expence_id)
        REFERENCES expense (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: student_balance_log_student_balance (table: student_balance_log)
ALTER TABLE student_balance_log ADD CONSTRAINT student_balance_log_student_balance
    FOREIGN KEY (student_balance_id)
        REFERENCES student_balance (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: student_budget_student (table: student_balance)
ALTER TABLE student_balance ADD CONSTRAINT student_budget_student
    FOREIGN KEY (student_id)
        REFERENCES student (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: student_group_info (table: student)
ALTER TABLE student ADD CONSTRAINT student_group_info
    FOREIGN KEY (group_info_id)
        REFERENCES group_info (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: student_in_student_role_user (table: user_student)
ALTER TABLE user_student ADD CONSTRAINT student_in_student_role_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_contact (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_contact
    FOREIGN KEY (contact_id)
        REFERENCES contact (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_in_school_class_group_info (table: user_in_group)
ALTER TABLE user_in_group ADD CONSTRAINT user_in_group_group_info
    FOREIGN KEY (group_info_id)
        REFERENCES group_info (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_in_school_class_user (table: user_in_group)
ALTER TABLE user_in_group ADD CONSTRAINT user_in_group_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_picture_picture (table: user_picture)
ALTER TABLE user_picture ADD CONSTRAINT user_picture_picture
    FOREIGN KEY (picture_id)
        REFERENCES picture (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_picture_user (table: user_picture)
ALTER TABLE user_picture ADD CONSTRAINT user_picture_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_student_student (table: user_student)
ALTER TABLE user_student ADD CONSTRAINT user_student_student
    FOREIGN KEY (student_id)
        REFERENCES student (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

