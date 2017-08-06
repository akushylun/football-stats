
DROP TABLE IF EXISTS team;

CREATE TABLE team (
  id INT PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  gamesWon INT NOT NULL,
  gamesLost INT NOT NULL,
  gamesDraw INT NOT NULL
); 

CREATE TABLE account (
	id INT PRIMARY KEY, 
	password VARCHAR(64) NOT NULL, 
	username VARCHAR(64) NOT NULL
	);

INSERT into `team` values (1, 'Manchester', 10, 2, 5);
INSERT into `team` values (2, 'Chelsea', 9, 3, 5);
INSERT into `team` values (3, 'Arsenal', 6, 4, 7);

INSERT into `account` values (1, 'pass', 'admin');

