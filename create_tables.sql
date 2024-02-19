-- Creation of platform users
CREATE TABLE IF NOT EXISTS end_users (
    user_id SERIAL PRIMARY KEY,
    user_name varchar(250) NOT NULL
);


-- Creation of progress messages table
CREATE TABLE IF NOT EXISTS progress_messages (
    progress_message_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES end_users(user_id),
    epochs_completed BIGINT,
    total_epochs BIGINT,
    number_of_days INT,
    number_of_minutes INT,
    number_of_hours INT
);

-- Creation of performance messages table
CREATE TABLE IF NOT EXISTS performance_messages (
    performance_message_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES end_users(user_id),
    model_accuracy NUMERIC(5,3),
    model_precision NUMERIC(5,3),
    model_recall NUMERIC(5,3),
    model_fmeasure NUMERIC(5,3)
);