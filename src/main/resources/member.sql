CREATE TABLE member
(

    id BIGINT(20) NOT NULL AUTO_INCREMENT -- pk

    , userId VARCHAR(50) NOT NULL -- 아이디

    , password VARCHAR(50) NOT NULL -- 비밀번호

    , name VARCHAR(50) NOT NULL -- 이름

    , nickname VARCHAR(50) NOT NULL -- 닉네임

    , phone VARCHAR(50) NOT NULL -- 전화번호

    , address VARCHAR(50) DEFAULT NULL -- 주소

    , addressDetail VARCHAR(50) DEFAULT NULL -- 상세주소

    , email VARCHAR(50) NOT NULL -- 이메일

    , gender VARCHAR(50) DEFAULT NULL -- 성별

    , sns VARCHAR(50) DEFAULT NULL -- 소셜 네트워크

    , birth VARCHAR(50) DEFAULT NULL -- 생일

    , indate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() -- 회원 생성일시

    , isMember VARCHAR(25) DEFAULT 'Y' -- 회원 여부

    , role VARCHAR(20) DEFAULT 'ROLE_USER' -- 권한 (일반유저 or Admin or Manager)

    , PRIMARY KEY (id)

);