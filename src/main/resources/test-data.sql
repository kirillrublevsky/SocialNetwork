INSERT INTO contact (contact_id, first_name, last_name, birth_date) VALUES (1, 'Mike', 'Smith', '1986-06-13');
INSERT INTO contact (contact_id, first_name, last_name, birth_date) VALUES (2, 'Sam', 'Gabby', '1953-01-24');
INSERT INTO contact (contact_id, first_name, last_name, birth_date) VALUES (3, 'Rob', 'Waters', '1967-08-17');

INSERT INTO hobby (hobby_id, title, description) VALUES (1, 'Cycling', 'I like cycling!');
INSERT INTO hobby (hobby_id, title, description) VALUES (2, 'Cooking', 'Cooking delicious meals is awesome');
INSERT INTO hobby (hobby_id, title, description) VALUES (3, 'Singing', 'Singing like a pro!');

INSERT INTO place (place_id, title, description, longitude, latitude) VALUES (1, 'Paris', 'The city of love', 10, 300);
INSERT INTO place (place_id, title, description, longitude, latitude) VALUES (2, 'Kiev', 'The capital of Ukraine', 70, 20);

INSERT INTO message (message_id, from_contact, to_contact, content) VALUES (1, 1, 2, 'Hi, Sam, this is Mike. How are doing?');
INSERT INTO message (message_id, from_contact, to_contact, content) VALUES (2, 2, 1, 'Hi, Mike, I am fine. And you?');

INSERT INTO contact_hobby (contact_id, hobby_id) VALUES (1, 1);
INSERT INTO contact_hobby (contact_id, hobby_id) VALUES (1, 3);
INSERT INTO contact_hobby (contact_id, hobby_id) VALUES (2, 2);
INSERT INTO contact_hobby (contact_id, hobby_id) VALUES (3, 1);
INSERT INTO contact_hobby (contact_id, hobby_id) VALUES (3, 2);
INSERT INTO contact_hobby (contact_id, hobby_id) VALUES (3, 3);

INSERT INTO contact_place (contact_id, place_id) VALUES (1, 1);
INSERT INTO contact_place (contact_id, place_id) VALUES (1, 2);
INSERT INTO contact_place (contact_id, place_id) VALUES (2, 1);

INSERT INTO contact_friend (contact_id, friend_id) VALUES (1, 3);
INSERT INTO contact_friend (contact_id, friend_id) VALUES (3, 1);
INSERT INTO contact_friend (contact_id, friend_id) VALUES (3, 2);
INSERT INTO contact_friend (contact_id, friend_id) VALUES (2, 3);














