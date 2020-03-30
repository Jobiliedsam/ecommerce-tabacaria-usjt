CREATE DATABASE IF NOT EXISTS Tabacaria
DEFAULT CHARACTER SET UTF8
DEFAULT COLLATE UTF8_GENERAL_CI;

USE Tabacaria;

# Deletando as tabelas para que sempre receba as novas alterações
DROP TABLE IF EXISTS Endereco;
DROP TABLE IF EXISTS Pedido_Line;
DROP TABLE IF EXISTS Pedido_Header;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Produto;
DROP TABLE IF EXISTS Categoria;
DROP TABLE IF EXISTS Fornecedor;
DROP TABLE IF EXISTS Usuario;

CREATE TABLE IF NOT EXISTS Cliente (

    Id_Cliente      INT PRIMARY KEY AUTO_INCREMENT, 
    Nome_Completo   VARCHAR(70) NOT NULL,
    Telefone        CHAR(12),
    Celular         CHAR(13)	NOT NULL,
    CPF             CHAR(11) 	NOT NULL,
    Genero          ENUM('F' , 'M'),
    Tipo            VARCHAR(10),
    Email           VARCHAR(40) NOT NULL,
    Data_Nascimento  DATE NOT NULL,
    
    INDEX (Nome_Completo)
    
) DEFAULT CHARSET = UTF8;


CREATE TABLE IF NOT EXISTS Endereco (

    Id_Endereco         INT PRIMARY KEY AUTO_INCREMENT,
    Id_Cliente          INT UNIQUE,
    Endereco_Principal  VARCHAR(50) NOT NULL, 
    Endereco_Secundario VARCHAR(50),
    CEP                 CHAR(8) NOT NULL,
    Cidade              VARCHAR(20),
    Estado              CHAR(2),
    Complemento         LONGTEXT,
    
    CONSTRAINT fk_id_cliente FOREIGN KEY(Id_Cliente) REFERENCES Cliente(Id_Cliente)
    
) DEFAULT CHARSET = UTF8;


CREATE TABLE IF NOT EXISTS Categoria (

    Id_Categoria            INT PRIMARY KEY AUTO_INCREMENT,
    Nome_Categoria          VARCHAR(30) NOT NULL,
    Status_Categoria        ENUM ('Ativo' , 'Inativo') NOT NULL,
    Descricao               LONGTEXT NOT NULL,
    
    INDEX (Nome_Categoria)
    
) DEFAULT CHARSET = UTF8;


CREATE TABLE IF NOT EXISTS Produto (

    Id_Produto              INT PRIMARY KEY AUTO_INCREMENT,
    Nome_Produto            VARCHAR(45) NOT NULL,
    Nome_Categoria          VARCHAR(30) NOT NULL,
    Preco					NUMERIC NOT NULL,
    Fornecedor        		VARCHAR(120) NOT NULL,
    Status_Produto          ENUM ('Ativo', 'Inativo') NOT NULL,
    Descricao               LONGTEXT NOT NULL,
    
    # Criando os indexs
    INDEX (Nome_Produto),
    INDEX (Preco),
    
    # Chave Estrangeira
    CONSTRAINT fk_nome_categoria FOREIGN KEY (Nome_Categoria) REFERENCES Categoria(Nome_Categoria),
    
    # Validadores
    CONSTRAINT chk_preco CHECK (Preco >= 0)
    
) DEFAULT CHARSET = UTF8;


CREATE TABLE IF NOT EXISTS Pedido_Header (

    Id_Pedido          	INT PRIMARY KEY AUTO_INCREMENT,
    Id_Cliente			INT,
    Data_Hora           DATETIME DEFAULT NOW(),
    Nome_Cliente        VARCHAR(70),
    Quantidade_Total    INT NOT NULL,
    Valor_Total 		NUMERIC NOT NULL,
    
    # Chaves estrangeiras
    CONSTRAINT fk_id_cliente_header 	FOREIGN KEY(Id_Cliente) 	REFERENCES Cliente(Id_Cliente),
    CONSTRAINT fk_nome_cliente 			FOREIGN KEY(Nome_Cliente) 	REFERENCEs Cliente(Nome_Completo),
    
    # Validadores
    CONSTRAINT chk_quantidade_total CHECK (Quantidade_Total > 0),
    CONSTRAINT chk_valor_total 		CHECK (Valor_Total > 0 )

) DEFAULT CHARSET = UTF8;

CREATE TABLE Pedido_Line (
    Id_Pedido_Line          INT PRIMARY KEY AUTO_INCREMENT,
    Id_Pedido_Header		INT,
    Id_Produto				INT,
    Quantidade_Produto      INT DEFAULT '1',
    Valor_Produto           NUMERIC NOT NULL,
    Nome_Produto            VARCHAR(45) NOT NULL,
    Preco_Unitario 			NUMERIC NOT NULL,
    
    # Chaves Estrangeiras
    CONSTRAINT fk_id_pedido_header 	FOREIGN KEY (Id_Pedido_Header) 	REFERENCES Pedido_Header(Id_Pedido),
    CONSTRAINT fk_id_produto 		FOREIGN KEY (Id_Produto) 		REFERENCES Produto(Id_Produto), 
    CONSTRAINT fk_id_nome_produto	FOREIGN KEY (Nome_Produto) 		REFERENCES Produto(Nome_Produto),
    CONSTRAINT fk_id_preco_unitario FOREIGN KEY (Preco_Unitario)	REFERENCES Produto(Preco),
    
    # Validadores
    CONSTRAINT chk_quantidade_produto CHECK (Quantidade_Produto >= 1),
    CONSTRAINT chk_valor_produto CHECK (Valor_Produto = (Quantidade_Produto * Preco_Unitario))
    
) DEFAULT CHARSET = UTF8; 

CREATE TABLE IF NOT EXISTS Fornecedor (

    Id_Fornecedor       INT PRIMARY KEY AUTO_INCREMENT,
    Nome_Fornecedor     VARCHAR (40) NOT NULL,
    Nome_Categoria      VARCHAR(30) NOT NULL,
    Cnpj                CHAR(20) NOT NULL,
    Telefone            CHAR (12),
    Email               VARCHAR(40) NOT NULL,
    Descricao           VARCHAR (100)

) Default Charset = UTF8;

CREATE TABLE IF NOT EXISTS Usuario (

    Id_Uuario INT PRIMARY KEY AUTO_INCREMENT,
    Nome_Usuario VARCHAR (15) NOT NULL,
    Senha VARCHAR(20) NOT NULL,
    Tipo_Usuario CHAR(1) NOT NULL
    
) Default Charset = UTF8;