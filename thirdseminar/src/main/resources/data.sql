INSERT INTO MEMBER(ID, NAME, NICKNAME, AGE, PART, GENERATION)
VALUES (1, '최윤한', '유난', 20, 'SERVER', 33),
       (2, '정준서', 'DDD', 24, 'SERVER', 33),
       (3, '김해린', '멜로니', 26, 'PLAN', 33),
       (4, '이태희', '티벳여우', 25, 'ANDROID', 33);


INSERT INTO POST(ID, TITLE, CONTENT, MEMBER_ID)
VALUES
    (1, '안녕하세요 제목1', '안녕하세요 내용1', 1),
    (2, '안녕하세요 제목2', '안녕하세요 내용2', 1),
    (3, '안녕하세요 제목3', '안녕하세요 내용3', 1),
    (4, '반갑습니다 제목4', '반갑습니다', 2),
    (5, '안녕하세요 제목5', '안녕하세요', 3);