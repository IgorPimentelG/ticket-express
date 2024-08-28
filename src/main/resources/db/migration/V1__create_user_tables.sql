CREATE TABLE tb_clients(
    id UUID NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    phone CHAR(15) UNIQUE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    CPF CHAR(14) UNIQUE NOT NULL,
    birth_date DATE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NULL,

    CONSTRAINT pk_clients PRIMARY KEY (id)
);

CREATE TABLE tb_administrators(
    id UUID NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    photo VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NULL,

  CONSTRAINT pk_administrators PRIMARY KEY (id)
);