--Atributos de Midia mais categoria


CREATE TABLE Midia (
    id_midia SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao TEXT,
    data_de_lancamento DATE, 
    duracao_segundos INTEGER,
    nacionalidade VARCHAR(50)
);

-- Tabela para armazenar os nomes únicos das Categorias
CREATE TABLE Categoria (
    id_categoria SERIAL PRIMARY KEY,
    nome VARCHAR(100) UNIQUE NOT NULL
);

-- Relação da midia com a categoria
CREATE TABLE Midia_Categoria (
    id_midia INTEGER REFERENCES Midia(id_midia) ON DELETE CASCADE,
    id_categoria INTEGER REFERENCES Categoria(id_categoria) ON DELETE CASCADE,
    PRIMARY KEY (id_midia, id_categoria)
);


--Ator e relação com mídia

CREATE TABLE Ator (
    id_ator SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    data_nascimento DATE,
    local_nascimento VARCHAR(100),
    descricao TEXT
);

CREATE TABLE Atua_Em (
    id_ator INTEGER REFERENCES Ator(id_ator) ON DELETE CASCADE,
    id_midia INTEGER REFERENCES Midia(id_midia) ON DELETE CASCADE,
    PRIMARY KEY (id_ator, id_midia)
);

-- Produtora e relação com midia

CREATE TABLE Produtora (
    id_produtora SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    data_fundacao DATE
);

CREATE TABLE Produz (
    id_produtora INTEGER REFERENCES Produtora(id_produtora) ON DELETE CASCADE,
    id_midia INTEGER REFERENCES Midia(id_midia) ON DELETE CASCADE,
    
    -- A combinação de produtora e mídia é a Chave Primária
    PRIMARY KEY (id_produtora, id_midia)
);

-- Serie
CREATE TABLE Serie (
    id_serie SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    genero VARCHAR(50),
    classificacao_etaria VARCHAR(10)
);

-- Filme
CREATE TABLE Filme (
    id_midia INTEGER PRIMARY KEY REFERENCES Midia(id_midia) ON DELETE CASCADE,
    genero VARCHAR(50),
    classificacao_etaria VARCHAR(10)
);

-- Episodio 

CREATE TABLE Episodio (
    id_midia INTEGER PRIMARY KEY REFERENCES Midia(id_midia) ON DELETE CASCADE,
    id_serie INTEGER NOT NULL REFERENCES Serie(id_serie) ON DELETE CASCADE,
    temporada INTEGER NOT NULL,
    numero_episodio INTEGER NOT NULL,
    
    -- Relacionamento Unário: Aponta para o id_midia do ep anterior
    id_episodio_anterior INTEGER REFERENCES Episodio(id_midia), 
    
    -- Garante que não existam dois episódios com o mesmo número na mesma série e temporada
    CONSTRAINT uk_serie_temporada_episodio UNIQUE (id_serie, temporada, numero_episodio)
);

-- Usuário

CREATE TABLE Usuario (
    id_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL, 
    data_nascimento DATE NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Salva

CREATE TABLE Salva (
    id_usuario INTEGER REFERENCES Usuario(id_usuario) ON DELETE CASCADE,
    id_midia INTEGER REFERENCES Midia(id_midia) ON DELETE CASCADE,
    
    -- A chave primária composta impede que o usuário salve a mesma mídia duas vezes
    PRIMARY KEY (id_usuario, id_midia)
);

--Assiste

CREATE TABLE Assiste (
    id_usuario INTEGER REFERENCES Usuario(id_usuario) ON DELETE CASCADE,
    id_midia INTEGER REFERENCES Midia(id_midia) ON DELETE CASCADE,
    
    progresso_segundos INTEGER DEFAULT 0,
    data_acesso TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status_concluido BOOLEAN DEFAULT FALSE, --Booleano para dizer se terminou de assistir
    
    PRIMARY KEY (id_usuario, id_midia)
);

--Avalia

CREATE TABLE Avalia (
    id_usuario INTEGER REFERENCES Usuario(id_usuario) ON DELETE CASCADE,
    id_midia INTEGER REFERENCES Midia(id_midia) ON DELETE CASCADE,
    
    -- 0 nota negativa, 1 é positiva
    nota INTEGER CHECK (nota IN (0, 1)), 
    
    PRIMARY KEY (id_usuario, id_midia)
);