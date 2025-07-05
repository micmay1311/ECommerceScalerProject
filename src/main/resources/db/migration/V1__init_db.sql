CREATE TABLE category (
    id UUID PRIMARY KEY NOT NULL,
    category_name VARCHAR(255)
);

CREATE TABLE price (
    id UUID PRIMARY KEY NOT NULL,
    currency VARCHAR(50),
    amount DOUBLE PRECISION,
    discount DOUBLE PRECISION
);

CREATE TABLE product (
    id UUID PRIMARY KEY NOT NULL,
    title VARCHAR(255),
    price_id UUID UNIQUE,  -- OneToOne
    category_id UUID,      -- ManyToOne
    description TEXT,
    image VARCHAR(512),
    CONSTRAINT fk_price FOREIGN KEY (price_id) REFERENCES price(id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE ecom_order (
    id UUID PRIMARY KEY NOT NULL
);

CREATE TABLE ecom_order_products (
    ecom_order_id UUID NOT NULL,
    products_id UUID NOT NULL,
    PRIMARY KEY (ecom_order_id, products_id),
    CONSTRAINT fk_order FOREIGN KEY (ecom_order_id) REFERENCES ecom_order(id),
    CONSTRAINT fk_product FOREIGN KEY (products_id) REFERENCES product(id)
);