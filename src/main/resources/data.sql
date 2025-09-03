-- Please run this query to have the necessary table in your h2 db thanks
CREATE TABLE IF NOT EXISTS NOTE
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    title             VARCHAR(255),
    content           VARCHAR(255),
    creation_date     TIMESTAMP,
    modification_date TIMESTAMP,
    author            VARCHAR(255)

);

CREATE TABLE IF NOT EXISTS EDIT
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    linknum     INT,
    edit_date   TIMESTAMP,
    edited_by   VARCHAR(255),
    before_edit VARCHAR(255),
    after_edit  VARCHAR(255),
    edit_reason VARCHAR(255)
);


