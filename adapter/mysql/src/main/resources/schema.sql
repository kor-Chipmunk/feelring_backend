CREATE TABLE users
(
    id          INT AUTO_INCREMENT PRIMARY KEY COMMENT '사용자의 id',
    email       VARCHAR(100) NOT NULL COMMENT '사용자의 이메일',
    password    VARCHAR(100) NOT NULL COMMENT '사용자의 비밀번호',
    role        VARCHAR(100) NOT NULL COMMENT '사용자의 역할',
    nickname    VARCHAR(100) NOT NULL COMMENT '사용자의 별명',
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '사용자의 생성일시',
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '사용자의 수정일시',
    deleted_at  TIMESTAMP COMMENT '사용자 삭제일시(미삭제 시 NULL)'
);

CREATE TABLE diary
(
    id          INT AUTO_INCREMENT PRIMARY KEY COMMENT '다이어리의 id',
    content     TEXT NOT NULL COMMENT '다이어리 내용',
    user_id     INT NOT NULL COMMENT '다이어리의 작성자 user id',
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '다이어리의 생성일시',
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '다이어리의 수정일시',
    deleted_at  TIMESTAMP COMMENT '다이어리 삭제일시(미삭제 시 NULL)'
);
