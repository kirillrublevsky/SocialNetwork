DROP TABLE IF EXISTS contact;
DROP TABLE IF EXISTS place;
DROP TABLE IF EXISTS hobby;
DROP TABLE IF EXISTS contact_hobby;
DROP TABLE IF EXISTS contact_place;


CREATE TABLE contact (
       contact_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
     , first_name VARCHAR(99) NOT NULL
     , last_name VARCHAR(99) NOT NULL
     , birth_date DATE NOT NULL
);

CREATE TABLE place (
       place_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
     , title VARCHAR(99) NOT NULL
     , description VARCHAR(99) NOT NULL
     , longitude DOUBLE
     , latitude DOUBLE
);

CREATE TABLE hobby (
       hobby_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
     , title VARCHAR(99) NOT NULL
     , description VARCHAR(99) NOT NULL
);

CREATE TABLE message (
    message_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
  , date DATETIME NOT NULL DEFAULT NOW()
  , from_contact INT NOT NULL
  , to_contact INT NOT NULL
  , content VARCHAR(99) NOT NULL
  , FOREIGN KEY (from_contact) REFERENCES contact (contact_id)
);

CREATE TABLE contact_hobby (
       contact_id INT NOT NULL
     , hobby_id INT NOT NULL
     , PRIMARY KEY (contact_id, hobby_id)
     , FOREIGN KEY (contact_id) REFERENCES contact (contact_id)
     , FOREIGN KEY (hobby_id) REFERENCES hobby (hobby_id)
);

CREATE TABLE contact_place (
       contact_id INT NOT NULL
     , place_id INT NOT NULL
     , PRIMARY KEY (contact_id, place_id)
     , FOREIGN KEY (contact_id) REFERENCES contact (contact_id)
     , FOREIGN KEY (place_id) REFERENCES place (place_id)
);

CREATE TABLE contact_friend (
    contact_id INT NOT NULL
  , friend_id INT NOT NULL
  , PRIMARY KEY (contact_id, friend_id)
  , FOREIGN KEY (contact_id) REFERENCES contact (contact_id)
  , FOREIGN KEY (friend_id) REFERENCES contact (contact_id)
);





