-- Creation of platform users
CREATE TABLE IF NOT EXISTS end_users (
    user_id SERIAL PRIMARY KEY,
    user_name varchar(250) NOT NULL
);


-- Creation of progress messages table
CREATE TABLE IF NOT EXISTS progress_messages (
    progress_message_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES end_users(user_id),
    message_text varchar(250) NOT NULL
);

-- Creation of performance messages table
CREATE TABLE IF NOT EXISTS performance_messages (
    performance_message_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES end_users(user_id),
    message_text varchar(250) NOT NULL
);