use cms_new_th;
DELIMITER //
CREATE PROCEDURE Insert_Customer(IN first_name VARCHAR(255), IN last_name VARCHAR(255))
BEGIN
    INSERT INTO customers(first_name,last_name) VALUES (first_name,last_name);
END//
DELIMITER ;

call Insert_Customer('nguyen','nam');