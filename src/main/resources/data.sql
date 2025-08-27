-- Please run this query to have the necessery table in your h2 db thanks
CREATE TABLE IF NOT EXISTS NOTE (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    title VARCHAR(255),
                                    content VARCHAR(255),
                                    creation_date TIMESTAMP,
                                    modification_date TIMESTAMP,
                                    author VARCHAR(255)
);


select * from NOTE
