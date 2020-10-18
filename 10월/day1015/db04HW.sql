-- 주문
CREATE TABLE `orders` (
	`orderno`     INT     NOT NULL, -- 주문번호
	`order_price` INT     NOT NULL, -- 주문금액
	`payment`     BOOLEAN NULL     DEFAULT false, -- 결제여부
	`delivery`    BOOLEAN NULL     DEFAULT false, -- 배송여부
	`userno`      INT     NOT NULL, -- 고객번호
	`productno`   INT     NOT NULL  -- 상품번호
);

-- 주문
ALTER TABLE `orders`
	ADD CONSTRAINT `PK_orders` -- 주문 기본키
		PRIMARY KEY (
			`orderno` -- 주문번호
		);

ALTER TABLE `orders`
	MODIFY COLUMN `orderno` INT NOT NULL AUTO_INCREMENT;

-- 상품
CREATE TABLE `products` (
	`productno`        INT         NOT NULL, -- 상품번호
	`product_name`     VARCHAR(30) NULL,     -- 상품명
	`product_price`    INT         NULL,     -- 가격
	`product_quantity` INT         NULL      -- 수량
);

-- 상품
ALTER TABLE `products`
	ADD CONSTRAINT `PK_products` -- 상품 기본키
		PRIMARY KEY (
			`productno` -- 상품번호
		);

-- 고객
CREATE TABLE `users` (
	`userno`       INT         NOT NULL, -- 고객번호
	`user_name`    VARCHAR(20) NOT NULL, -- 고객명
	`user_address` VARCHAR(50) NOT NULL, -- 고객주소
	`user_phone1`  VARCHAR(20) NOT NULL, -- 고객 연락처1
	`user_phone2`  VARCHAR(20) NULL      -- 고객 연락처2
);

-- 고객
ALTER TABLE `users`
	ADD CONSTRAINT `PK_users` -- 고객 기본키
		PRIMARY KEY (
			`userno` -- 고객번호
		);

-- 주문
ALTER TABLE `orders`
	ADD CONSTRAINT `FK_users_TO_orders` -- 고객 -> 주문
		FOREIGN KEY (
			`userno` -- 고객번호
		)
		REFERENCES `users` ( -- 고객
			`userno` -- 고객번호
		);

-- 주문
ALTER TABLE `orders`
	ADD CONSTRAINT `FK_products_TO_orders` -- 상품 -> 주문
		FOREIGN KEY (
			`productno` -- 상품번호
		)
		REFERENCES `products` ( -- 상품
			`productno` -- 상품번호
		);