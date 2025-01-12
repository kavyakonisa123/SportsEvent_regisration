create database sportdb;
use sportdb;

DESCRIBE event;
DESCRIBE player;
DESCRIBE user;


describe TEAM;

INSERT INTO event(event_date, event_name,user_selection_count) VALUES
('2025-03-26', 'IPL 2024 Opening Ceremony',0),
('2025-03-27', 'IPL Match 1: Mumbai Indians vs Chennai Super Kings',0),
('2025-03-28', 'IPL Match 2: Kolkata Knight Riders vs Royal Challengers Bangalore',0),
('2025-03-29', 'IPL Match 3: Sunrisers Hyderabad vs Delhi Capitals',0),
('2025-03-30', 'IPL Match 4: Punjab Kings vs Rajasthan Royals',0),
('2025-03-31', 'IPL Match 5: Gujarat Titans vs Lucknow Super Giants',0),
('2025-04-01', 'IPL Match 6: Mumbai Indians vs Kolkata Knight Riders',0),
('2025-04-02', 'IPL Match 7: Chennai Super Kings vs Sunrisers Hyderabad',0),
('2025-04-03', 'IPL Match 8: Royal Challengers Bangalore vs Delhi Capitals',0),
('2025-04-04', 'IPL Match 9: Rajasthan Royals vs Gujarat Titans',0),
('2025-04-05', 'IPL Match 10: Lucknow Super Giants vs Punjab Kings',0),
('2025-04-06', 'IPL Match 11: Mumbai Indians vs Sunrisers Hyderabad',0),
('2025-04-07', 'IPL Match 12: Chennai Super Kings vs Royal Challengers Bangalore',0),
('2025-04-08', 'IPL Match 13: Kolkata Knight Riders vs Delhi Capitals',0),
('2025-04-09', 'IPL Match 14: Sunrisers Hyderabad vs Rajasthan Royals',0),
('2025-04-10', 'IPL Match 15: Punjab Kings vs Mumbai Indians',0),
('2025-04-11', 'IPL Match 16: Rajasthan Royals vs Chennai Super Kings',0),
('2025-04-12', 'IPL Match 17: Gujarat Titans vs Kolkata Knight Riders',0),
('2025-04-13', 'IPL Match 18: Lucknow Super Giants vs Royal Challengers Bangalore',0),
('2025-04-14', 'IPL Match 19: Delhi Capitals vs Punjab Kings',0);

INSERT INTO team(team_name, user_selection_count, event_id) VALUES
('Mumbai Indians', 0, 2),
('Chennai Super Kings', 0, 2),
('Kolkata Knight Riders', 0, 3),
('Royal Challengers Bangalore', 0, 3),
('Sunrisers Hyderabad', 0, 4),
('Delhi Capitals', 0, 4),
('Punjab Kings', 0, 5),
('Rajasthan Royals', 0, 5),
('Gujarat Titans', 0, 6),
('Lucknow Super Giants', 0, 6),
('Mumbai Indians', 0, 7),
('Kolkata Knight Riders', 0, 7),
('Chennai Super Kings', 0, 8),
('Sunrisers Hyderabad', 0, 8),
('Royal Challengers Bangalore', 0, 9),
('Delhi Capitals', 0, 9),
('Rajasthan Royals', 0, 10),
('Gujarat Titans', 0, 10),
('Lucknow Super Giants', 0, 11),
('Punjab Kings', 0, 11);

INSERT INTO player (player_name, user_selection_count, team_id) VALUES
('Rohit Sharma', 0, 1),
('Jasprit Bumrah', 0, 1),
('MS Dhoni', 0, 2),
('Ravindra Jadeja', 0, 2),
('Eoin Morgan', 0, 3),
('Andre Russell', 0, 3),
('Virat Kohli', 0, 4),
('AB de Villiers', 0, 4),
('Kane Williamson', 0, 5),
('Bhuvneshwar Kumar', 0, 5),
('Rishabh Pant', 0, 6),
('Shikhar Dhawan', 0, 6),
('KL Rahul', 0, 7),
('Mohammed Shami', 0, 7),
('Sanju Samson', 0, 8),
('Jos Buttler', 0, 8),
('Hardik Pandya', 0, 9),
('Rashid Khan', 0, 9),
('Gautam Gambir', 0, 10), 
('Avesh Khan', 0, 10);

INSERT INTO User (email, registration_time, username, visualization_time, event_id,player_id, team_id) VALUES
('venkat.krishna@example.com', '2024-03-29 10:00:00', 'VenkataKrishna', '2024-03-30 15:00:00',1, 1, 1),
('sai.deepika@example.com', '2024-03-28 09:30:00', 'SaiDeepika', '2024-03-29 16:30:00',3, 2, 1),
('naveen.kumar@example.com', '2024-03-27 08:45:00', 'NaveenKumar', '2024-03-28 14:00:00', 2, 3, 2),
('lakshmi.priya@example.com', '2024-03-26 07:15:00', 'LakshmiPriya', '2024-03-27 13:30:00',6, 4, 2),
('harish.reddy@example.com', '2024-03-25 06:30:00', 'HarishReddy', '2024-03-26 12:45:00', 4,5, 3),
('anusha.sharma@example.com', '2024-03-24 05:45:00', 'AnushaSharma', '2024-03-25 11:30:00', 5, 6, 3),
('rajesh.naidu@example.com', '2024-03-23 05:00:00', 'RajeshNaidu', '2024-03-24 10:15:00', 8, 7, 4),
('priyanka.chowdary@example.com', '2024-03-22 04:15:00', 'PriyankaChowdary', '2024-03-23 09:00:00',9, 8, 4),
('suresh.kumar@example.com', '2024-03-21 03:30:00', 'SureshKumar', '2024-03-22 08:45:00',7,  9, 5),
('deepthi.singh@example.com', '2024-03-20 02:45:00', 'DeepthiSingh', '2024-03-21 08:00:00', 7, 10, 5);



select * from User;
select * from player;
select * from event;
select * from team;