-- Criação do Banco de Dados
CREATE DATABASE if not exists escola;
USE escola;

-- Tabela Estudante
CREATE TABLE estudante (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE,
    email VARCHAR(100) UNIQUE
);

-- Tabela Disciplina
CREATE TABLE disciplina (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    professor VARCHAR(100)
);

-- Tabela Inscricao
CREATE TABLE inscricao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    estudante_id BIGINT NOT NULL,
    disciplina_id BIGINT NOT NULL,
    data_inscricao DATE,
    CONSTRAINT fk_inscricao_estudante FOREIGN KEY (estudante_id) REFERENCES estudante(id) ON DELETE CASCADE,
    CONSTRAINT fk_inscricao_disciplina FOREIGN KEY (disciplina_id) REFERENCES disciplina(id) ON DELETE CASCADE
);

-- Inserção de Estudantes
INSERT INTO estudante (nome, data_nascimento, email) VALUES 
('João Silva', '2001-05-15', 'joao.silva@gmail.com'),
('Maria Oliveira', '2002-03-22', 'maria.oliveira@gmail.com'),
('Pedro Santos', '2000-07-11', 'pedro.santos@gmail.com'),
('Ana Lima', '2003-01-09', 'ana.lima@gmail.com'),
('Lucas Souza', '2001-11-18', 'lucas.souza@gmail.com'),
('Camila Ferreira', '2002-02-27', 'camila.ferreira@gmail.com'),
('Rafael Mendes', '2000-09-30', 'rafael.mendes@gmail.com'),
('Juliana Costa', '2004-06-12', 'juliana.costa@gmail.com'),
('Gabriel Rocha', '2003-08-14', 'gabriel.rocha@gmail.com'),
('Bianca Almeida', '2001-10-20', 'bianca.almeida@gmail.com');

INSERT INTO disciplina (nome, descricao, professor) VALUES
('Matemática', 'Cálculo e álgebra linear', 'Prof. Carlos Oliveira'),
('Física', 'Mecânica e termodinâmica', 'Prof. João Ferreira'),
('Química', 'Química geral e orgânica', 'Profª. Maria Santos'),
('Biologia', 'Anatomia e genética', 'Profª. Ana Almeida'),
('História', 'História do Brasil e do Mundo', 'Profª. Juliana Souza'),
('Geografia', 'Cartografia e geopolítica', 'Prof. Rafael Lima'),
('Português', 'Gramática e literatura', 'Prof. Gabriel Rocha'),
('Inglês', 'Gramática e conversação', 'Profª. Bianca Costa'),
('Educação Física', 'Práticas esportivas', 'Prof. Lucas Mendes'),
('Arte', 'História da arte e práticas artísticas', 'Profª. Camila Ribeiro');

-- Inserção de Inscrições
INSERT INTO inscricao (estudante_id, disciplina_id, data_inscricao) VALUES
(1, 1, '2024-01-15'),
(1, 2, '2024-01-15'),
(2, 1, '2024-01-16'),
(2, 3, '2024-01-16'),
(3, 4, '2024-01-17'),
(3, 5, '2024-01-17'),
(4, 6, '2024-01-18'),
(4, 7, '2024-01-18'),
(5, 8, '2024-01-19'),
(5, 9, '2024-01-19'),
(6, 10, '2024-01-20'),
(6, 1, '2024-01-20'),
(7, 2, '2024-01-21'),
(7, 3, '2024-01-21'),
(8, 4, '2024-01-22'),
(8, 5, '2024-01-22'),
(9, 6, '2024-01-23'),
(9, 7, '2024-01-23'),
(10, 8, '2024-01-24'),
(10, 9, '2024-01-24');
