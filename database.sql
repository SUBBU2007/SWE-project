-- Create the users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'user'
);

-- Create the blood_bank table
CREATE TABLE blood_bank (
    id SERIAL PRIMARY KEY,
    hospital VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    blood_group VARCHAR(5) NOT NULL,
    units INT NOT NULL
);

-- Create the lab_tests table
CREATE TABLE lab_tests (
    id SERIAL PRIMARY KEY,
    test_name VARCHAR(100) NOT NULL,
    lab_name VARCHAR(100) NOT NULL,
    cost DECIMAL(10, 2) NOT NULL,
    insurance BOOLEAN DEFAULT false
);

-- Create the surgeons table
CREATE TABLE surgeons (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    hospital VARCHAR(100) NOT NULL,
    location VARCHAR(255),
    contact VARCHAR(100)
);

-- Create the donors table
CREATE TABLE donors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    organ VARCHAR(50) NOT NULL,
    status VARCHAR(20) DEFAULT 'pending'
);

-- Create the assessment_rules table
CREATE TABLE assessment_rules (
    id SERIAL PRIMARY KEY,
    symptom VARCHAR(255) NOT NULL,
    suggestion TEXT NOT NULL
);

-- Insert sample data into the users table
INSERT INTO users (name, email, password, role) VALUES
('Admin User', 'admin@healthcare.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'admin'),
('Regular User', 'user@healthcare.com', '0a041b9462caa4a31bac3567e0b6e6fd9100787db2ab433d96f6d178cabfce90', 'user');

-- Insert sample data into the blood_bank table
INSERT INTO blood_bank (hospital, city, blood_group, units) VALUES
('City Hospital', 'New York', 'A+', 10),
('General Hospital', 'New York', 'O-', 5),
('County Hospital', 'Los Angeles', 'B+', 8);

-- Insert sample data into the lab_tests table
INSERT INTO lab_tests (test_name, lab_name, cost, insurance) VALUES
('MRI Scan', 'City Diagnostics', 300.00, true),
('X-Ray', 'General Labs', 75.50, true),
('Blood Test', 'County Labs', 50.00, false);

-- Insert sample data into the surgeons table
INSERT INTO surgeons (name, specialty, hospital, location, contact) VALUES
('Dr. John Doe', 'Orthopedic', 'City Hospital', '123 Main St, New York', '555-1234'),
('Dr. Jane Smith', 'Cardiology', 'General Hospital', '456 Oak Ave, New York', '555-5678');

-- Insert sample data into the donors table
INSERT INTO donors (name, age, organ, status) VALUES
('Alice Johnson', 35, 'Kidney', 'approved'),
('Bob Williams', 42, 'Liver', 'pending');

-- Insert sample data into the assessment_rules table
INSERT INTO assessment_rules (symptom, suggestion) VALUES
('fever,cough', 'Common Cold or Flu. Rest and drink fluids.'),
('headache,nausea', 'Migraine or Dehydration. Drink water and rest in a dark room.'),
('fever,rash', 'Possible infection. Consult a doctor.');
