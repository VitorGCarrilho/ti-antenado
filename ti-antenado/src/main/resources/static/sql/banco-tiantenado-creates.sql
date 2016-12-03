CREATE DATABASE TI_ANTENADO;

CREATE TABLE TB_USUARIO (
	CD_USUARIO 	INT 			NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NM_USUARIO	VARCHAR(100)	NOT NULL,
    NR_FONE 	VARCHAR(11),
    NR_CEL		VARCHAR(11),
    DS_ENDERECO VARCHAR(100),
    DS_INSTITUICAO	VARCHAR(100),
    DS_EMAIL		VARCHAR(80),
    DT_NASCIMENTO	DATE,
    ID_TIPO_USUARIO	VARCHAR(1) NOT NULL, 
    FOREIGN KEY(ID_TIPO_USUARIO) REFERENCES TB_TIPO_USUARIO(ID_TIPO_USUARIO)
);

CREATE TABLE TB_TIPO_USUARIO (
	ID_TIPO_USUARIO 	VARCHAR(1)	NOT NULL PRIMARY KEY,
    DS_TIPO_USUARIO 	VARCHAR(100) NOT NULL
);

CREATE TABLE TB_CURSO (
	CD_CURSO 		INT 			NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NM_CURSO		VARCHAR(100)	NOT NULL,
    DS_CURSO		VARCHAR(250),
    DT_CURSO		DATE			NOT NULL,
    CD_PROFESSOR	INT 			NOT NULL,
    FOREIGN KEY(CD_PROFESSOR) REFERENCES TB_USUARIO(CD_USUARIO)
);

CREATE TABLE TB_MATRICULA (
	CD_MATRICULA	INT 			NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CD_ALUNO		INT				NOT NULL,
    CD_CURSO		INT 			NOT NULL,
    FOREIGN KEY(CD_ALUNO) 			REFERENCES TB_USUARIO(CD_USUARIO),
    FOREIGN KEY(CD_CURSO) 			REFERENCES TB_CURSO(CD_CURSO)
);
