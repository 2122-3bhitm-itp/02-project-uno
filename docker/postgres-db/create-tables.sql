CREATE TABLE player (
    PlayerId int PRIMARY KEY,
    name varchar(50) unique not null
);

CREATE TABLE game (
    GameId int PRIMARY KEY,
    PlayerId int not null,
    FOREIGN KEY (PlayerId) REFERENCES player (PlayerId)
);

CREATE TABLE question (
    QuestionId int PRIMARY KEY,
    question varchar(256) not null,
    difficulty int
);

CREATE TABLE answer (
    AnswerId int PRIMARY KEY,
    answer varchar(256) not null,
    iscorrect bool not null,
    worth int not null
);

CREATE TABLE game_question (
    GameQuestionId int not null PRIMARY KEY,
    GameId int not null,
    QuestionId int not null,
    answeredFrom int not null,
    FOREIGN KEY (answeredFrom) references player (PlayerId),
    FOREIGN KEY (GameId) REFERENCES game (GameId),
    FOREIGN KEY (QuestionId) REFERENCES question(QuestionId)
);

CREATE TABLE question_answer (
    QuestionId int not null,
    AnswerId int not null,
    PRIMARY KEY (QuestionId, AnswerId),
    FOREIGN KEY (QuestionId) REFERENCES question (QuestionId),
    FOREIGN KEY (AnswerId) REFERENCES answer (AnswerId)
);

CREATE TABLE answered (
    Game_QuestionId int not null,
    AnswerId int not null,
    PRIMARY KEY (Game_QuestionId, AnswerId),
    FOREIGN KEY (Game_QuestionId) REFERENCES game_question (GameQuestionId),
    FOREIGN KEY (AnswerId) REFERENCES answer (AnswerId)
);