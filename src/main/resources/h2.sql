-- Please run this query to have the necessery table in your h2 db thanks
CREATE TABLE NOTE
(
    id integer not null,
    title char(255),
    content char(255),
    creation_date datetime,
    modification_date datetime,
    author char(255)
)
