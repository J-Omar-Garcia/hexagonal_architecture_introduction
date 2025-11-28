DROP TABLE IF EXISTS products;

-- Create the product table
CREATE TABLE products (
                          id UUID PRIMARY KEY,
                          product_id VARCHAR(50),
                          name VARCHAR(100),
                          description TEXT,
                          price DOUBLE PRECISION,
                          currency VARCHAR(1)
);

CREATE INDEX idx_productId ON products (product_id);


INSERT INTO products (id, product_id, name, description, price, currency) VALUES
                                                                             ('550e8400-e29b-41d4-a716-446655440003', 'camiseta-333', 'Camiseta roja', 'Camiseta roja xl', 30.0, '€'),
                                                                             ('550e8400-e29b-41d4-a716-446655440004', 'vaquero-555', 'Pantalón vaquero', 'Denim Vaquero Talla L', 40.0, '$');
